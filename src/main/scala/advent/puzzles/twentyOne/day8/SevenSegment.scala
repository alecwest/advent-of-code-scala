package advent.puzzles.twentyOne.day8

case class Entry(signal: IndexedSeq[String], output: IndexedSeq[String])

object SevenSegment {
  def part1(input: IndexedSeq[String]): Int = {
    val entries = buildEntries(input)

    entries.foldLeft(0)((current, next) => {
      current + next.output.count(s =>
        s.length == 2 || s.length == 3 || s.length == 4 || s.length == 7
      )
    })
  }

  def part2(input: IndexedSeq[String]): Int = {
    val entries = buildEntries(input)

    entries.foldLeft(0)((current, next) => {
      val knowns = Array.fill(10)("")

      var unknowns = next.signal.toArray.clone
      val one = unknowns.find(p => p.length == 2)
      knowns(1) = one.get
      unknowns = unknowns.filterNot(_ == knowns(1))
      val four = unknowns.find(p => p.length == 4)
      knowns(4) = four.get
      unknowns = unknowns.filterNot(_ == knowns(4))
      val seven = unknowns.find(p => p.length == 3)
      knowns(7) = seven.get
      unknowns = unknowns.filterNot(_ == knowns(7))
      val eight = unknowns.find(p => p.length == 7)
      knowns(8) = eight.get
      unknowns = unknowns.filterNot(_ == knowns(8))
      
      val three = unknowns.find(p => p.replaceAll(s"[${knowns(7)}]", "").length == 2)
      knowns(3) = three.get
      unknowns = unknowns.filterNot(_ == knowns(3))

      val twoOrFive = unknowns.filter(p => p.length == 5)
      val two = twoOrFive.find(p => p.replaceAll(s"[${knowns(4)}]", "").length == 3)
      knowns(2) = two.get
      unknowns = unknowns.filterNot(_ == knowns(2))
      val five = twoOrFive.find(_ != knowns(2))
      knowns(5) = five.get
      unknowns = unknowns.filterNot(_ == knowns(5))

      val zero = unknowns.find(p => p.replaceAll(s"[${knowns(5)}]", "").length == 2)
      knowns(0) = zero.get
      unknowns = unknowns.filterNot(_ == knowns(0))
      val six = unknowns.find(p => p.replaceAll(s"[${knowns(4)}]", "").length == 3)
      knowns(6) = six.get
      unknowns = unknowns.filterNot(_ == knowns(6))

      knowns(9) = unknowns(0)

      current + next.output.map(knowns.indexOf(_)).mkString.toInt
    })
  }

  private def buildEntries(input: IndexedSeq[String]): IndexedSeq[Entry] = {
    input.map(i => {
      val entry = i.split(" | ")
      Entry(
        entry.take(10).map(_.split("").sorted.mkString),
        entry.drop(11).map(_.split("").sorted.mkString)
      )
    })
  }
}
