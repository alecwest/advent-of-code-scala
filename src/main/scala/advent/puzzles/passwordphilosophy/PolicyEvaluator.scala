package com.alecnwest
package advent.puzzles.passwordphilosophy

final case class PasswordPolicy(numberOne: Int, numberTwo: Int, letter: Char)

sealed trait PolicyEvaluator {
  def name: String
  def evaluate(policy: PasswordPolicy,
               password: String): Boolean
}

case object SledRentalPolicyEvaluator extends PolicyEvaluator {
  val name = "SledRentalPolicy"
  override def evaluate(policy: PasswordPolicy,
                        password: String): Boolean = {
    val count = password.count(_ == policy.letter)
    count >= policy.numberOne && count <= policy.numberTwo
  }
}

case object TobogganCorporateAuthenticationSystemPolicyEvaluator extends PolicyEvaluator {
  val name = "TobogganCorporateAuthenticationSystemPolicy"
  override def evaluate(policy: PasswordPolicy,
                        password: String): Boolean = {
    try {
      val firstChar = password(policy.numberOne - 1)
      val secondChar = password(policy.numberTwo - 1)
      (firstChar == policy.letter || secondChar == policy.letter) && firstChar != secondChar
    } catch {
      case _: IndexOutOfBoundsException => false
    }
  }
}

case object BadPolicy extends PolicyEvaluator {
  override def name = "BadPolicy"
  override def evaluate(policy: PasswordPolicy, password: String): Boolean = false
}

