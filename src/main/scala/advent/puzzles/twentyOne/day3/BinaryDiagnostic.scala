package advent.puzzles.twentyOne.day3

import cats.implicits._

object BinaryDiagnostic {
  def part1(input: IndexedSeq[String]): Int = {
    val bitFrequency = getBitFrequency(input)
    val gamma = Integer.parseInt(
      bitFrequency
        .map(tuple => {
          if (tuple._1 > tuple._2) "0" else "1"
        })
        .mkString,
      2
    )
    val epsilon = Integer.parseInt(
      bitFrequency
        .map(tuple => {
          if (tuple._1 < tuple._2) "0" else "1"
        })
        .mkString,
      2
    )
    gamma * epsilon
  }

  def part2(input: IndexedSeq[String]): Int = {
    oxygenRating(input) * carbonDioxideRating(input)
  }

  private def oxygenRating(input: IndexedSeq[String]): Int = {
    filterInputs(
      input,
      (bitFrequency, index) => {
        if (bitFrequency(index)._1 > bitFrequency(index)._2) '0'
        else '1'
      }
    )
  }

  private def carbonDioxideRating(input: IndexedSeq[String]): Int = {
    filterInputs(
      input,
      (bitFrequency, index) => {
        if (bitFrequency(index)._1 <= bitFrequency(index)._2) '0'
        else '1'
      }
    )
  }

  private def filterInputs(
      input: IndexedSeq[String],
      bitSelector: (Array[(Int, Int)], Int) => Char
  ): Int = {
    var bitFrequency = Array.empty[(Int, Int)]
    var targetIndex = 0
    var targetBit = '0'
    var filtered = input
    while (filtered.length > 1) {
      bitFrequency = getBitFrequency(filtered)
      targetBit = bitSelector(bitFrequency, targetIndex)
      filtered = filtered.filter(num => num(targetIndex) == targetBit)
      targetIndex += 1
    }
    Integer.parseInt(filtered(0), 2)
  }

  private def getBitFrequency(input: IndexedSeq[String]): Array[(Int, Int)] = {
    input.foldLeft(Array.fill(input(0).length)((0, 0)))((current, next) => {
      val tuples = next
        .split("")
        .map(num => {
          val n = num.toInt
          if (n == 0) (1, 0) else (0, 1)
        })
      current.zipWithIndex.map((current, index) => {
        current |+| tuples(index)
      })
    })
  }
}
