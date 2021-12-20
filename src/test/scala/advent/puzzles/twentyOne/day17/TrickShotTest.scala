package advent.puzzles.twentyOne.day17

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers
import advent.utils.InputParser
import scala.io.Source

val input = "target area: x=20..30, y=-10..-5"

class TrickShotTest extends AnyWordSpec with Matchers {
  "TrickShot" when {
    "part1" in {
      TrickShot.part1(input) should be(45)
    }

    "part1 more input" in {
      TrickShot.part1(
        Source.fromResource("twentyOne/day17.txt").mkString
      ) should be(3003)
    }

    "part2" in {
      TrickShot.part2(input) should be(112)
    }

    "part2 more input" in {
      TrickShot.part2(
        Source.fromResource("twentyOne/day17.txt").mkString
      ) should be(940)
    }
  }
}
