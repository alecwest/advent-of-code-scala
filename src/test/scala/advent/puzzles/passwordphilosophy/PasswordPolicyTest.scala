package com.alecnwest
package advent.puzzles.passwordphilosophy

import org.scalatest.{Matchers, WordSpecLike}

class PasswordPolicyTest extends WordSpecLike with Matchers {
  "PasswordPolicy" when {
    SledRentalPolicy.getClass.getSimpleName should {
      "return true" in {
        SledRentalPolicy.evaluate(2, 9, 'c', "ccccccccc") should be(true)
      }

      "return false" in {
        SledRentalPolicy.evaluate(1, 3, 'b', "cdefg") should be(false)
      }
    }

    TobogganCorporateAuthenticationSystemPolicy.getClass.getSimpleName should {
      "return true" in {
        TobogganCorporateAuthenticationSystemPolicy.evaluate(1, 3, 'a', "abcde") should be(
          true)
      }

      "return false" in {
        TobogganCorporateAuthenticationSystemPolicy.evaluate(
          2,
          9,
          'c',
          "ccccccccc") should be(false)
      }

      "return false if out of bounds" in {
        TobogganCorporateAuthenticationSystemPolicy.evaluate(
          2,
          10,
          'c',
          "ccccccccc") should be(false)
      }
    }
  }
}
