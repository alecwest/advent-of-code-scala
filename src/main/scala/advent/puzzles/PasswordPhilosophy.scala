package com.alecnwest
package advent.puzzles

/**
 * Day 2
 */
object PasswordPhilosophy {
  def countValidPasswords(input: IndexedSeq[String]): Int = {
    input.count(isValidPassword)
  }

  def isValidPassword(input: String): Boolean = {
    val policy = input.split("[^\\d\\w]+")
    val min: Int = policy(0).toInt
    val max: Int = policy(1).toInt
    val letter: Char = policy(2).toCharArray()(0)
    val password: String = policy(3)
    val count = password.count(_ == letter)
    count >= min && count <= max
  }
}
