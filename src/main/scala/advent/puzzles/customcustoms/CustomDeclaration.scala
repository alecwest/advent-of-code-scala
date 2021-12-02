package advent.puzzles.customcustoms

sealed case class CustomDeclaration(answeredYes: Set[Char])

object CustomDeclaration {
  def fromString(s: String): Option[CustomDeclaration] = {
    Some(CustomDeclaration(s.toCharArray.toSet))
  }
}

sealed case class CustomDeclarationGroup(declarations: IndexedSeq[CustomDeclaration]) {
  def collectAnswers(allShouldAnswerYes: Boolean = false): Set[Char] = {
    val answers = declarations.flatMap(_.answeredYes).toSet
    if (allShouldAnswerYes) {
      answers.filter(answer => declarations.forall(_.answeredYes.contains(answer)))
    } else {
      answers
    }
  }
}

object CustomDeclarationGroup {
  def fromStringArray(arr: IndexedSeq[String]): Some[CustomDeclarationGroup] = {
    Some(
      CustomDeclarationGroup(
        arr.map(
          CustomDeclaration.fromString
        ).filter(_.isDefined)
          .map(_.get)
      )
    )
  }
}
