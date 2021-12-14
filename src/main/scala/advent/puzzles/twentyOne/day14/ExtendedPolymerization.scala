package advent.puzzles.twentyOne.day14

import scala.collection.mutable

object ExtendedPolymerization {
  def part1(input: IndexedSeq[IndexedSeq[String]]): Int = {
    polymerCounts(input, 10).toInt
  }

  def part2(input: IndexedSeq[IndexedSeq[String]]): BigInt = {
    polymerCounts(input, 40)
  }

  private def polymerCounts(
      input: IndexedSeq[IndexedSeq[String]],
      iterations: Int
  ): BigInt = {
    val template = input(0)(0)
    val rules = mutable.Map[String, (String, BigInt)]()
    input(1)
      .grouped(3)
      .map(_.patch(1, Nil, 1))
      .map(rule => {
        (
          rule(0),
          (
            rule(1),
            if (template.contains(rule(0))) BigInt(1)
            else BigInt(0)
          )
        )
      })
      .foreach(rules += _)

    val polymerCounts = Iterator
      .iterate(rules, iterations) { curr =>
        val newMap = curr.clone
        curr
          .filter(_._2._2 > 0)
          .foreach((key, v) => {
            newMap(key) = (newMap(key)._1, 0)
          })
        curr
          .filter(_._2._2 > 0)
          .foreach((key, v) => {
            val (value, count) = v
            val left = key.patch(0, value, 1)
            val right = key.patch(1, value, 1)
            List(left, right).foreach(newMapK => {
              val newMapV = newMap(newMapK)
              newMap(newMapK) = (newMapV._1, newMapV._2 + count)
            })
          })
        newMap
      }
      .toList
      .map(res => res.groupMap(_._2._1)(_._2._2))
      .flatten
      .groupMap(_._1)(_._2.sum)
      .map((key, value) => {
        (key, value :+ BigInt(template.count(_.toString == key)))
      })
      .toMap

    val sums = polymerCounts.map(_._2.sum)

    sums.max - sums.min
  }
}
