package com.alecnwest
package advent.puzzles.handyhaversacks

object HandyHaversacks {
  def countRequiredTags(input: IndexedSeq[String], parentBag: String): Int = {
    val haversackPolicy: Map[String, Array[HaversackRule]] = buildPolicyMap(
      input
    )
    sumTags(haversackPolicy, parentBag, parentBag)
  }

  def countValidBags(input: IndexedSeq[String], targetChildBag: String): Int = {
    val haversackPolicy: Map[String, Array[HaversackRule]] = buildPolicyMap(
      input
    )
    haversackPolicy.count(keyValue =>
      canContainBag(haversackPolicy, targetChildBag, keyValue._1)
    )
  }

  private def sumTags(
      policy: Map[String, Array[HaversackRule]],
      targetBagColor: String,
      currentPolicyColor: String
  ): Int = {
    val rules = policy(currentPolicyColor)
    if (rules.length == 0) {
      0
    } else {
      rules.map(rule => {
        rule.quantity + (rule.quantity * sumTags(policy, targetBagColor, rule.color))
      }).sum
    }
  }

  private def canContainBag(
      policy: Map[String, Array[HaversackRule]],
      targetBagColor: String,
      currentPolicyColor: String
  ): Boolean = {
    val rules = policy(currentPolicyColor)
    if (rules.length == 0) {
      false
    } else if (rules.exists(_.color == targetBagColor)) {
      true
    } else {
      rules.exists(rule => {
        canContainBag(policy, targetBagColor, rule.color)
      })
    }
  }

  private def buildPolicyMap(
                              input: IndexedSeq[String]
                            ): Map[String, Array[HaversackRule]] = {
    input
      .flatMap(i => {
        val sack = Haversack.fromString(i)
        if (sack.isDefined) {
          Map(sack.get.color -> sack.get.rules)
        } else {
          None
        }
      })
      .toMap
  }
}
