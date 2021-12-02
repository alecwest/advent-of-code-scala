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

sealed trait Strategy {
  val maxSeats: Int
  def replaceSeat(grid: SeatingGrid, row: Int, col: Int): GridItem
}

/**
 * Check immediately adjacent to the current seat
 */
case object AdjacentSeats extends Strategy {
  val maxSeats = 4
  def replaceSeat(grid: SeatingGrid, row: Int, col: Int): GridItem = {
    val seat = grid.seatingArray(row)(col)
    SeatingGrid.countAdjacentFullSeats(grid, row, col) match {
      case x if x >= maxSeats => if (seat.symbol == FullSeat.symbol) EmptySeat else seat
      case 0 => if (seat.symbol == EmptySeat.symbol) FullSeat else seat
      case _ => seat
    }
  }
}

/**
 * Check next available seat in each direction
 */
case object NextSeats extends Strategy {
  val maxSeats = 5
  def replaceSeat(grid: SeatingGrid, row: Int, col: Int): GridItem = {
    val seat = grid.seatingArray(row)(col)
    SeatingGrid.countNextFullSeats(grid, row, col) match {
      case x if x >= maxSeats => if (seat.symbol == FullSeat.symbol) EmptySeat else seat
      case 0 => if (seat.symbol == EmptySeat.symbol) FullSeat else seat
      case _ => seat
    }
  }
}

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
    countFullSeats(grid, row, col, None)
  }

  def countNextFullSeats(grid: SeatingGrid, row: Int, col: Int): Int = {
    val condition = (item: Option[GridItem]) => {
      if (item.isDefined) {
        item.get.symbol == Floor.symbol
      } else false
    }
    countFullSeats(grid, row, col, Some(condition))
  }

  def countFullSeats(grid: SeatingGrid, row: Int, col: Int, condition: Option[Option[GridItem] => Boolean] = None): Int = {
    Array(
      north(grid, row, col, condition),
      south(grid, row, col, condition),
      east(grid, row, col, condition),
      west(grid, row, col, condition),
      northEast(grid, row, col, condition),
      northWest(grid, row, col, condition),
      southEast(grid, row, col, condition),
      southWest(grid, row, col, condition)
    ).flatten.count((item: GridItem) => item.symbol == FullSeat.symbol)
  }
  
  def north(grid: SeatingGrid, row: Int, col: Int, condition: Option[Option[GridItem] => Boolean] = None): Option[GridItem] = tryGet(grid, row, col, (r, c) => (r-1, c), condition)
  def south(grid: SeatingGrid, row: Int, col: Int, condition: Option[Option[GridItem] => Boolean] = None): Option[GridItem] = tryGet(grid, row, col, (r, c) => (r+1, c), condition)
  def east(grid: SeatingGrid, row: Int, col: Int, condition: Option[Option[GridItem] => Boolean] = None): Option[GridItem] = tryGet(grid, row, col, (r, c) => (r, c+1), condition)
  def west(grid: SeatingGrid, row: Int, col: Int, condition: Option[Option[GridItem] => Boolean] = None): Option[GridItem] = tryGet(grid, row, col, (r, c) => (r, c-1), condition)
  def northEast(grid: SeatingGrid, row: Int, col: Int, condition: Option[Option[GridItem] => Boolean] = None): Option[GridItem] = tryGet(grid, row, col, (r, c) => (r-1, c+1), condition)
  def northWest(grid: SeatingGrid, row: Int, col: Int, condition: Option[Option[GridItem] => Boolean] = None): Option[GridItem] = tryGet(grid, row, col, (r, c) => (r-1, c-1), condition)
  def southEast(grid: SeatingGrid, row: Int, col: Int, condition: Option[Option[GridItem] => Boolean] = None): Option[GridItem] = tryGet(grid, row, col, (r, c) => (r+1, c+1), condition)
  def southWest(grid: SeatingGrid, row: Int, col: Int, condition: Option[Option[GridItem] => Boolean] = None): Option[GridItem] = tryGet(grid, row, col, (r, c) => (r+1, c-1), condition)
  private def tryGet(grid: SeatingGrid, row: Int, col: Int, transform: (Int, Int) => (Int, Int), condition: Option[Option[GridItem] => Boolean]): Option[GridItem] = try {
    var location = transform(row, col)
    while (condition.isDefined && condition.get.apply(Some(grid.seatingArray(location._1)(location._2)))) {
      location = transform(location._1, location._2)
    }
    Some(grid.seatingArray(location._1)(location._2))
  } catch {
    case _: Throwable => None
  }
}

object SeatingSystem {
  def fillSeats(input: IndexedSeq[String], strategy: Strategy = AdjacentSeats): Int = {
    var seatingChart = SeatingGrid.fromMultiLineString(input).get
    var previousOccupiedCount = -1
    var currentOccupiedCount = 0
    while (previousOccupiedCount != currentOccupiedCount) {
      seatingChart = SeatingGrid(seatingChart.seatingArray.zipWithIndex map {
        case (row, rowIndex) =>
          row.zipWithIndex map {
            case (_, columnIndex) => strategy.replaceSeat(seatingChart, rowIndex, columnIndex)
          }
      })
      previousOccupiedCount = currentOccupiedCount
      currentOccupiedCount = seatingChart.seatingArray.map(_.count(_.symbol == FullSeat.symbol)).sum
    }
    currentOccupiedCount
  }
}
