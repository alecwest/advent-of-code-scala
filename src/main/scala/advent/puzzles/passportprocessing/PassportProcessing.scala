package advent.puzzles.passportprocessing

object PassportProcessing {
  def isValidPassport(input: IndexedSeq[String]): Boolean =
    Passport.fromStringArray(input).flatMap(Passport.validate).isDefined

  def countValidPassports(input: IndexedSeq[IndexedSeq[String]]): Int =
    input.count(isValidPassport)
}
