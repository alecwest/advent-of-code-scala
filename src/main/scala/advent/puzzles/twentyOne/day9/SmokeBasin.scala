package advent.puzzles.twentyOne.day9

import scala.util.Try
import scala.collection.mutable.ArrayBuffer
import scala.collection.AbstractSeq
import scala.collection.mutable.{ListBuffer, Map}

sealed case class Point(row: Int, col: Int, value: Int = 0)

object SmokeBasin {
  def part1(input: IndexedSeq[String]): Int = {
    val heightMap = input.map(_.split("").map(_.toInt).toIndexedSeq)
    heightMap.zipWithIndex.foldLeft(0)((total, nextInRow) => {
      total + heightMap(nextInRow._2).zipWithIndex.foldLeft(0)(
        (col, nextInCol) => {
          col + (if (
                   nextInCol._1 < getAdjacentValues(
                     heightMap,
                     Point(nextInRow._2, nextInCol._2)
                   ).min
                 ) nextInCol._1 + 1
                 else 0)
        }
      )
    })
  }

  def part2(input: IndexedSeq[String]): Int = {
    val basinPoints = Map.empty[Int, Set[Point]]
    val basinMap = input.zipWithIndex
      .map((row, i) => {
        row
          .split("")
          .zipWithIndex
          .map((col, j) => {
            Point(i, j, col.toInt)
          })
      })
      .toArray

    basinMap.flatten.foreach(point => {
      if (point.value != 9) {
        val points = traverse(basinMap, point)
        if (!basinPoints.exists((key, values) => values.contains(point))) {
          basinPoints.addOne(basinPoints.size, points)
        }
      }
    })

    basinPoints.toArray.map(_._2.size).sorted.takeRight(3).product
  }

  private def getAdjacentValues(
      heightMap: IndexedSeq[IndexedSeq[Int]],
      point: Point
  ): IndexedSeq[Int] = {
    IndexedSeq(
      Try(heightMap(point.row)(point.col - 1)).getOrElse(-1),
      Try(heightMap(point.row)(point.col + 1)).getOrElse(-1),
      Try(heightMap(point.row + 1)(point.col)).getOrElse(-1),
      Try(heightMap(point.row - 1)(point.col)).getOrElse(-1)
    ).filterNot(_ == -1)
  }

  private def getAdjacentPoints(
      map: Array[Array[Point]],
      point: Point
  ): List[Point] = {
    val a = List(
      (point.row, point.col - 1),
      (point.row, point.col + 1),
      (point.row - 1, point.col),
      (point.row + 1, point.col)
    ).map((r: Int, c: Int) => {
      try {
        Some(map(r)(c))
      } catch case _ => None
    }).filter(point => point.isDefined && point.get.value != 9)
      .map(_.get)
    a
  }

  private def traverse(
      basinMap: Array[Array[Point]],
      current: Point,
      accumulator: Set[Point] = Set.empty
  ): Set[Point] = {
    getAdjacentPoints(basinMap, current).foldLeft(accumulator)(
      (results, next) => {
        if (results.contains(next)) results
        else traverse(basinMap, next, results + current)
      }
    ) + current
  }
}
