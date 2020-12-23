package com.alecnwest
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
  def numTreesHit(input: IndexedSeq[String],
                  slopeRight: Int = 3,
                  slopeDown: Int = 1): Int = {
    val map = buildMap(input)
    if (map.isEmpty) return 0

    val rowLength = map(0).length
    var colNumber = 0
    var rowNumber = 0
    var count = 0
    while (rowNumber < map.length) {
      map(rowNumber)(colNumber) match {
        case Open =>
        case Tree => count = count + 1
        case bad => throw new Exception(s"Unexpected object in map: $bad")
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
