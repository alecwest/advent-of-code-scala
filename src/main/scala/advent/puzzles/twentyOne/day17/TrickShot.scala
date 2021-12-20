package advent.puzzles.twentyOne.day17

import scala.collection.mutable.ListBuffer
import advent.utils.Point

case class Target(col: Range, row: Range)

object TrickShot {
  def part1(input: String): Int = {
    simulate(input).max
  }
  
  def part2(input: String): Int = {
    simulate(input).count(_ > Integer.MIN_VALUE)
  }
  
  private def simulate(input: String): List[Int] = {
    val target = getTarget(input)
    (target.row.start to 100).map(i => {
      (0 to target.col.end).map(j => {
        shoot(Point(i, j), target)
      })
    }).flatten.toList
  }

  private def getTarget(input: String): Target = {
    val r = "-?\\d+".r
    val numbers = r.findAllIn(input).map(_.toInt).toList
    Target(numbers(0) to numbers(1), numbers(2) to numbers(3))
  }

  private def shoot(initialVelocity: Point, target: Target): Int = {
    val velocities: ListBuffer[Point] = ListBuffer(initialVelocity)
    val points: ListBuffer[Point] = ListBuffer(Point(initialVelocity.row, initialVelocity.col))
    while (!overshot(points.last, target) && !landed(points.last, target)) {
      velocities.addOne(Point(velocities.last.row - 1, Math.max(0, velocities.last.col - 1)))
      points.addOne(Point(points.last.row + velocities.last.row, points.last.col + velocities.last.col))
    }

    if (landed(points.last, target)) {
      points.toList.maxBy(_.row).row
    } else { 
      Integer.MIN_VALUE
    }
  }

  private def overshot(point: Point, target: Target): Boolean = {
    point.col > target.col.end || point.row < target.row.start
  }

  private def landed(point: Point, target: Target): Boolean = {
    target.col.contains(point.col) && target.row.contains(point.row)
  }
}
