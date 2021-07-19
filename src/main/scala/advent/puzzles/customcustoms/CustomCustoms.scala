package com.alecnwest
package advent.puzzles.customcustoms

object CustomCustoms {
  def sumGroupCounts(input: IndexedSeq[IndexedSeq[String]]): Int = {
    input.map(getGroupCount).sum
  }

  private def getGroupCount(input: IndexedSeq[String]): Int = {
    CustomDeclarationGroup.fromStringArray(input)
      .get
      .collectAnswers()
      .size
  }
}
