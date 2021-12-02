package advent.puzzles.twentyOne.depthmeasurement

object DepthMeasurement {
  def measure(input: IndexedSeq[Int]): Int = {
    input.zipWithIndex.count((num, index) => index != 0 && num > input(index-1))
  }
}
