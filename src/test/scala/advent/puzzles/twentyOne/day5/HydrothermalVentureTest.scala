package advent.puzzles.twentyOne.day5

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers
import advent.utils.InputParser
import scala.io.Source

class HydrothermalVentureTest extends AnyWordSpec with Matchers {
  "HydrothermalVentureTest" when {
    "part1" in {
      HydrothermalVenture.part1(
        InputParser.parse[String](
          "0,9 -> 5,9\n8,0 -> 0,8\n9,4 -> 3,4\n2,2 -> 2,1\n7,0 -> 7,4\n6,4 -> 2,0\n0,9 -> 2,9\n3,4 -> 1,4\n0,0 -> 8,8\n5,5 -> 8,2"
        )
      ) should be(5)
    }
    
    "part1 more input" in {
      HydrothermalVenture.part1(
        InputParser.parse[String](
          Source.fromResource("twentyOne/day5.txt").mkString
        )
      ) should be(5147)
    }
    
    "part2" in {
      HydrothermalVenture.part2(
        InputParser.parse[String](
          "0,9 -> 5,9\n8,0 -> 0,8\n9,4 -> 3,4\n2,2 -> 2,1\n7,0 -> 7,4\n6,4 -> 2,0\n0,9 -> 2,9\n3,4 -> 1,4\n0,0 -> 8,8\n5,5 -> 8,2"
        )
      ) should be(12)
    }
    
    "part2 more input" in {
      HydrothermalVenture.part2(
        InputParser.parse[String](
          Source.fromResource("twentyOne/day5.txt").mkString
        )
      ) should be(16925)
    }
  }
}
