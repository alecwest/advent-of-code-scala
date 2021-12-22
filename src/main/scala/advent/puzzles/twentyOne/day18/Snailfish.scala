package advent.puzzles.twentyOne.day18

import advent.utils.Tree
import advent.utils.Leaf
import advent.utils.Node
import scala.collection.mutable

object Snailfish {
  def part1(input: IndexedSeq[String]): Int = {
    val trees = input.map(Tree.fromLine).toList
    0
  }

  def part2(input: IndexedSeq[String]): Int = {
    0
  }

  extension (s: String) {
    def snailReduce(): String = {
      def _snailReduce(s: String): String = {
        val explodeIndex = s.zipWithIndex
          .foldLeft((0, -1))((acc, next) =>
            (
              acc._1 + (if (next._1 == '[') 1
                        else if (next._1 == ']') -1
                        else 0),
              if (acc._1 == 5 && acc._2 == -1) next._2 - 1 else acc._2
            )
          )
          ._2
        val splitIndex = s.sliding(2).toList.indexWhere(_.toIntOption.isDefined)
        val builder = mutable.StringBuilder(s)

        if (
          (explodeIndex > -1 && splitIndex > -1 && explodeIndex <= splitIndex) || explodeIndex > -1
        ) {
          // explode
          val thingToExplode = s.slice(explodeIndex, explodeIndex + 5)
          val leftAffectedNumberIndex =
            s.take(explodeIndex).reverse.indexWhere(_.isDigit)

          if (leftAffectedNumberIndex > -1) {
            val replaceIndex = explodeIndex - leftAffectedNumberIndex - 1
            val newValue = (
              builder.charAt(replaceIndex).asDigit + thingToExplode.charAt(1).asDigit
            ).toString
            builder.replace(
              replaceIndex,
              replaceIndex + 1,
              newValue
            )
          }
          val newExplodeIndex = builder.sliding(5).indexWhere(_.toString == thingToExplode)
          val rightAffectedNumberIndex = if (newExplodeIndex > -1) newExplodeIndex + 5 + builder.drop(newExplodeIndex + 5).indexWhere(_.isDigit) else -1

          if (rightAffectedNumberIndex > -1) {
            val replaceIndex = rightAffectedNumberIndex
            val newValue =
              (builder.charAt(replaceIndex).asDigit + thingToExplode
                .charAt(3)
                .asDigit).toString
            builder.replace(
              replaceIndex,
              replaceIndex + 1,
              newValue
            )
          }
          builder.replace(newExplodeIndex, newExplodeIndex + 5, "0")
          builder.toString
        } else if (
          (explodeIndex > -1 && splitIndex > -1 && explodeIndex > splitIndex) || splitIndex > -1
        ) {
          // split
          val split =
            Integer.parseInt(s.slice(splitIndex, splitIndex + 2)).split()
          builder.replace(
            splitIndex,
            splitIndex + 2,
            s"[${split._1},${split._2}]"
          )
          builder.toString
        } else {
          s
        }
      }
      Iterator
        .iterate(s)(_snailReduce)
        .sliding(2)
        .dropWhile(r => {
          r(0) != r(1)
        })
        .take(1)
        .map(_.head)
        .toList
        .head
    }
  }
  extension (n: Int) {
    def split(): (Int, Int) = {
      (Math.floor(n / 2.0).toInt, Math.ceil(n / 2.0).toInt)
    }
  }
}
