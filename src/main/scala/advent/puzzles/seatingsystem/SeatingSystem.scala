package com.alecnwest
package advent.puzzles.seatingsystem

sealed trait GridItem {
  val symbol: Char
}

case object EmptySeat extends GridItem {
  val symbol = 'L'
}

case object FullSeat extends GridItem {
  val symbol = '#'
}

case object Floor extends GridItem {
  val symbol = '.'
}

sealed case class SeatingGrid(seatingArray: IndexedSeq[IndexedSeq[GridItem]])

object SeatingGrid {
  def fromMultiLineString(s: IndexedSeq[String]): Option[SeatingGrid] = {
    Some(SeatingGrid(s.map(row => {
      row.toCharArray.map {
        case EmptySeat.symbol => EmptySeat
        case FullSeat.symbol => FullSeat
        case Floor.symbol => Floor
        case _ => throw new Exception("uhhh?")
      }.toIndexedSeq
    })))
  }
  
  def countAdjacentFullSeats(grid: SeatingGrid, row: Int, col: Int): Int = {
    Array(
      north(grid, row, col),
      south(grid, row, col),
      east(grid, row, col),
      west(grid, row, col),
      northEast(grid, row, col),
      northWest(grid, row, col),
      southEast(grid, row, col),
      southWest(grid, row, col)
    ).flatten.count((item: GridItem) => item.symbol == FullSeat.symbol)
  }
  
  def north(grid: SeatingGrid, row: Int, col: Int): Option[GridItem] = tryGet(grid, row-1, col)
  def south(grid: SeatingGrid, row: Int, col: Int): Option[GridItem] = tryGet(grid, row+1, col)
  def east(grid: SeatingGrid, row: Int, col: Int): Option[GridItem] = tryGet(grid, row, col+1)
  def west(grid: SeatingGrid, row: Int, col: Int): Option[GridItem] = tryGet(grid, row, col-1)
  def northEast(grid: SeatingGrid, row: Int, col: Int): Option[GridItem] = tryGet(grid, row-1, col+1)
  def northWest(grid: SeatingGrid, row: Int, col: Int): Option[GridItem] = tryGet(grid, row-1, col-1)
  def southEast(grid: SeatingGrid, row: Int, col: Int): Option[GridItem] = tryGet(grid, row+1, col+1)
  def southWest(grid: SeatingGrid, row: Int, col: Int): Option[GridItem] = tryGet(grid, row+1, col-1)
  private def tryGet(grid: SeatingGrid, row: Int, col: Int): Option[GridItem] = try {
    Some(grid.seatingArray(row)(col))
  } catch {
    case _: Throwable => None
  }
}

object SeatingSystem {
  def fillSeats(input: IndexedSeq[String]): Int = {
    var seatingChart = SeatingGrid.fromMultiLineString(input).get
    var previousOccupiedCount = -1
    var currentOccupiedCount = 0
    while (previousOccupiedCount != currentOccupiedCount) {
      seatingChart = SeatingGrid(seatingChart.seatingArray.zipWithIndex map {
        case (row, rowIndex) =>
          row.zipWithIndex map {
            case (seat, columnIndex) =>
              SeatingGrid.countAdjacentFullSeats(seatingChart, rowIndex, columnIndex) match {
                case x if x >= 4 => if (seat.symbol == FullSeat.symbol) EmptySeat else seat
                case 0 => if (seat.symbol == EmptySeat.symbol) FullSeat else seat
                case _ => seat
              }
          }
      })
      previousOccupiedCount = currentOccupiedCount
      currentOccupiedCount = seatingChart.seatingArray.map(_.count(_.symbol == FullSeat.symbol)).sum
    }
    currentOccupiedCount
  }
}
