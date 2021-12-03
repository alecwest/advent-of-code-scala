package advent.puzzles.twentyOne

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers
import advent.puzzles.twentyOne.dive.Dive
import advent.utils.InputParser
import scala.io.Source

class DiveTest extends AnyWordSpec with Matchers {
  "DiveTest" when {
    "dive" should {
      "calculate the product of the position" in {
        Dive.dive(
          InputParser.parse(
            "forward 5\ndown 5\nforward 8\nup 3\ndown 8\n forward 2"
          )
        ) should be(150)
      }

      "calculate the product of the position with larger input" in {
        Dive.dive(
          InputParser.parse(
            Source.fromResource("twentyOne/Dive.txt").mkString
          )
        ) should be(2117664)
      }
    }

    "diveWithAim" should {
      "calculate the product of the position" in {
        Dive.diveWithAim(
          InputParser.parse(
            "forward 5\ndown 5\nforward 8\nup 3\ndown 8\n forward 2"
          )
        ) should be(900)
      }

      "calculate the product of the position with larger input" in {
        Dive.diveWithAim(
          InputParser.parse(
            Source.fromResource("twentyOne/Dive.txt").mkString
          )
        ) should be(2073416724)
      }
    }
  }
}
