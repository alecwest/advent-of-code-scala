package com.alecnwest
package advent

import org.scalatest.{Matchers, WordSpecLike}

class CubeCalculatorTest extends WordSpecLike with Matchers {

  "CubeCalculatorTest" should {
    "cube" in {
      CubeCalculator.cube(3) should be(27)
    }
  }
}
