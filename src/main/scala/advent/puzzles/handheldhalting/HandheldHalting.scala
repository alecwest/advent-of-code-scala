package com.alecnwest
package advent.puzzles.handheldhalting

object HandheldHalting {
  def accumulateUntilHalt(input: IndexedSeq[String]): Int = {
    val handheld = new Handheld(Handheld.parseInstructions(input))
    runBoot(handheld)
    handheld.accumulator
  }

  def resolveAndAccumulate(input: IndexedSeq[String]): Int = {
    var i = 0
    val instructions = Handheld.parseInstructions(input)
    while (true) {
      val newInstructions = instructions.zipWithIndex map {
        case (instruction: Instruction, index: Int) =>
          if (i == index) {
            instruction match {
              case Accumulate(increment) => Accumulate(increment)
              case Jump(instructions) => Nop(instructions)
              case Nop(nop) => Jump(nop)
              case _ => throw new Exception("unexpected instruction type")
            }
          } else {
            instruction
          }
      }
      val handheld = new Handheld(newInstructions)
      runBoot(handheld)
      if (handheld.programCompleted()) {
        return handheld.accumulator
      } else if (i > instructions.length) {
        throw new Error("no instruction flip could fix this program")
      }
      i += 1
    }
    0
  }

  private def runBoot(handheld: Handheld): Unit = {
    while (handheld.runInstruction()) {}
  }
}
