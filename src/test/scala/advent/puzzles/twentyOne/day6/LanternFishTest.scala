package advent.puzzles.twentyOne.day6

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers
import advent.utils.InputParser
import scala.io.Source

class LanternFishTest extends AnyWordSpec with Matchers {
  "LanternFishTest" when {
    "part1" in {
      LanternFish.part1(
        InputParser.parseSingleLine[Int]("3,4,3,1,2"), 80
      ) should be(5934)
    }
    
    "part1 more input" in {
      LanternFish.part1(
        InputParser.parseSingleLine[Int](
          Source.fromResource("twentyOne/day6.txt").mkString
        ), 80
      ) should be(380758)
    }
    
    "part2" in {
      LanternFish.part1(
        InputParser.parseSingleLine("3,4,3,1,2"), 256
      ) should be(BigInt("26984457539"))
    }
    
    "part2 more input" in {
      LanternFish.part1(
        InputParser.parseSingleLine(
          Source.fromResource("twentyOne/day6.txt").mkString
        ), 256
      ) should be(BigInt("1710623015163"))
    }
  }
}