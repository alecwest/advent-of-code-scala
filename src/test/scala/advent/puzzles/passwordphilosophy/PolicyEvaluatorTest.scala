package com.alecnwest
package advent.puzzles.passwordphilosophy

import org.scalatest.{Matchers, WordSpecLike}

class PolicyEvaluatorTest extends WordSpecLike with Matchers {
  "PasswordPolicy" when {
    SledRentalPolicyEvaluator.getClass.getSimpleName should {
      "return true" in {
        SledRentalPolicyEvaluator.evaluate(PasswordPolicy(2, 9, 'c'), "ccccccccc") should be(true)
      }

      "return false" in {
        SledRentalPolicyEvaluator.evaluate(PasswordPolicy(1, 3, 'b'), "cdefg") should be(false)
      }
    }

    TobogganCorporateAuthenticationSystemPolicyEvaluator.getClass.getSimpleName should {
      "return true" in {
        TobogganCorporateAuthenticationSystemPolicyEvaluator.evaluate(PasswordPolicy(1, 3, 'a'), "abcde") should be(
          true)
      }

      "return false" in {
        TobogganCorporateAuthenticationSystemPolicyEvaluator.evaluate(
          PasswordPolicy(2,
          9,
          'c'),
          "ccccccccc") should be(false)
      }

      "return false if out of bounds" in {
        TobogganCorporateAuthenticationSystemPolicyEvaluator.evaluate(
          PasswordPolicy(2,
          10,
          'c'),
          "ccccccccc") should be(false)
      }
    }
  }
}
