package advent.puzzles.toboggantrajectory

sealed trait Obstacle {
  def name: String
  def symbol: Char
}
case object Open extends Obstacle {
  val name = "Open"
  val symbol = '.'
}
case object Tree extends Obstacle {
  val name = "Tree"
  val symbol = '#'
}

case class UnsupportedObstacle(msg: String) extends Exception(msg)

/**
  * Day 3
  */
object TobogganTrajectory {
  def productMultipleSlopes(input: IndexedSeq[String],
                            slopes: List[(Int, Int)] = List(3 -> 1)): Long = {
    slopes.map(pair => numTreesHit(input, pair._1, pair._2)).product
  }

  def numTreesHit(input: IndexedSeq[String],
                  slopeRight: Int = 3,
                  slopeDown: Int = 1): Long = {
    val map = buildMap(input)
    if (map.isEmpty || map(0).isEmpty) return 0

    val rowLength = map(0).length
    var colNumber = 0
    var rowNumber = 0
    var count: Long = 0
    while (rowNumber < map.length) {
      map(rowNumber)(colNumber) match {
        case Open =>
        case Tree => count = count + 1
      }
      rowNumber = rowNumber + slopeDown
      colNumber = (colNumber + slopeRight) % rowLength
    }
    count
  }

  private def buildMap(
      input: IndexedSeq[String]): IndexedSeq[IndexedSeq[Obstacle]] = {
    input.map(row => {
      row.toCharArray.map {
        case Open.symbol => Open
        case Tree.symbol => Tree
        case bad =>
          throw UnsupportedObstacle(s"Obstacle not supported with symbol $bad")
      }
    })
  }
}
