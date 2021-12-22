package advent.puzzles.twentyOne.day18

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers
import advent.utils.InputParser
import scala.io.Source
import advent.utils.Tree
import advent.puzzles.twentyOne.day18.Snailfish._
import advent.utils._

val input1 = """[[[0,[4,5]],[0,0]],[[[4,5],[2,6]],[9,5]]]
[7,[[[3,7],[4,3]],[[6,3],[8,8]]]]
[[2,[[0,8],[3,4]]],[[[6,7],1],[7,[1,6]]]]
[[[[2,4],7],[6,[0,5]]],[[[6,8],[2,8]],[[2,1],[4,5]]]]
[7,[5,[[3,8],[1,4]]]]
[[2,[2,2]],[8,[8,1]]]
[2,9]
[1,[[[9,3],9],[[9,0],[0,7]]]]
[[[5,[7,4]],7],1]
[[[[4,2],2],6],[8,7]]"""


class SnailfishTest extends AnyWordSpec with Matchers {
  "String" when {
    "snailReduce" when {
      "explodes" in {
        "[[[[[1,2],3],4],5],6]".snailReduce() should be("[[[[0,5],4],5],6]")
      }
      
      "splits" in {
        "[15,16]".snailReduce() should be("[[7,8],[8,8]]")
      }

      "explodes and splits" in {
        "[[[[[4,3],4],4],[7,[[8,4],9]]],[1,1]]".snailReduce() should be("[[[[0,7],4],[[7,8],[6,0]]],[8,1]]")
      }
    }
  }

  "Int" when {
    "split" when {
      "splits" in {
        15.split() should be((7, 8))
      }
    }
  }

  "Snailfish" when {
    "part1" in {
      Snailfish.part1(
        InputParser.parse(input1)
      ) should be(0)
    }

    "part1 more input" in {
      Snailfish.part1(
        InputParser.parse(
          Source.fromResource("twentyOne/day18.txt").mkString
        )
      ) should be(0)
    }

    "part2" in {
      Snailfish.part2(
        InputParser.parse(input1)
      ) should be(0)
    }

    "part2 more input" in {
      Snailfish.part2(
        InputParser.parse(
          Source.fromResource("twentyOne/day18.txt").mkString
        )
      ) should be(0)
    }
  }
}
