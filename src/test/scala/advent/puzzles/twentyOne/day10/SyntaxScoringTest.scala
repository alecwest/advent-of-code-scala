package advent.puzzles.twentyOne.day10

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers
import advent.utils.InputParser
import scala.io.Source

class SyntaxScoringTest extends AnyWordSpec with Matchers {
  private val simpleInput = """[({(<(())[]>[[{[]{<()<>>
[(()[<>])]({[<{<<[]>>(
{([(<{}[<>[]}>{[]{[(<()>
(((({<>}<{<{<>}{[]{[]{}
[[<[([]))<([[{}[[()]]]
[{[{({}]{}}([{[{{{}}([]
{<[[]]>}<{[{[{[]{()[[[]
[<(<(<(<{}))><([]([]()
<{([([[(<>()){}]>(<<{{
<{([{{}}[<[[[<>{}]]]>[]]"""

  "SyntaxScoring" when {
    "part1" in {
      SyntaxScoring.part1(
        InputParser.parse(simpleInput)
      ) should be(26397)
    }

    "part1 more input" in {
      SyntaxScoring.part1(
        InputParser.parse(
          Source.fromResource("twentyOne/day10.txt").mkString
        )
      ) should be(364389)
    }

    "part2" in {
      SyntaxScoring.part2(
        InputParser.parse(simpleInput)
      ) should be(BigInt(288957))
    }

    "part2 more input" in {
      SyntaxScoring.part2(
        InputParser.parse(
          Source.fromResource("twentyOne/day10.txt").mkString
        )
      ) should be(BigInt("2870201088"))
    }
  }
}
