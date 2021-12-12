package advent

import advent.utils.InputParser.Converter

package object utils {
  case class Point(row: Int, col: Int)
  case class Line(start: Point, end: Point)
  opaque type Grid[A] <: Map[Point, A] = Map[Point, A]

  def toGrid[A](
      input: IndexedSeq[String]
  )(implicit converter: Converter[A]): Grid[A] = {
    input.zipWithIndex
      .flatMap((row, i) =>
        row
          .split("")
          .zipWithIndex
          .map((col, j) => (Point(i, j), converter.convert(col)))
      )
      .toMap
  }

  extension (point: Point)
    def adjacentPoints: Set[Point] = Set(
      Point(point.row, point.col - 1),
      Point(point.row, point.col + 1),
      Point(point.row - 1, point.col),
      Point(point.row + 1, point.col)
    )

    def neighbors: Set[Point] = point.adjacentPoints ++ Set(
      Point(point.row - 1, point.col - 1),
      Point(point.row - 1, point.col + 1),
      Point(point.row + 1, point.col - 1),
      Point(point.row + 1, point.col + 1)
    )
}
