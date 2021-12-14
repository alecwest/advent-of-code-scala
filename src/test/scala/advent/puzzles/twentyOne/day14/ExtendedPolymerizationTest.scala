package advent.puzzles.twentyOne.day14

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers
import advent.utils.InputParser
import scala.io.Source

val input1 = """NNCB

CH -> B
HH -> N
CB -> H
NH -> C
HB -> C
HC -> B
HN -> C
NN -> C
BH -> H
NC -> B
NB -> B
BN -> B
BB -> N
BC -> B
CC -> N
CN -> C"""

class ExtendedPolymerizationTest extends AnyWordSpec with Matchers {
  "ExtendedPolymerization" when {
    "part1" in {
      ExtendedPolymerization.part1(
        InputParser.parseMultiLine(input1)
      ) should be(1588)
    }

    "part1 more input" in {
      ExtendedPolymerization.part1(
        InputParser.parseMultiLine(
          Source.fromResource("twentyOne/day14.txt").mkString
        )
      ) should be(2447)
    }

    "part2" in {
      ExtendedPolymerization.part2(
        InputParser.parseMultiLine(input1)
      ) should be(BigInt("2188189693529"))
    }

    "part2 more input" in {
      ExtendedPolymerization.part2(
        InputParser.parseMultiLine(
          Source.fromResource("twentyOne/day14.txt").mkString
        )
      ) should be(BigInt("3018019237563"))
    }
  }
}
