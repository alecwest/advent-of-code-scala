package advent.puzzles.twentyOne.day7

object Whales {
  def part1(input: IndexedSeq[Int]): Int = {
    val sorted = input.sorted
    val median = sorted(sorted.length / 2)
    sorted.foldLeft(0)((current, next) => {
      current + Math.abs(next - median)
    })
  }
  
  def part2(input: IndexedSeq[Int]): Int = {
    val avg = 1.0 * input.sum / input.length
    val roundUp = Math.ceil(avg).toInt
    val roundDown = Math.floor(avg).toInt
    val paths = input.foldLeft((0, 0))((current, next) => {
      val numStepsUp = Math.abs(next - roundUp)
      val numStepsDown = Math.abs(next - roundDown)
      (current._1 + (1 to numStepsDown).sum, current._2 + (1 to numStepsUp).sum)
    })
    Math.min(paths._1, paths._2)
  }
}
