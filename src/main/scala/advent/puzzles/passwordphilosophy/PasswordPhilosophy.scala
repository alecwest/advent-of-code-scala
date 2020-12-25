package com.alecnwest
package advent.puzzles.passwordphilosophy

/**
  * Day 2
  */
object PasswordPhilosophy {
  def countValidPasswords(
      input: IndexedSeq[String],
      passwordPolicy: PolicyEvaluator =
        TobogganCorporateAuthenticationSystemPolicyEvaluator): Int = {
    input.count(isValidPassword(_, passwordPolicy))
  }

  def isValidPassword(input: String, passwordPolicy: String): Boolean = isValidPassword(input, getPolicy(passwordPolicy))

  def isValidPassword(
      input: String,
      passwordPolicy: PolicyEvaluator =
        TobogganCorporateAuthenticationSystemPolicyEvaluator): Boolean = {
    val policy = input.split("[^\\d\\w]+")
    val numberOne: Int = policy(0).toInt
    val numberTwo: Int = policy(1).toInt
    val letter: Char = policy(2).toCharArray()(0)
    val password: String = policy(3)
    passwordPolicy.evaluate(PasswordPolicy(numberOne, numberTwo, letter), password)
  }

  private def getPolicy(policy: String): PolicyEvaluator = policy match {
    case SledRentalPolicyEvaluator.name => SledRentalPolicyEvaluator
    case TobogganCorporateAuthenticationSystemPolicyEvaluator.name => TobogganCorporateAuthenticationSystemPolicyEvaluator
    case _ => BadPolicy
  }
}
