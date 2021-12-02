package advent.puzzles.passportprocessing

import advent.utils.InputParser
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class PassportTest extends AnyWordSpec with Matchers {

  val validPassport = Passport(1997, 2016, 2025, "72in", "#ade069", "grn", "012345678", Some("USA"))

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

    "validate" should {
      "return passport" when {
        "all fields valid" in {
          Passport.validate(validPassport).isDefined should be(true)
        }
      }
      "return None" when {
        "birth year too late" in {
          Passport.validate(validPassport.copy(birthYear = 1919)).isDefined should be(false)
        }

        "birth year too early" in {
          Passport.validate(validPassport.copy(birthYear = 2003)).isDefined should be(false)
        }

        "issue year too late" in {
          Passport.validate(validPassport.copy(issueYear = 2009)).isDefined should be(false)
        }

        "issue year too early" in {
          Passport.validate(validPassport.copy(issueYear = 2021)).isDefined should be(false)
        }

        "expiration year too late" in {
          Passport.validate(validPassport.copy(expirationYear = 2019)).isDefined should be(false)
        }

        "expiration year too early" in {
          Passport.validate(validPassport.copy(expirationYear = 2031)).isDefined should be(false)
        }

        "height too short (cm)" in {
          Passport.validate(validPassport.copy(height = "149cm")).isDefined should be(false)
        }

        "height too tall (cm)" in {
          Passport.validate(validPassport.copy(height = "194cm")).isDefined should be(false)
        }

        "height too short (in)" in {
          Passport.validate(validPassport.copy(height = "58in")).isDefined should be(false)
        }

        "height too tall (in)" in {
          Passport.validate(validPassport.copy(height = "77in")).isDefined should be(false)
        }

        "hair color invalid" in {
          Passport.validate(validPassport.copy(hairColor = "#000x00")).isDefined should be(false)
          Passport.validate(validPassport.copy(hairColor = "abcdef")).isDefined should be(false)
          Passport.validate(validPassport.copy(hairColor = "#999")).isDefined should be(false)
        }

        "eye color invalid" in {
          Passport.validate(validPassport.copy(eyeColor = "bln")).isDefined should be(false)
          Passport.validate(validPassport.copy(eyeColor = "gr")).isDefined should be(false)
          Passport.validate(validPassport.copy(eyeColor = "hazel")).isDefined should be(false)
        }
      }
    }
  }
}
