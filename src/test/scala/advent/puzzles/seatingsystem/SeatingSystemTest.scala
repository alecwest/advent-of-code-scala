package com.alecnwest
package advent.puzzles.seatingsystem

import advent.utils.InputParser
import org.scalatest.{Matchers, WordSpecLike}

class SeatingSystemTest extends WordSpecLike with Matchers {

  "SeatingSystemTest" when {
    "fillSeats" should {
      "return the number of seats filled from example input" in {
        SeatingSystem.fillSeats(
          InputParser.parse[String]("L.LL.LL.LL\nLLLLLLL.LL\nL.L.L..L..\nLLLL.LL.LL\nL.LL.LL.LL\nL.LLLLL.LL\n..L.L.....\nLLLLLLLLLL\nL.LLLLLL.L\nL.LLLLL.LL")
        ) should be(37)
      }

      "return the number of seats filled from puzzle input" in {
        SeatingSystem.fillSeats(
          InputParser.parse[String]("LLLLLL.LL.LLLLLL.LLLLLLL.LLLLLL.LLLLL.LLLLLLLLLLLLLLLLLL.LLLL.L.LLL.LLLLLLLL.LLLLLLLL.LLLLL\nLLLLLL.L.LL.LLLL.L.LLLL.LLLLLLL.LLLLL.LLLLLLLL.LLLLLL.LLLLLLL.LLLLLLLLLLLLLL.LLLLLLLL.LLLLL\nLLLLLL.LLLL.LLLL.LLLLLLLLLLLLLL.LLLLL.LLLL.LLLLLLLLLLL.L.LLLL.LLLLL.LLL..LLL.LLLLLLLLLLLLLL\nLLLLLL.LLLL.LLLLLLLLLL.L.LLLLLLLLLLLLLLLLLLL.L.LLLLLLL.L.L.LL.LLLLL..LLLLLLL.LLLLLLLL.LL.LL\nLLLLLL.LLLL.LLLL.LLLLLLLLLLLLL..LLLLLLLLLLLLLL.LLLL.LL.LLLLLL.LLLLL.LLL.LLLL.LLLLLLLL.LLLLL\nLLLL.L.LLLLLLLLLLLLLLLLLLLLLLLL.LLLLL.LLLLLLLL.LLLLLLL.LLL.L..LLLLL.LLLLLLLL.L.LLLLLL.LLLLL\nLLLLLL..LLL.LLLL.LLLLLLLL.LLLLLLLLLLLLLLLLLL.L.LLLL.LLLLLL.LL.LLLLL.LLLLLLLLLLLLLLLLL.LLLLL\nLLLLLL.LLLLLLLLLLLL.LLLL.LLLLLL.LLLLL.LL.LLLLLLLLLLLLLLLLLLLL.LLLLL.LLLLLLLL.LLLLLLLLLLLLLL\nLLLLLL.LLLLLLLL.LLLLLLLL.LLLLLLLLLLLL.LLLLLLLL..LLLLLLLLLLLLL.LLLLL.LLLLLLLL.LLLLLLLL.LLLLL\n.L.L......LL..LL.....L..L...L...L.L...L.LL.....LL..L..L....L...L....L......L.L.L...L.LLLL..\nLLLLLLLLL.L.LLLL.LLLLLLLLLLLLLLLLLLLL.LLLLLLLL.LLLLLLL.LLLLLL.LLLLL.LLLLLLLL.LLLLLLLLLLLLLL\nLLLLLLLLLLLLLLLL.LLLLLLL.LLLL.L.LLLLL.LLLLLLLL.LLLLLLL.LLLLLLLLLLL..LLLLLLLL.LLLLLLLL.LLLLL\nLL.LLLLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLL.LL.LLLL.LLLLLLLLLLLL.LLLLLLLL.LLLLLLLL.LLLLL\n.LLLLL.LLLL.LLLL..LLLLLL.L.LLLLLL.LLL.LLLLL.LL.LLLLLLL.LLLLLLLLLLLLLLLLLLLLL.LLLLLLLLLL.LLL\nLLLLLL.LLLL.LL.LLLLLLLL.LLLLLLL.LLLLL.LLLLLLLL.LLLLLLL.LLLLLL.LLLLL.LLLLLLLLLLLLL.LLL.LLLLL\nLLLLL.LLLLLLL.LL.LLLLLL..LLLLLL..LLLL.LLLLLLLL.L.LLL.L.LLLLLLLLLLLL.LLLLLLLLLLLLLLLLL.LLLLL\nLLLLLLLLLLL.LLLL.LLLLLLL.LLLLLLLLLLLL.LLLLLLLL.LLLLLLL.LLLLLLLLLLLL.LLLLL.LLLLLLLLLLL.LLLLL\n.LLLLL.LLLL.L.LL..LLLLLL.LLLLLL.LLLLL.LLLLLLLLLLLLLLLLLLLLL.L.LLLLLLLLLLLLLLLLLLLLLLL.LLLLL\nLLLLLL.LLLLLLLLL.LLLLLLL.LLLLLLLLLLLL.LLLLLLLL.LLLLLLL.L.LLLL.LLLLL.LLLLLLLL..LLLLLLL.LLLLL\n.L...LL.LLL....LL..LL...L..LLL.LL...L...L........L....LL..L...L.....LL......L...L..LL....L.\nLL.LLL.LLLLLLLLL.LLLLLLL.LLLLLL.L.LLL.LLLLLLLL.LLLLLL..LLLLLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLL\nLLLLLLLLLLL.LLLL.LLLLLLLLLLLLLL.LLLLLLLLLLLL.LLLLLLLLLLLLLLLL.LLLLL.LLLLLLL..LLLLLLL...LLLL\nLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLLL.LLLL.LLLLLLLL.LLLLLLL.LLLLLLLLLLLL..LLLLLLL.LLLLLLLL.LLLLL\nLLL.LL.LLLLLLL.LLL.LLLLL.LLLLLLLLLLLL.LL.LLLLL..LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLL\nLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLLLLL.LLLLLL.LLLLLLLLL.LLLLLL.LLLLLLLLLLLLL.LLLLLLLLL.LLLLL\nL..LLL.LLLL.LLLLLLLLLLLL.LL.LLLLLLLLLLLLLLLLLL.LLLLLLLLLL.LLL.LLLLLLLLLLLLLLLLLLLLLLLLLLLLL\nLLLLLL.LLLL.LLLL.LLLLLLLLLLLLLL.LLLLL.LLLLLLLL.LLLLLLLLLLLLLL.LLLLL.LLLLLLLLLLLLL.LLL.LLLL.\nLLLLLL.LLL..LLLLLLLLLLLL.LLLLLLLLLLLLLLLLL.LLL.LLLLLLL.LLLLLL.LLLLL.LLLL.LLL.LLLLLLLL.LLLLL\n..LL...LLL....L....L.LLL.L.L...L.LLL..L...L..L..L........L.LL.L.L.LLLLLL...L.L.LL.L....LL..\nLLLLLL.LLLLLLLLL.LL.L.LL.LLLLLL.L.LLL..LLLLLLL.LLLLLLL.LLLLLL.LLLLL.LLLLLLLL.LLLLLLLLLLLLLL\nLLLLLL..LL.LLLLLLLL.LLLL.LLLLLL.LLLLL.L.LLL.LL.LLLLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLL.L..LL\nLLLLLL.LLLLLLLLL.LL.LLLLLLLLLLL.LLLLL.LLLLLLLLLLLLLL.L.LLLLLL.LLLLL.LLLLLLLL.LLLLLLLL.LLLLL\nLLLLLL.LLLL.LLLLLLL.LLLLLLLLLLLLLLLLL.LLLLLLLLLLLLL.LL.LLLLLL.LLLLL.LLLLLLLL.LLLLLLLLLLLLLL\nLLLLLL.LLLLLLLLL.LLLLLLL.LLLLLL.LLLLLLLLLLLLLL.LLLLLLLLLLLLLL.LLLLL.LLLLLLLL.LLLLLLLLLLLLLL\nLLLLLL.LL...LLLL.LLLLLLL.L.LLLL.LLLLLLLLLLLLLLLLLLLLLL.LLLLLL.LLLLL.LLLLLLLLLLLLLLLLLLLLLLL\nL.L.LL.....L.......L.....LLL..L......LL.LLL....L.L.L..........L.LL..LLL..L....LL..L..L..L.L\nLLLLLL.LLLLLLLLLLLLLLLLLLLLLLLL.LLLLL.LLLLLLLL.LLL.LLL.LLLLLL.LLLLLLLLLLLLLL.LLLLLLLLLLLLLL\nLLLLLL.LLLL.LLLLLLLLLLLL..LLLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLL.LL.LL.LLLLLLLLLLLLLLLLL.LL.LL\nLLLLLLLLLLL.LLLL.L.LLLLL.LLLLLL.LLLLL.LLLLLLLL.LLLLLLLLLLLLLL.LL.LLLLLLLLLL..LLLLLLLL.LLLLL\nLLLLLLLLLLLLLLLL.LL.LLLLLLLLLLL..LLLL.LLLLLL.L.LLLLLLL.LLLLL..LLLLLLLLLL.LLL.LLLL.LLLLLLLLL\nLLLLLL.LLLL.LLLLLLLLLLLL.LLLLLL.LLLLLLLLLLLLLL.LLLLLLL.LLLLLL.LLLLLLLLLLLLLL.LLLLLLLLLLLL.L\nLLLLL.LLLLLLLLLLLLLLL.LL.LLLL.L.LLLLL.LLLLLLLLLLLLLLLL.LLLLLL.L.LLLLLLLLLLLL.LLLLLLLL.LLLLL\n..LLLL.L...LLL.L......L....L.L..L......LL..L.LL.LL.LL................LL.LL....L.........L..\nLLLLLL.LLLL.LLLL.LLLLLLL.LLLLLL.LLLLL.LLLLLLLL.LLLLLLL.LLLLLL.LLLLLLLLLLLLL.LLLLLLLLL..LLLL\nLLLLLLLLLLLLLLLL.LLLLLLL.LLLLLL..LLLLLLLLLLLLL.LLLLLLL.LLLLLL.LLLLLLLLLLLLLL.L.LL.LLL.LLL.L\nLLLLLL.LLLL.LLLL.LLLLLLL.LLLLLL.LLLLLLL.LLLLLL.LLLLLLL.LLLLLLLLLLLLLLLLLLLLL.LLLLLLLL.LLLLL\nLLLLLL.LLLL.LL.L.LLLLLLL.LLLLLLLLLLLL.LLLLLLLL.LLLLLLL.LLLLLL.L.L.L.LLLLLLLL.LL.LLLLLLLL.LL\nLLL.LL.LLLL.LLLL.LLLLLLL.LLLLL..LLLLL.LLLL.LLL.LLLLLLLLLLLLL..LLLLLLLLLLLLLLLLLLLLLLL.LLLLL\nLLLLLLLLLLL.LLLL.LLLLLLL.LLLLLL.LLLLLLLLLLLLLLLLLLLLL..LLLLLL.LLLLL.LLLLLLLL.LLLLLLLLLLLLLL\nL.LLLL.LLLL.LLLLLLLLLLLL.LLLLLLLL.LLLLLLL.LLLL.LLLLLLL.LLLLLL.LLLLL.LLLLLLLL.LLLLLLLLLLLLLL\nLLLLLL.LLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLLLL.L..LLLLLLLLLLLLLL.LLLLLLLLLLLLLL.LLLLLLLL.LLLLL\n..L..L.L.LLLL.....LLL.LLL....L..LL.L..L......L.............LL....LL..L.L..L...L.....L.L...L\nLLLLLL.LLLL.L.LL.L.LLLLLLLLLLLL.LLLLL.LLLLLLLL.LLLLLLL.LLLLLL.LLLLL.LLLLLLLLLL.LLLLLLLLLLLL\nLLLLLL..LLL.LLLL.LLLLLLL.LLLLLL.LLLLL.LLLL.LLL.LLLLLLLLLL.LLLLLLLLL.LLLLLLLLLLLLLLLLLLLLLLL\nLLLLLL.LLLL..LLLLLLLLLLL.LLLLLL.L.LLL.LLLLLLLLLLLLLL.LLLLLLLLLLLLLL.LL.LLL.L.LLLLLLLL.LLLLL\nLLLLLL.LLLLLLLLLLLLLLLLL.LLLLLL.LLLLL.LLLLLLLL.LLLLLLL.L.LLL.LLLLLLLLLLLLLLL.LLLLLLLL.LLLLL\nLLLLLL.LL.L.LL.L.LLLLLLLLL.LLLLLLLLLL.LLLLLLLL.LLLLLLL.LLLLLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLL\nLLLLLLLLL.L.LLLLLLLLLL.L.LLLLL.LLLLLL.LLLLLLLL.LLLLLLL.LLLLLL.LLLLL.LLLLLLLLLL.LLLLLLLLLLLL\nLLLLLL.LLLLLL.LL.LLLLLLLL.LLLLL.LLLLL.LLLLLLLL.LLLLLLL.LLLLLL.LLLLL.LLLLLLLLL.LLLLLLLLLLLL.\nLLLLLL.LLLL.LLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLL.LLLLLLL.LLLLLL.LLLLL.LLLLLLLLL.LLLLLLLL.LLLL\n....L..L..LL....L.L.LLL.L.L...L...L.L.L..L..L...LLL.......L.......LL..L...LL..L.L....LL.LL.\nLLLLLL.LLLL.LL.LLLLLLLLLLLLLLLLLLLLLL.LLLLLLLL.LLLLLLL.LLLLL.LLLLLLLLLLLLLLL.LLLLLLLL.LLLLL\nLLLLLL.LLLL.LLLL..LLLLLL.LLLL.L.LLLLL.LLL.LLLL.LLLLLLL.LLLLLLLLLLLL.L.LLLLLL.LLLLLLLLLLLLLL\nLLLLLL.LLLL.LLLLLLLLLLLL.LLLLLL.LLLLL.LLLLLLLL.LLLLLLLLLLLLLL.LLLLLLLLLLLLLL.L.LLLLLL..LLLL\nLLLLLLLLLLLLLLLL.LLLLLLL.LLLLLL.LLLLL.LLLLLLLLLLLLLLLL.L.LLLL.LLLLL.LLLLL.LL.LLLLLLLL.LLLLL\n.LLLLL.LLLL.LLLLLLLLLLLL.L.LLLLLLLLLL.LLLLLLLL.LLLLLLLLLLL.LL.L.LLLLLLLLLLLL.LLLLL.LL.LLLLL\nLL.LLL.LLLL.LLLL.LLLLLLLLLLLLLL.LLLLL.LLLL.LLL.L.L.LLL.LLLLLL.LLLLL.LLLLLLLL.LLLLLL.L.LLLLL\nLLLLLLLLLLLLLL.L.LLLLLLL.LLLLLL.LLLLL.LLL.LLLLLLLLLLLL.L.LLLL.LLLLL.LLLLLLLLLLLLLLLLL.LLLL.\nLLLLLL.L.LL.LLLLLLLLLLLL.LL.LLL.LLLLL.LLLLLLLL.LLLLLLL.LLLLLL.L.LLL.LLLLLLLL.LLLLLLL.LLLLLL\nLLLLLLLLLLL.LLLLLLLLLLLL.L.L.LL.LLLLL.LLLLLLLLLLLLLLLL.LLLLLLLL.LLL.LLLLL.LLLLLLLLLLL.LLLLL\n.L...LL..LL....L...L.....LLLL..L....L..LL...L...LLL...L.LLL..L.LL.L.L.LL.L..LL.....LLLL.LL.\nLLLLLL.LLLL.LLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLL.LLLL..LLLLLLLL.LLLLLLLLLLLLLL\nLLLLLLLLLLL.L.LLLLLL.LLLLLLLLLL.L.LLL.LLLL.LLLLLLLLLLL.LLLLLL.LLLLL.LLLLLLLLL.LLLLLLL.LLLLL\nLLLLLL.LLLL.LLLL.LLLLLLL.LL.LLLLLLLLL.LLLLLLL..LLLLLLL.LLL.LL.LLLLL.LLLLL.LL.LLLLLL.L.LLLLL\nLLLLLL.LLLL.LLLL.LLLLLLLLLLL.LL.LLLLLLLLLLLLLL.LLLLLLL.LLLLLLLLLLLL.LLLLLLLL.LLLLLLLLLLLLLL\nLLLLLLLLLLL.LLLLLLLLLLLL.LLLLLL.LLLLL..LLLLLLL.LLLLLLL.LLLLLL.LLLLL.LLLLLLLL..LLLLLLL.LLLLL\nLLL.LLLLLLL.LLLL.LLLLLLL.LLLLLLLLL.LL.LLLLLLLL.LLLLLLL..LLLLL.LLLLLLLLLLL.LL.LLLLLLLLLLLLL.\nLLLLLLLL.LLLLLLL.LLLLLLLLLLLLLL.LLLLL.LLLLLLLL.LLLLLLL.LLLLLLLLLLLL.LLLLL.LLL.LLLLLLLLLLLLL\n...L...L.L......L..L..L.LL...L..........L..L.L.L........L..L..L.L.LL..LL..LL.........L.....\nLLLL.L.LLLL.LLLL.LLLLLLLLLLLLLL.LLLLLLLLLLLLLL.LLLL.LLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLL.LLLLL\nLLLLLLLLLLL.LLLLL.LLLLLLLLLLLLL.LLLLL.LLLLLLLL.LLLLLLLLLLLLLL.LLLLLLLLLL.LLLLLLLLLLLLLLLLLL\nLLLLLL.LLLLLLLLLLLLLLLLL.LLLLLL.L.LLL.LL.LLLLLLLLLLLL..LLLLL..LLLLL.LLLLLLL..LLLLLLLLLLLLLL\nLLLLLL.LLLL.LLLL.LLLLLLL.LLLLLL.LLLLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLLLLL.LLLL.LLLLL\n.LLLLL.LLLLLLLLL.LLLLLLL.LLLLLLLLLLLLLLLLLLLLL.LLLLLLL.LLLLLL.LLLLL.LLLLLLLL.LLLLLLLL.LLLLL\nL.LL.LLLLLL.LL.L..LLLLLL.LLLLLL.LLLLLLLLLLLLLL.LL.LLLLLLLLLLL.LLLLLLLLLLLLLLLLLLL.LLL.LLLLL\nL..L...L..L...LL...L.L.L..LLL.LL...L......LLL...L.L....L.......L...L.LL.L....L....L...L....\nLLLLLL.LLLL.LLLL.L.LLLLL.LLL.LL.LLLLL.LLLL.LLL.LLLLLLLLLLLLLL.LLLLLLLLLLLLLL.LLLLLLLL.LLLLL\nLLL.LL.LLLL.LLL...L.LLL..LLLLLL.LLLLL.LLLLLLLL.LLLLLLLLLLLLLL.LLLLLLL.LLLLLLLLLLLLLLL.LLLLL\nLLLLLL.LLLL.LLLL.LLLLLLL.LLLLLL.LLLLLLLLLLLLLL.LLLLLLL.LLLLLL.LLLLLLLLLLLLLLLLLLLLLLL.LLLLL\nLLLLLLLLLLLLLLLL.LLLLLLL.LLLLLLLLLLLLLLLLLLLLL.LLL.LLL.LLLLLLLLLLLLL.LL.LLLLL.LLLLLLL.LLLLL\nLLLLLL.LLLL.LLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLL.LLLLLLL.LLLLLL.LLLLL.LLLLLLLL.LLLLLLLLLLLLLL\nLLLLLLLLLLL.LLLL.LLLLLLL.LLLLLL..LLLL.LLLLLLLL.LLLLLLLLL.LLLLLLLLLL.LLLLLLLL.LLLLLLLL.LLLL.\nLLLLLL.LLLLLLLLLLLLLL.LL.L.LLLLLLLLLL.LLL.LLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLL.LLL.L\nLLLLLL.LLLLLLLLL.LLLLLLLLLLL.LLLLLLLL.LLLLL.LLLLLLLLLLLLLLLLL.LLLLL.LLLLLL.L.LLLLLLLLLLLLLL\nLLLLLL.LLLLLLLLL.LLLLLLLLLLLLLL.LLLLL.LLLLLLLLLL.LLLLL.LLLLLL.LLLLLLLLLLLLLL.LLLLLLLL.LLLLL")
        ) should be(2247)
      }
    }
  }
}
