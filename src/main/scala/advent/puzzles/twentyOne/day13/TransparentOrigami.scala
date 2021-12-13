package advent.puzzles.twentyOne.day13

import advent.utils._

trait Instruction
case class FoldHorizontal(line: Int) extends Instruction
case class FoldVertical(line: Int) extends Instruction

object TransparentOrigami {
  def part1(input: IndexedSeq[IndexedSeq[String]]): Int = {
    val grid = toGridFromPoints[String](input(0))
    val instructions = toInstructions(input(1))
    
    grid.gridFold(instructions(0)).size
  }
  
  def part2(input: IndexedSeq[IndexedSeq[String]]): Int = {
    val grid = toGridFromPoints[String](input(0))
    val instructions = toInstructions(input(1))
    val finalGrid = instructions.foldLeft(grid)((g, next) => g.gridFold(next))
    finalGrid.size
  }

  extension(grid: Grid[String]) {
    def gridFold(instruction: Instruction): Grid[String] = {
      instruction match {
        case FoldHorizontal(line) => foldHorizontal(line)
        case FoldVertical(line) => foldVertical(line)
      }
    }

    private def foldHorizontal(line: Int): Grid[String] = {
      grid.map((point, value) => {
        if (point.row > line) {
          (Point(line - (point.row - line), point.col), value)
        } else {
          (point, value)
        }
      }).asInstanceOf[Grid[String]]
    }

    private def foldVertical(line: Int): Grid[String] = {
      grid.map((point, value) => {
        if (point.col > line) {
          (Point(point.row, line - (point.col - line)), value)
        } else {
          (point, value)
        }
      }).asInstanceOf[Grid[String]]
    } 
  }

  private def toInstructions(input: IndexedSeq[String]): Seq[Instruction] = {
    input.drop(2).grouped(3).map(_.head).map(instruction => {
      val split = instruction.split("=")
      split(0) match {
        case "x" => FoldVertical(split(1).toInt)
        case "y" => FoldHorizontal(split(1).toInt)
      } 
    }).toSeq
  }
}
