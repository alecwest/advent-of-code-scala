package advent.puzzles.customcustoms

object CustomCustoms {
  def sumGroupCounts(input: IndexedSeq[IndexedSeq[String]], allShouldAnswerYes: Boolean = false): Int = {
    input.map(getGroupCount(_, allShouldAnswerYes)).sum
  }

  private def getGroupCount(input: IndexedSeq[String], allShouldAnswerYes: Boolean): Int = {
    CustomDeclarationGroup.fromStringArray(input)
      .get
      .collectAnswers(allShouldAnswerYes)
      .size
  }
}
