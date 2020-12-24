package com.alecnwest
package advent.puzzles.reportrepair

/**
 * Day 1
 */
object ReportRepair {
  def calculate(input: IndexedSeq[Int], numbersToSum: Int = 2, targetSum: Int = 2020): Int = {
    input
      .combinations(numbersToSum)
      .find(combo => combo.sum == targetSum)
      .getOrElse(IndexedSeq(-1))
      .product
  }
}
