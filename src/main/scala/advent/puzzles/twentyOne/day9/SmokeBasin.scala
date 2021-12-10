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
    val basinMap = input.map(row => {
      val arr = new ArrayBuffer[Int]()
      arr.insertAll(
        0,
        row.split("").map(p => (if (p == "9") -1 else 0)).toArray
      )
      arr
    })
    var basinCounter = 0
    for (i <- 0 until basinMap.length) {
      for (j <- 0 until basinMap(i).length) {
        if (basinMap(i)(j) != -1) {
          val adjacent = new ListBuffer[Int]()
          adjacent.appendAll(
            getAdjacentValues(basinMap.map(_.toIndexedSeq), Point(i, j))
          )
          if (i > 0) {
            val numInRow = basinMap(i).drop(j + 1).takeWhile(_ != -1).length
            // basinMap(i - 1).drop(j).take(numInRow)
            for (n <- 1 to numInRow) {
              adjacent.append(
                basinMap(i - 1)(j + n)
              )
            }
          }

          // delete these
          // if (i > 0 && Try(basinMap(i)(j - 1)).getOrElse(-1) != -1) {
          // adjacent.append(basinMap(i - 1)(j - 1))
          // }
          // if (i > 0 && Try(basinMap(i)(j + 1)).getOrElse(-1) != -1) {
          // adjacent.append(basinMap(i - 1)(j + 1))
          // }
          val max = Try(adjacent.toList.max).getOrElse(-1)
          if (max <= 0) {
            basinCounter += 1
            basinMap(i)(j) = basinCounter
          } else {
            basinMap(i)(j) = max
          }
        }
      }
    }
    basinMap.flatten.toList
      .groupBy(identity)
      .filterNot(_._1 == -1)
      .map(_._2.size)
      .takeRight(3)
      .product
  }

  def part22(input: IndexedSeq[String]): Int = {
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
