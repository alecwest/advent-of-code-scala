package advent.puzzles.twentyOne.day4

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers
import advent.utils.InputParser
import scala.io.Source

class GiantSquidTest extends AnyWordSpec with Matchers {
  "GiantSquid" when {
    "part1" in {
      GiantSquid.part1(
        InputParser.parseMultiLine[IndexedSeq[String]](
          "7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1\n\n22 13 17 11  0\n 8  2 23  4 24\n21  9 14 16  7\n 6 10  3 18  5\n 1 12 20 15 19\n\n 3 15  0  2 22\n 9 18 13 17  5\n19  8  7 25 23\n20 11 10 24  4\n14 21 16 12  6\n\n14 21 17 24  4\n10 16 15  9 19\n18  8 23 26 20\n22 11 13  6  5\n 2  0 12  3  7"
        )
      ) should be(4512)
    }
    
    "part1 larger input" in {
      GiantSquid.part1(
        InputParser.parseMultiLine[IndexedSeq[String]](
          Source.fromResource("twentyOne/day4.txt").mkString
        )
      ) should be(60368)
    }
    
    "part2" in {
      GiantSquid.part2(
        InputParser.parseMultiLine[IndexedSeq[String]](
          "7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1\n\n22 13 17 11  0\n 8  2 23  4 24\n21  9 14 16  7\n 6 10  3 18  5\n 1 12 20 15 19\n\n 3 15  0  2 22\n 9 18 13 17  5\n19  8  7 25 23\n20 11 10 24  4\n14 21 16 12  6\n\n14 21 17 24  4\n10 16 15  9 19\n18  8 23 26 20\n22 11 13  6  5\n 2  0 12  3  7"
        )
      ) should be(1924)
    }
    
    "part2 larger input" in {
      GiantSquid.part2(
        InputParser.parseMultiLine[IndexedSeq[String]](
          Source.fromResource("twentyOne/day4.txt").mkString
        )
      ) should be(17435)
    }
  }
}
