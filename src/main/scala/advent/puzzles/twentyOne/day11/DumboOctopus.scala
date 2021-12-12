package advent.puzzles.twentyOne.day11

import advent.utils._

object DumboOctopus {
  def part1(input: IndexedSeq[String]): Int = {
    val grid: Grid[Int] = toGrid[Int](input)
    Iterator.iterate(grid, 101)(step).map(_.count(_._2 == 0)).sum
  }

  def part2(input: IndexedSeq[String]): Int = {
    val grid = toGrid[Int](input)
    Iterator
      .iterate(grid)(step)
      .zipWithIndex
      .dropWhile(_._1.count(_._2 == 0) != grid.size)
      .next
      ._2
  }

  private def step(grid: Grid[Int]) = {
    val stepOne = grid.increment()
    val stepTwo = flash(stepOne)
    stepTwo.setAll(0, (_, value) => value > 9)
  }

  private def flash(
      grid: Grid[Int],
      alreadyFlashed: Set[Point] = Set.empty
  ): Grid[Int] = {
    val flashing = grid.filter(_._2 > 9) -- alreadyFlashed

    if (flashing.size == 0) {
      return grid
    }

    val affectedNeighbors = flashing
      .flatMap(flasher => flasher._1.neighbors)
      .groupBy(identity)
      .mapValues(_.size)

    val newGrid = grid
      .map((point, value) => {
        (point, value + affectedNeighbors.getOrElse(point, 0))
      })
      .asInstanceOf[Grid[Int]]

    flash(newGrid, alreadyFlashed ++ flashing.map(_._1))
  }

  extension (grid: Grid[Int]) {
    def increment(
        condition: ((Point, Int)) => Boolean = (p) => true
    ): Grid[Int] = {
      grid
        .map(p => (p._1, p._2 + (if (condition(p)) 1 else 0)))
        .toMap
        .asInstanceOf[Grid[Int]]
    }

    def setAll(
        value: Int = 0,
        condition: ((Point, Int)) => Boolean = (p) => true
    ): Grid[Int] = {
      grid
        .map(p => (p._1, (if (condition(p)) 0 else p._2)))
        .toMap
        .asInstanceOf[Grid[Int]]
    }
  }
}
