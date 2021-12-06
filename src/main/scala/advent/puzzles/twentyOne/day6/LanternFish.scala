package advent.puzzles.twentyOne.day6

object LanternFish {
  def part1(input: IndexedSeq[Int], days: Int): BigInt = {
    var fish = input.foldLeft(Array.fill(9)(BigInt(0)))((current, next) => {
      current(next) += 1
      current
    })
    for (i <- 1 to days) {
      fish = Array(
        fish(1),
        fish(2),
        fish(3),
        fish(4),
        fish(5),
        fish(6),
        fish(7) + fish(0),
        fish(8),
        fish(0)
      )
    }
    fish.sum
  }
}
