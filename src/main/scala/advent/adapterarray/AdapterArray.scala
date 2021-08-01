package com.alecnwest
package advent.adapterarray

object AdapterArray {
  def product1And3Differences(input: IndexedSeq[Int]): Int = {
    val diffs = countDifferences(input)
    diffs._1 * diffs._3
  }

  private def countDifferences(input: IndexedSeq[Int]): (Int, Int, Int) = {
    var (a, b, c) = (0, 0, 0)
    val sorted = input.sorted
    for ((adapterRating, index) <- sorted.zipWithIndex) {
      adapterRating - (if (index == 0) 0 else sorted(index - 1)) match {
        case 1 => a += 1
        case 2 => b += 1
        case 3 => c += 1
      }
    }
    (a, b, c+1)
  }
}
