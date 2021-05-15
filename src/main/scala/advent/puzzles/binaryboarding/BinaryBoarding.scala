package com.alecnwest
package advent.puzzles.binaryboarding

object BinaryBoarding {
  def highestSeatID(input: IndexedSeq[String]): Int =
    input
      .map(line => BoardingPass.fromString(line).map(_.seatID).getOrElse(0))
      .max
}
