package advent.puzzles.twentyOne.day15

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers
import advent.utils.InputParser
import scala.io.Source

val input1 = """1163751742
1381373672
2136511328
3694931569
7463417111
1319128137
1359912421
3125421639
1293138521
2311944581"""

class ChitonTest extends AnyWordSpec with Matchers {
  "Chiton" when {
    "part1" in {
      Chiton.part1(
        InputParser.parse(input1)
      ) should be(40)
    }

    "part1 more input" in {
      Chiton.part1(
        InputParser.parse(
          Source.fromResource("twentyOne/day15.txt").mkString
        )
      ) should be(702)
    }

    "part2" in {
      Chiton.part2(
        InputParser.parse(input1)
      ) should be(315)
    }

    // "part2 more input" in {
    //   Chiton.part2(
    //     InputParser.parse(
    //       Source.fromResource("twentyOne/day15.txt").mkString
    //     )
    //   ) should be(2955)
    // }
  }
}
