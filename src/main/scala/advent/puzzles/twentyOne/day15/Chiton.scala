package advent.puzzles.twentyOne.day15

import advent.utils._
import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.collection.mutable.PriorityQueue

object Chiton {
  def part1(input: IndexedSeq[String]): Int = {
    // (Point, (point value, point weight))
    val grid = mutable.Map[Point, (Int, Int)]()
    toGrid[Int](input).map((key, value) => {
      grid.put(key, (value, 0))
    })

    dijkstra(grid)
  }

  def part2(input: IndexedSeq[String]): Int = {
    val grid = mutable.Map[Point, (Int, Int)]()
    toGrid[Int](input).map((key, value) => {
      grid.put(key, (value, 0))
    })

    val numRows = grid.keySet.maxBy(_.row).row + 1
    val numCols = grid.keySet.maxBy(_.col).col + 1
    grid.toMap.foreach((key, value) => {
      for (i <- 0 until 5) {
        for (j <- 0 until 5) {
          val newPoint = Point(key.row + numRows * i, key.col + numCols * j)
          val newValue = (value._1 + i + j) % 10 + (if ((value._1 + i + j) > 9) 1 else 0)
          if (!(i == 0 && j == 0)) {
            grid.put(newPoint, (newValue, 0))
          }
        }
      }
    })

    // grid.toList.sortBy(a => (a._1.row, a._1.col)).foreach((key, value) => {
    //   print((if (key.col == 0) "\n" else "") + value._1)
    // })

    dijkstra(grid)
  }

  private def dijkstra(grid: mutable.Map[Point, (Int, Int)]): Int = {
    val V: Int = grid.size
    val source: Point = Point(0, 0)
    val target: Point = grid.maxBy((key, _) => key.row + key.col)._1
    val distance = mutable.Map[Point, Int]()
    grid.foreach((key, value) => {
      distance.put(key, Int.MaxValue)
    })
    distance(source) = 0

    val pq = PriorityQueue[(Point, (Int, Int))]((source, (grid(source)._1, 0)))(
      (pair1, pair2) => pair1._2._1 - pair2._2._1
    )

    while (pq.size > 0) {
      val current = pq.dequeue
      current._1.adjacentPoints.filter(p => grid.keySet.contains(p)).foreach(n => {
        if (distance(current._1) + grid(n)._1 < distance(n)) {
          distance(n) = grid(n)._1 + distance(current._1)
          pq.enqueue((n, (grid(n)._1, distance(n))))
        }
      })

      // if (current._1.row % 100 == 0 && current._1.col % 100 == 0) {
      //   println("currently assesing " + current + " on a queue of size " + pq.size)
      // }
    }

    distance(target)
  }
}
