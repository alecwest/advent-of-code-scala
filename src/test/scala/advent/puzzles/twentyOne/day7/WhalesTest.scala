package advent.puzzles.twentyOne.day7

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers
import advent.utils.InputParser
import scala.io.Source

class WhalesTest extends AnyWordSpec with Matchers {
  "WhalesTest" when {
    "part1" in {
      Whales.part1(
        InputParser.parseSingleLine[Int]("16,1,2,0,4,2,7,1,2,14")
      ) should be(37)
    }
    
    "part1 more input" in {
      Whales.part1(
        InputParser.parseSingleLine[Int](
          Source.fromResource("twentyOne/day7.txt").mkString
        )
      ) should be(325528)
    }
    
    "part2" in {
      Whales.part2(
        InputParser.parseSingleLine("16,1,2,0,4,2,7,1,2,14")
      ) should be(168)
    }
    
    "part2 more input" in {
      Whales.part2(
        InputParser.parseSingleLine(
          Source.fromResource("twentyOne/day7.txt").mkString
        )
      ) should be(85015836)
    }
  }
}