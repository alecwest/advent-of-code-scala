package com.alecnwest
package advent.puzzles.binaryboarding

object BinaryBoarding {
  def highestSeatID(input: IndexedSeq[String]): Int =
    getSeatIDs(input).max

  def findMissingSeat(input: IndexedSeq[String]): Int = {
    val seatIDs = getSeatIDs(input).sorted
    seatIDs.zipWithIndex
      .find {
        case (seatID, index) =>
          if (index > 0 && index < seatIDs.length - 1) {
            seatID - seatIDs(index - 1) != 1
          } else {
            false
          }
      }
      .getOrElse((0, 0))
      ._1 - 1
  }

  private def getSeatIDs(input: IndexedSeq[String]): IndexedSeq[Int] =
    input.map(line => BoardingPass.fromString(line).map(_.seatID).getOrElse(0))
}
