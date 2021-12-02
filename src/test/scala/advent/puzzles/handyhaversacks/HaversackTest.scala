package advent.puzzles.handyhaversacks

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class HaversackTest extends AnyWordSpec with Matchers {

  "HaversackTest" when {
    "fromString" should {
      "create a Hackersack with no bags" in {
        val sack = Haversack.fromString("dotted black bags contain no other bags.")
        sack.isDefined should be(true)
        sack.get.color should be("dotted black")
        sack.get.rules.length should be(0)
      }

      "create a Hackersack that contains 1 type of bag" in {
        val sack = Haversack.fromString("dotted black bags contain 2 shiny gold bags.")
        sack.isDefined should be(true)
        sack.get.color should be("dotted black")
        sack.get.rules.length should be(1)
        sack.get.rules(0).color should be("shiny gold")
        sack.get.rules(0).quantity should be(2)
      }

      "create a Hackersack that contains many bags" in {
        val sack = Haversack.fromString("dotted black bags contain 2 shiny gold bags, 9 faded blue bags.")
        sack.isDefined should be(true)
        sack.get.color should be("dotted black")
        sack.get.rules.length should be(2)
        sack.get.rules(0).color should be("shiny gold")
        sack.get.rules(0).quantity should be(2)
        sack.get.rules(1).color should be("faded blue")
        sack.get.rules(1).quantity should be(9)
      }
    }
  }
}
