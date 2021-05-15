package com.alecnwest
package advent.puzzles.binaryboarding

import org.scalatest.{Matchers, WordSpecLike}

class BoardingPassTest extends WordSpecLike with Matchers {

  "BoardingPassTest" when {
    "fromString" should {
      "build a valid boarding pass" in {
        BoardingPass.fromString("BFFFBBFRRR").get should equal(
          BoardingPass(70, 7, 567)
        )
        BoardingPass.fromString("FFFBBBFRRR").get should equal(
          BoardingPass(14, 7, 119)
        )
        BoardingPass.fromString("BBFFBBFRLL").get should equal(
          BoardingPass(102, 4, 820)
        )
      }
    }
  }
}
