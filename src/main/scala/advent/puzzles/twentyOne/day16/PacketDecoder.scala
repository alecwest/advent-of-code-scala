package advent.puzzles.twentyOne.day16

import cats.syntax.group
import scala.collection.mutable.ListBuffer

object PacketDecoder {
  def part1(input: String): BigInt = {
    val binary = toBinaryNoTruncate(input)

    def parse(input: String, accumulator: Int = 0): (Int, Int, List[BigInt]) = { // bits parsed, version, parsed values
      def parseLiteral(input: String): (Int, Int, List[BigInt]) = { // (bits parsed, literal value)
        val grouped = input.grouped(5).toList
        val numGroups =
          (grouped.zipWithIndex.find(_._1.charAt(0) == '0').get._2 + 1)
        val literal =
          BigInt(grouped.take(numGroups).map(_.tail).mkString, 2)
        (numGroups * 5, 0, List(literal))
      }

      def parseNonLiteral(input: String): (Int, Int, List[BigInt]) = { // bits parsed, version, parsed values
        val mode = input.substring(0, 1)
        mode.toInt match {
          case 0 => {
            val substring = input.substring(1, 16)
            val subPacketsLength = Integer.parseInt(substring, 2)

            var notYetParsed: String =
              input.substring(16, 16 + subPacketsLength)
            var bitsParsed = 0
            var internalAcc = 0
            val buffer: ListBuffer[BigInt] = ListBuffer.empty
            while (bitsParsed < subPacketsLength) {
              val res = parse(notYetParsed)
              notYetParsed = notYetParsed.substring(res._1)
              bitsParsed += res._1
              internalAcc += res._2
              buffer.addAll(res._3)
            }
            (16 + subPacketsLength, internalAcc, buffer.toList)
          }
          case 1 => {
            val numSubPackets = Integer.parseInt(input.substring(1, 12), 2)
            var notYetParsed: String = input.substring(12)
            var bitsParsed = 0
            var internalAcc = 0
            val buffer: ListBuffer[BigInt] = ListBuffer.empty
            for (_ <- 1 to numSubPackets) {
              val res = parse(notYetParsed)
              notYetParsed = notYetParsed.substring(res._1)
              bitsParsed += res._1
              internalAcc += res._2
              buffer.addAll(res._3)
            }
            (12 + bitsParsed, internalAcc, buffer.toList)
          }
          case _ => throw new Exception("impossible")
        }
      }

      val version = Integer.parseInt(input.substring(0, 3), 2)
      val packetType = Integer.parseInt(input.substring(3, 6), 2)
      val minusVersionAndType = input.substring(6)

      val retval = packetType match {
        case 4 => {
          parseLiteral(minusVersionAndType)
        }
        case operator: Int if (operator != 4 && operator >= 0 && operator < 8) => {
          val packets = parseNonLiteral(minusVersionAndType)
          operator match {
            case 0 => {
              (packets._1, packets._2, List(packets._3.sum))
            }
            case 1 => {
              (packets._1, packets._2, List(packets._3.product))
            }
            case 2 => {
              (packets._1, packets._2, List(packets._3.min))
            }
            case 3 => {
              (packets._1, packets._2, List(packets._3.max))
            }
            case 5 => {
              (packets._1, packets._2, List(if (packets._3(0) > packets._3(1)) BigInt(1) else BigInt(0)))
            }
            case 6 => {
              (packets._1, packets._2, List(if (packets._3(0) < packets._3(1)) BigInt(1) else BigInt(0)))
            }
            case 7 => {
              (packets._1, packets._2, List(if (packets._3(0) == packets._3(1)) BigInt(1) else BigInt(0)))
            }
          }
        }
        case _ => throw new Exception("impossible")
      }

      // (retval._1 + 6, retval._2 + version, retval._3) // part 1
      (retval._1 + 6, retval._2, retval._3) // part 1
    }

    parse(binary)._3(0)
  }

  private def toBinaryNoTruncate(hex: String): String = {
    hex
      .map(_ match {
        case '0' => "0000"
        case '1' => "0001"
        case '2' => "0010"
        case '3' => "0011"
        case '4' => "0100"
        case '5' => "0101"
        case '6' => "0110"
        case '7' => "0111"
        case '8' => "1000"
        case '9' => "1001"
        case 'A' => "1010"
        case 'B' => "1011"
        case 'C' => "1100"
        case 'D' => "1101"
        case 'E' => "1110"
        case 'F' => "1111"
        case _   => throw new Exception("impossible")
      })
      .mkString
  }
}
