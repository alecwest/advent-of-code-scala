package com.alecnwest
package advent.puzzles.encodingerror

object EncodingError {
  def firstInvalidNumber(input: IndexedSeq[BigInt], preambleLength: Int): Number = {
    (input.zipWithIndex.slice(preambleLength, input.size) find {
      case (nextNumber: BigInt, index: Int) => {
        !(input.zipWithIndex.slice(index - preambleLength, index) exists {
          case (firstNumber: BigInt, j: Int) => {
            input.zipWithIndex.slice(index - preambleLength, index) exists {
              case (secondNumber: BigInt, k: Int) => {
                if (j == k) {
                  false
                } else {
                  firstNumber + secondNumber == nextNumber
                }
              }
            }
          }
        })
      }
    }).map(_._1).get
  }
}
