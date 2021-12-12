package advent.puzzles.twentyOne.day11

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers
import advent.utils.InputParser
import scala.io.Source

class DumboOctopusTest extends AnyWordSpec with Matchers {
  "DumboOctopusTest" when {
    "part1" in {
      DumboOctopus.part1(
        InputParser.parse(
          """5483143223
2745854711
5264556173
6141336146
6357385478
4167524645
2176841721
6882881134
4846848554
5283751526"""
        )
      ) should be(1656)
    }

    "part1 more input" in {
      DumboOctopus.part1(
        InputParser.parse(
          Source.fromResource("twentyOne/day11.txt").mkString
        )
      ) should be(1601)
    }

    "part2" in {
      DumboOctopus.part2(
        InputParser.parse("""5483143223
2745854711
5264556173
6141336146
6357385478
4167524645
2176841721
6882881134
4846848554
5283751526""")
      ) should be(195)
    }

    "part2 more input" in {
      DumboOctopus.part2(
        InputParser.parse(
          Source.fromResource("twentyOne/day11.txt").mkString
        )
      ) should be(368)
    }
  }
}
