package advent

import advent.utils.InputParser.Converter

package object utils {
  case class Point(row: Int, col: Int)
  case class Line(start: Point, end: Point)
  opaque type Grid[A] <: Map[Point, A] = Map[Point, A]

  /**
   * Convert to grid given matrix of input
   * i.e.
   * 223
   * 345
   * 013
   * etc...
   */
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

  /**
   * Convert to grid given series of points
   * i.e.
   * 691,418
   * 507,283
   * 371,371
   * 21,710
   * etc...
   * 
   * y = row, x = col
   */
  def toGridFromPoints[A](
    input: IndexedSeq[String], 
    pointValue: String = "#" // TODO probably could be dynamically set
  )(implicit converter: Converter[A]): Grid[A] = {
    input.map(point => {
      val coords = point.split(",")
      (Point(coords(1).toInt, coords(0).toInt), converter.convert(pointValue))
    }).toMap
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
