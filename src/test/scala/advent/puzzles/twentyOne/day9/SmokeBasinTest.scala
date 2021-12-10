package advent.puzzles.twentyOne.day9

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers
import advent.utils.InputParser
import scala.io.Source

class SmokeBasinTest extends AnyWordSpec with Matchers {
  "SmokeBasinTest" when {
    "part1" in {
      SmokeBasin.part1(
        InputParser.parse(
          "2199943210\n3987894921\n9856789892\n8767896789\n9899965678"
        )
      ) should be(15)
    }

    "part1 more input" in {
      SmokeBasin.part1(
        InputParser.parse(
          Source.fromResource("twentyOne/day9.txt").mkString
        )
      ) should be(575)
    }

    "part2" in {
      SmokeBasin.part22(
        InputParser.parse("2199943210\n3987894921\n9856789892\n8767896789\n9899965678")
      ) should be(1134)
      SmokeBasin.part22(
        InputParser.parse("2199943910\n3987894021\n9856789892\n8767896789\n9899965678")
      ) should be(756)
      SmokeBasin.part22(
        InputParser.parse("2199943210\n3987894921\n9856789892\n8767899789\n9899965678")
      ) should be(1008)
      SmokeBasin.part22(
      InputParser.parse("2199943210\n3987894921\n9999789892\n8767896789\n9899965678")
      ) should be(891)
    }

    "part2 more input" in {
      SmokeBasin.part22(
        InputParser.parse(
          Source.fromResource("twentyOne/day9.txt").mkString
        )
      ) should be(1019700)
    }
  }
}
