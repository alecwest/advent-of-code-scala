package advent.puzzles.twentyOne.day10

import scala.collection.mutable.Stack
import scala.util.matching.Regex
import advent.puzzles.twentyOne.day10.Characters.ClosingCharacter

object Characters {
  case class OpeningCharacter(val char: Char) {
    def closer: Char = char match {
      case '(' => ')'
      case '[' => ']'
      case '{' => '}'
      case '<' => '>'
      case bad => throw new Exception(s"No closer assigned to ${bad}")
    }
  }

  case class ClosingCharacter(val char: Char) {
    def syntaxValue: Int = char match {
      case ')' => 3
      case ']' => 57
      case '}' => 1197
      case '>' => 25137
      case bad => throw new Exception(s"No value assigned to ${bad}")
    }

    def autocompleteValue: Int = char match {
      case ')' => 1
      case ']' => 2
      case '}' => 3
      case '>' => 4
      case bad => throw new Exception(s"No value assigned to ${bad}")
    }
  }

  def isOpeningCharacter(char: Char) = "[\\(\\[\\{<]".r.matches(char.toString)
  def isClosingCharacter(char: Char) = "[\\)\\]\\}>]".r.matches(char.toString)
}

object SyntaxScoring {
  def part1(input: IndexedSeq[String]): Int = {
    input
      .map(isCorrupt)
      .filter(_.isDefined)
      .map(_.get.syntaxValue)
      .sum
  }

  def part2(input: IndexedSeq[String]): BigInt = {
    val fixes = input
      .filter(!isCorrupt(_).isDefined)
      .map(incompleteLine => {
        val stack = new Stack[Char]()
        incompleteLine.toCharArray.foreach(char => {
          if (Characters.isOpeningCharacter(char)) {
            stack.push(Characters.OpeningCharacter(char).closer)
          } else {
            assert(stack.pop == char)
          }
        })
        stack.popAll.reverse.mkString
      })

    fixes
      .map(fix => {
        fix.toCharArray.foldLeft(BigInt(0))((acc, next) => {
          acc * BigInt(5) + BigInt(ClosingCharacter(next).autocompleteValue)
        })
      })
      .sorted
      .apply(fixes.length / 2)
  }

  def isCorrupt(chunk: String): Option[Characters.ClosingCharacter] = {
    val stack = new Stack[Char]()
    chunk.toCharArray.find(char => {
      if (Characters.isOpeningCharacter(char)) {
        stack.push(char)
        false
      } else {
        Characters.OpeningCharacter(stack.pop()).closer != char
      }
    }) match {
      case Some(c) => Some(Characters.ClosingCharacter(c))
      case None    => None
    }
  }
}
