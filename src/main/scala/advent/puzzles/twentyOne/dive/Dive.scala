package advent.puzzles.twentyOne.dive

sealed case class Position(depth: Int, horizontal: Int, aim: Int = 0)

object Dive {
  def dive(input: IndexedSeq[String]): Int = {
    val position = input
      .map(instruction => {
        val Array(direction, num) = instruction.split(" ")
        direction match {
          case "forward" => Position(0, num.toInt)
          case "down"    => Position(num.toInt, 0)
          case "up"      => Position(-num.toInt, 0)
          case _ => throw new Exception(s"cannot parse given instruction")
        }
      })
      .fold[Position](Position(0, 0))((current, nextInstruction) => {
        Position(
          current.depth + nextInstruction.depth,
          current.horizontal + nextInstruction.horizontal
        )
      })
    position.depth * position.horizontal
  }

  def diveWithAim(input: IndexedSeq[String]): Int = {
    val position = input
      .map(instruction => {
        val Array(direction, num) = instruction.split(" ")
        val units = num.toInt
        direction match {
          case "forward" => Position(0, units, 0)
          case "down"    => Position(0, 0, units)
          case "up"      => Position(0, 0, -units)
          case _ => throw new Exception(s"cannot parse given instruction")
        }
      })
      .fold[Position](Position(0, 0, 0))((current, nextInstruction) => {
        Position(
          if (nextInstruction.horizontal > 0)
            current.depth + current.aim * nextInstruction.horizontal
          else current.depth,
          current.horizontal + nextInstruction.horizontal,
          current.aim + nextInstruction.aim
        )
      })
    position.depth * position.horizontal
  }
}
