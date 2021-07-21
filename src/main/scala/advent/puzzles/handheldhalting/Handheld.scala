package com.alecnwest
package advent.puzzles.handheldhalting

import scala.collection.mutable

trait Instruction
case class Accumulate(increment: Int) extends Instruction
case class Jump(instructions: Int) extends Instruction
case class Nop(nop: Int) extends Instruction

object Handheld {
  def parseInstructions(input: IndexedSeq[String]): IndexedSeq[Instruction] = {
    input.map(line => {
      val split = line.split(" \\+?")
      split(0) match {
        case "acc" => Accumulate(split(1).toInt)
        case "jmp" => Jump(split(1).toInt)
        case "nop" => Nop(split(1).toInt)
      }
    })
  }
}

class Handheld(val instructions: IndexedSeq[Instruction]) {
  var accumulator = 0
  val instructionHistory: mutable.Set[Int] = mutable.Set.empty

  private var pc = 0

  def runInstruction(): Boolean = {
    if (!instructionHistory.add(pc)) {
      return false
    }
    instructions(pc) match {
      case Accumulate(increment) => {
        accumulator += increment
        pc += 1
      }
      case Jump(instructions) => pc += instructions
      case Nop(_) => pc += 1
      case _ => throw new Exception(s"cannot parse given instruction")
    }
    true
  }
}
