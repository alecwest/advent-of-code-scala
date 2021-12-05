package advent.puzzles.twentyOne.day5

sealed case class Point(var x: Int, var y: Int)
sealed case class Line(start: Point, end: Point)

object HydrothermalVenture {
  def part1(input: IndexedSeq[String]): Int = {
    val lines = readLines(input)
    val grid = Array.ofDim[Int](1000, 1000)

    lines.foreach(line => {
      if (line.start.x == line.end.x) {
        for (
          y <- Math.min(line.start.y, line.end.y) to Math
            .max(line.start.y, line.end.y)
        ) {
          grid(line.start.x)(y) += 1
        }
      } else if (line.start.y == line.end.y) {
        for (
          x <- Math.min(line.start.x, line.end.x) to Math
            .max(line.start.x, line.end.x)
        ) {
          grid(x)(line.start.y) += 1
        }
      }
    })
    grid.flatten.count(_ >= 2)
  }

  def part2(input: IndexedSeq[String]): Int = {
    val lines = readLines(input)
    val grid = Array.ofDim[Int](1000, 1000)

    lines.foreach(line => {
      if (line.start.x == line.end.x) {
        for (
          y <- Math.min(line.start.y, line.end.y) to Math
            .max(line.start.y, line.end.y)
        ) {
          grid(line.start.x)(y) += 1
        }
      } else if (line.start.y == line.end.y) {
        for (
          x <- Math.min(line.start.x, line.end.x) to Math
            .max(line.start.x, line.end.x)
        ) {
          grid(x)(line.start.y) += 1
        }
      } else {
        var currentPoint = line.start
        var continue = true
        while (continue) {
          continue = !(currentPoint.x == line.end.x && currentPoint.y == line.end.y)
          grid(currentPoint.x)(currentPoint.y) += 1
          currentPoint.x += (if (line.start.x < line.end.x) 1 else -1)
          currentPoint.y += (if (line.start.y < line.end.y) 1 else -1)
        }
      }
    })
    grid.flatten.count(_ >= 2)    
  }

  private def readLines(input: IndexedSeq[String]) = input.map(line => {
    val points = line.split("->").map(_.split(","))
    Line(
      Point(points(0)(0).toInt, points(0)(1).trim.toInt),
      Point(points(1)(0).trim.toInt, points(1)(1).toInt)
    )
  })
}
