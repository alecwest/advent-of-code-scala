package advent.puzzles.twentyOne.day3

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers
import advent.utils.InputParser
import scala.io.Source
import advent.puzzles.twentyOne.day3.BinaryDiagnostic

class BinaryDiagnosticTest extends AnyWordSpec with Matchers {
  "BinaryDiagnostic" when {
    "part1" in {
      BinaryDiagnostic.part1(
        InputParser.parse(
          "00100\n11110\n10110\n10111\n10101\n01111\n00111\n11100\n10000\n11001\n00010\n01010"
        )
      ) should be(198)
    }
    
    "part1 more input" in {
      BinaryDiagnostic.part1(
        InputParser.parse(
          Source.fromResource("twentyOne/day3.txt").mkString
        )
      ) should be(4174964)
    }

    "part2" in {
      BinaryDiagnostic.part2(
        InputParser.parse(
          "00100\n11110\n10110\n10111\n10101\n01111\n00111\n11100\n10000\n11001\n00010\n01010"
        )
      ) should be(230)
    }
    
    "part2 more input" in {
      BinaryDiagnostic.part2(
        InputParser.parse(
          Source.fromResource("twentyOne/day3.txt").mkString
        )
      ) should be(4474944)
    }
  }
}
