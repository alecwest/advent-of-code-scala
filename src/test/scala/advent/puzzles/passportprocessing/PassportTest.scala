package com.alecnwest
package advent.puzzles.passportprocessing

import com.alecnwest.advent.utils.InputParser
import org.scalatest.{Matchers, WordSpecLike}

class PassportTest extends WordSpecLike with Matchers {

  "PassportTest" when {
    "fromString" should {
      "return passport on valid input" in {
        Passport
          .fromStringArray(
            InputParser.parseLine[String](
              "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd\nbyr:1937 iyr:2017 cid:147 hgt:183cm"
            )).get
          .isInstanceOf[Passport] should be(true)
      }

      "return nothing on invalid input" in {
        Passport.fromStringArray(
          InputParser.parseLine[String](
            "hcl:#cfa07d eyr:2025 pid:166559648\niyr:2011 ecl:brn hgt:59in")
        ) should be(None)
      }
    }
  }
}
