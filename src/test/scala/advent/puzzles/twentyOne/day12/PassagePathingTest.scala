package advent.puzzles.twentyOne.day12

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers
import advent.utils.InputParser
import scala.io.Source

val input1 = """start-A
start-b
A-c
A-b
b-d
A-end
b-end"""

val input2 = """dc-end
HN-start
start-kj
dc-start
dc-HN
LN-dc
HN-end
kj-sa
kj-HN
kj-dc"""

val input3 = """fs-end
he-DX
fs-he
start-DX
pj-DX
end-zg
zg-sl
zg-pj
pj-he
RW-he
fs-DX
pj-RW
zg-RW
start-pj
he-WI
zg-he
pj-fs
start-RW"""

class PassagePathingTest extends AnyWordSpec with Matchers {
  "PassagePathing" when {
    "part1-1" in {
      PassagePathing.part1(
        InputParser.parse(input1)
      ) should be(10)
    }
    
    "part1-2" in {
      PassagePathing.part1(
        InputParser.parse(input2)
      ) should be(19)
    }

    "part1-3" in {
      PassagePathing.part1(
        InputParser.parse(input3)
      ) should be(226)
    }

    "part1 more input" in {
      PassagePathing.part1(
        InputParser.parse(
          Source.fromResource("twentyOne/day12.txt").mkString
        )
      ) should be(5756)
    }

    "part2-1" in {
      PassagePathing.part2(
        InputParser.parse(input1)
      ) should be(36)
    }

    "part2-2" in {
      PassagePathing.part2(
        InputParser.parse(input2)
      ) should be(103)
    }

    "part2-3" in {
      PassagePathing.part2(
        InputParser.parse(input3)
      ) should be(3509)
    }

    "part2 more input" in {
      PassagePathing.part2(
        InputParser.parse(
          Source.fromResource("twentyOne/day12.txt").mkString
        )
      ) should be(144603)
    }
  }
}
