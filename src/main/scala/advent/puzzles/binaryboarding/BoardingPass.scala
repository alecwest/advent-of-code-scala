package advent.puzzles.binaryboarding

import scala.util.control.NonFatal

sealed case class BoardingPass(row: Int, column: Int, seatID: Int)

object BoardingPass {
  def fromString(s: String): Option[BoardingPass] = {
    try {
      val row = s
        .substring(0, 7)
        .map {
          case 'F' => 0
          case 'B' => 1
          case _   => throw new Exception()
        }
        .reduce((sum: Int, next: Int) => (sum << 1) | next)
      val column = s
        .substring(7)
        .map {
          case 'L' => 0
          case 'R' => 1
          case _   => throw new Exception()
        }
        .reduce((sum: Int, next: Int) => (sum << 1) | next)
      Some(
        BoardingPass(
          row,
          column,
          row * 8 + column
        )
      )
    } catch {
      case NonFatal(ex) => None
    }
  }
}
