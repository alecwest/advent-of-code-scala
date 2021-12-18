package advent.puzzles.twentyOne.day16

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers
import advent.utils.InputParser
import scala.io.Source

// 110100101111111000101000
val input1 = "D2FE28"

// 00111000000000000110111101000101001010010001001000000000
// VVVTTTILLLLLLLLLLLLLLLAAAAAAAAAAABBBBBBBBBBBBBBBB
val input2 = "38006F45291200"

// 11101110000000001101010000001100100000100011000001100000
// VVVTTTILLLLLLLLLLLAAAAAAAAAAABBBBBBBBBBBCCCCCCCCCCC
val input3 = "EE00D40C823060"

// 100010100000000001001010100000000001101010000000000000101111010001111000
// VVVTTTILLLLLLLLLLLVVVTTTILLLLLLLLLLLVVVTTTILLLLLLLLLLLLLLLVVVTTTAAAAA
val input4 = "8A004A801A8002F478"

// 01100010000000001000000000000000000101100001000101010110001011001000100000000010000100011000111000110100
// VVVTTTILLLLLLLLLLLVVVTTTILLLLLLLLLLLLLLLVVVTTTAAAAAVVVTTTBBBBBVVVTTTILLLLLLLLLLLVVVTTTAAAAAVVVTTTBBBBB
val input5 = "620080001611562C8802118E34"
val input6 = "C0015000016115A2E0802F182340"
val input7 = "A0016C880162017C3686B18A3D4780"


class PacketDecoderTest extends AnyWordSpec with Matchers {
  "PacketDecoder" when {
    // "part1-1" in {
    //   PacketDecoder.part1(
    //     input1
    //   ) should be(6)
    // }

    // "part1-2" in {
    //   PacketDecoder.part1(
    //     input2
    //   ) should be(9)
    // }

    // "part1-3" in {
    //   PacketDecoder.part1(
    //     input3
    //   ) should be(14)
    // }

    // "part1-4" in {
    //   PacketDecoder.part1(
    //     input4
    //   ) should be(16)
    // }

    // "part1-5" in {
    //   PacketDecoder.part1(
    //     input5
    //   ) should be(12)
    // }

    // "part1-6" in {
    //   PacketDecoder.part1(
    //     input6
    //   ) should be(23)
    // }

    // "part1-7" in {
    //   PacketDecoder.part1(
    //     input7
    //   ) should be(31)
    // }

    // "part1 more input" in {
    //   PacketDecoder.part1(
    //     Source.fromResource("twentyOne/day16.txt").mkString
    //   ) should be(886)
    // }

    "part2-1" in {
      PacketDecoder.part1(
        // 1100001000000000101101000000101010000010
        "C200B40A82"
      ) should be(3)
    }

    "part2-2" in {
      PacketDecoder.part1(
        "04005AC33890"
      ) should be(54)
    }

    "part2-3" in {
      PacketDecoder.part1(
        "880086C3E88112"
      ) should be(7)
    }

    "part2-4" in {
      PacketDecoder.part1(
        "CE00C43D881120"
      ) should be(9)
    }

    "part2-5" in {
      PacketDecoder.part1(
        "D8005AC2A8F0"
      ) should be(1)
    }

    "part2-6" in {
      PacketDecoder.part1(
        "F600BC2D8F"
      ) should be(0)
    }

    "part2-7" in {
      PacketDecoder.part1(
        "9C005AC2F8F0"
      ) should be(0)
    }

    "part2-8" in {
      PacketDecoder.part1(
        // 10011100000000010100000100001000000000100101000000110010000011110001100000000010000100000100101000001000
        // VVVTTTILLLLLLLLLLLLLLLVVVTTTILLLLLLLLLLLVVVTTTAAAAAVVVTTTBBBBBVVVTTTILLLLLLLLLLLVVVTTTCCCCCVVVTTTDDDDD
        "9C0141080250320F1802104A08"
      ) should be(1)
    }

    "part2 more input" in {
      PacketDecoder.part1(
        Source.fromResource("twentyOne/day16.txt").mkString
      ) should be(BigInt("184487454837"))
    }
  }
}
