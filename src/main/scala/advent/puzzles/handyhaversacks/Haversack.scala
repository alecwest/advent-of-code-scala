package com.alecnwest
package advent.puzzles.handyhaversacks

sealed case class HaversackRule(color: String, quantity: Int)

sealed case class Haversack (color: String, rules: Array[HaversackRule])

object Haversack {
  def fromString(s: String): Option[Haversack] = {
    val keywords = s.split("\\s*(bags contain|,)\\s*")
    Some(
      Haversack(
        keywords(0),
        keywords
          .drop(1)
          .filterNot(_.contains("no other bags"))
          .map(
            rule => {
              val ruleWords = rule.split(" ")
              HaversackRule(
                ruleWords.slice(1, ruleWords.length-1).mkString(" "),
                ruleWords(0).toInt
              )
            }
          )
      )
    )
  }
}
