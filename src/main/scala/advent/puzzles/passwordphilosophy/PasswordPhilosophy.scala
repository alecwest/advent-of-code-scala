package com.alecnwest
package advent.puzzles.passwordphilosophy

/**
  * Day 2
  */
object PasswordPhilosophy {
  def countValidPasswords(
      input: IndexedSeq[String],
      passwordPolicy: PasswordPolicy =
        TobogganCorporateAuthenticationSystemPolicy): Int = {
    input.count(isValidPassword(_, passwordPolicy))
  }

  def isValidPassword(
      input: String,
      passwordPolicy: PasswordPolicy =
        TobogganCorporateAuthenticationSystemPolicy): Boolean = {
    val policy = input.split("[^\\d\\w]+")
    val numberOne: Int = policy(0).toInt
    val numberTwo: Int = policy(1).toInt
    val letter: Char = policy(2).toCharArray()(0)
    val password: String = policy(3)
    passwordPolicy.evaluate(numberOne, numberTwo, letter, password)
  }
}
