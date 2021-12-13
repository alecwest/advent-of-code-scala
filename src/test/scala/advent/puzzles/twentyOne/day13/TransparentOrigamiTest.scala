package advent.puzzles.twentyOne.day13

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers
import advent.utils.InputParser
import scala.io.Source

val input1 = """6,10
0,14
9,10
0,3
10,4
4,11
6,0
6,12
4,1
0,13
10,12
3,4
3,0
8,4
1,10
2,14
8,10
9,0

fold along y=7
fold along x=5"""

class TransparentOrigamiTest extends AnyWordSpec with Matchers {
  "TransparentOrigami" when {
    "part1" in {
      TransparentOrigami.part1(
        InputParser.parseMultiLine(input1)
      ) should be(17)
    }

    "part1 more input" in {
      TransparentOrigami.part1(
        InputParser.parseMultiLine(
          Source.fromResource("twentyOne/day13.txt").mkString
        )
      ) should be(618)
    }

    "part2" in {
      TransparentOrigami.part2(
        InputParser.parseMultiLine(input1)
      ) should be(16)
    }

    "part2 more input" in {
      TransparentOrigami.part2(
        InputParser.parseMultiLine(
          Source.fromResource("twentyOne/day13.txt").mkString
        )
      ) should be(98)
    }
  }
}
