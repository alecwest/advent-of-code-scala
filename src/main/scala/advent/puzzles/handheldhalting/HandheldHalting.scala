package com.alecnwest
package advent.puzzles.handheldhalting

object HandheldHalting {
  def accumulateUntilHalt(input: IndexedSeq[String]): Int = {
    val handheld = new Handheld(Handheld.parseInstructions(input))
    while (handheld.runInstruction()) {}
    handheld.accumulator
  }
}
