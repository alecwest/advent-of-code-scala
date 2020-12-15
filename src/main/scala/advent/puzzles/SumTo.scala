package com.alecnwest
package advent.puzzles

import monix.eval.Coeval

/**
 * Day 1, challenge 1
 */
object SumTo {
  val targetSum = 2020

  def calculate(input: IndexedSeq[Int]): Int = {
    val sorted = input.sorted
    var i = 0
    var j = sorted.length - 1
    while (j > 0) {
      i = 0
      val highVal = sorted(j)
      val lowVal = sorted(i)
      while (i < j) {
        val sum: Coeval[Int] = Coeval.delay(highVal + lowVal)
        if (highVal < lowVal || sum.value > targetSum) {
          i = j // Force inner loop to exit early
        } else if (sum.value == targetSum) {
          return lowVal * highVal
        }
        i += 1
      }
      j -= 1
    }
    -1
  }
}
