package com.alecnwest
package advent.puzzles.encodingerror

object EncodingError {
  def firstInvalidNumber(input: IndexedSeq[Long], preambleLength: Int): Long = {
    (input.zipWithIndex.slice(preambleLength, input.size) find {
      case (nextNumber: Long, index: Int) =>
        !(input.zipWithIndex.slice(index - preambleLength, index) exists {
          case (firstNumber: Long, j: Int) =>
            input.zipWithIndex.slice(index - preambleLength, index) exists {
              case (secondNumber: Long, k: Int) =>
                if (j == k) {
                  false
                } else {
                  firstNumber + secondNumber == nextNumber
                }
            }
        })
    }).map(_._1).get
  }

  def encryptionWeakness(input: IndexedSeq[Long], preambleLength: Int): Long = {
    val firstInvalid = firstInvalidNumber(input, preambleLength)
    for ((_, i: Int) <- input.zipWithIndex) {
      var sum: Long = 0
      val weakNumbers = input.slice(i, input.size).takeWhile { next =>
        if (sum < firstInvalid) {
          sum += next
          true
        } else
          false
      }
      if (sum == firstInvalid)
        return weakNumbers.min + weakNumbers.max
    }
    0
  }
}
