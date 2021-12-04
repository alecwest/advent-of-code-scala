package advent.puzzles.twentyOne.day4

sealed case class BoardPiece(val num: Int, var selected: Boolean)

object GiantSquid {
  def part1(input: IndexedSeq[IndexedSeq[String]]): Int = {
    val draws = input(0)(0).split(",").map(_.toInt)
    val boards = input.drop(1).map(b => b.map(n => BoardPiece(n.toInt, false)))

    var winningBoard: Option[IndexedSeq[BoardPiece]] = None
    val winningNumber = draws.find(draw => {
      val winner = boards.find(gb => {
        val index = gb.indexWhere(b => b.num == draw)
        if (index > -1) {
          gb(index).selected = true
        }
        if (isWinningBoard(gb)) {
          winningBoard = Some(gb)
          true
        } else {
          false
        }
      })
      winner.isDefined
    })
    sumWinningBoard(winningBoard.get) * winningNumber.get
  }

  def part2(input: IndexedSeq[IndexedSeq[String]]): Int = {
    val draws = input(0)(0).split(",").map(_.toInt)
    var boards = input.drop(1).map(b => b.map(n => BoardPiece(n.toInt, false)))

    var winningBoard: Option[IndexedSeq[BoardPiece]] = None
    val winningNumber = draws.find(draw => {
      boards.foreach(gb => {
        val index = gb.indexWhere(b => b.num == draw)
        if (index > -1) {
          gb(index).selected = true
        }
      })
      
      if (boards.length == 1 && isWinningBoard(boards.head)) {
        winningBoard = Some(boards.head)
        true
      } else {
        boards = boards.filter(b => !isWinningBoard(b))
        false
      }
    })
    sumWinningBoard(winningBoard.get) * winningNumber.get
  }

  private def sumWinningBoard(board: IndexedSeq[BoardPiece]): Int =
    board.foldLeft(0)((current, next) => {
      current + (if (!next.selected) next.num else 0)
    })

  private def isWinningBoard(board: IndexedSeq[BoardPiece]): Boolean = {
    List(
      // check horizontal
      board.slice(0, 5),
      board.slice(5, 10),
      board.slice(10, 15),
      board.slice(15, 20),
      board.slice(20, 25),
      // check vertical
      board.drop(0).grouped(5).map(_.head).toIndexedSeq,
      board.drop(1).grouped(5).map(_.head).toIndexedSeq,
      board.drop(2).grouped(5).map(_.head).toIndexedSeq,
      board.drop(3).grouped(5).map(_.head).toIndexedSeq,
      board.drop(4).grouped(5).map(_.head).toIndexedSeq
      // check diagonal
      // board.drop(0).grouped(6).map(_.head).toIndexedSeq,
      // board.drop(4).grouped(4).map(_.head).take(5).toIndexedSeq,
    ).find(slice => slice.forall(_.selected)).isDefined
  }
}
