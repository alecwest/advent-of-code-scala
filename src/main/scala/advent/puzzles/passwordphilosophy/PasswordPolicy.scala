package com.alecnwest
package advent.puzzles.passwordphilosophy

trait PasswordPolicy {
  def evaluate(numberOne: Int,
               numberTwo: Int,
               letter: Char,
               password: String): Boolean
}

object SledRentalPolicy extends PasswordPolicy {
  override def evaluate(numberOne: Int,
                        numberTwo: Int,
                        letter: Char,
                        password: String): Boolean = {
    val count = password.count(_ == letter)
    count >= numberOne && count <= numberTwo
  }
}

object TobogganCorporateAuthenticationSystemPolicy extends PasswordPolicy {
  override def evaluate(numberOne: Int,
                        numberTwo: Int,
                        letter: Char,
                        password: String): Boolean = {
    try {
      val firstChar = password(numberOne - 1)
      val secondChar = password(numberTwo - 1)
      (firstChar == letter || secondChar == letter) && firstChar != secondChar
    } catch {
      case _: IndexOutOfBoundsException => false
    }
  }
}
