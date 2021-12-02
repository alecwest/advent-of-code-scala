package advent.puzzles.twentyOne.depthmeasurement

object DepthMeasurement {
  def measure(input: IndexedSeq[Int]): Int = {
    input.zipWithIndex.count((num, index) =>
      index != 0 && num > input(index - 1)
    )
  }

  def measureSlidingWindow(input: IndexedSeq[Int]): Int = {
    val sums = input.zipWithIndex
      .map((num, index) => {
        if (index <= input.length - 3) {
          num + input(index + 1) + input(index + 2)
        } else {
          -1
        }
      })
      .filter(num => num != -1)
    measure(sums)
  }
}
