package advent.puzzles.twentyOne.day12

case class Vertex[A](value: A)
opaque type Graph[A] <: Map[A, List[A]] =
  Map[A, List[A]]

extension (graph: Graph[String]) {
  def findPaths(
      start: String,
      end: String,
      part2Modifier: Boolean = false,
      acc: List[String] = List.empty,
      visited: Set[String] = Set.empty
  ): List[List[String]] = {
    if (start == end) {
      return List(acc :+ end)
    }

    graph
      .get(start)
      .getOrElse(List.empty)
      .filterNot(neighbor => {
        if (part2Modifier && "[a-z]{1,2}".r.matches(neighbor)) {
          val smallCaveCounts = (acc :+ start)
            .filter("[a-z]{1,2}".r.matches)
            .groupBy(identity)
            .mapValues(_.size)
            .toMap
          if (smallCaveCounts.isEmpty || smallCaveCounts.map(_._2).max < 2)
            false
          else
            smallCaveCounts.getOrElse(neighbor, 0) > 0
        } else {
          visited.contains(neighbor)
        }
      })
      .map(neighbor => {
        findPaths(
          neighbor,
          end,
          part2Modifier,
          acc :+ start,
          (if ("(start|end|[a-z]{1,2})".r.matches(start)) visited + start
           else visited)
        )
      })
      .flatten
  }

  def debugPrint(): Unit = {
    graph.foreach((key, value) => {
      println(s"$key -> ${graph.get(key).get.mkString(", ")}")
    })
  }
}

object PassagePathing {
  def part1(input: IndexedSeq[String]): Int = {
    val graph = buildGraph(input)
    // graph.debugPrint()
    val paths = graph.findPaths("start", "end")
    // paths.foreach(println)
    paths.length
  }

  def part2(input: IndexedSeq[String]): Int = {
    val graph = buildGraph(input)
    val paths = graph.findPaths("start", "end", true)
    paths.length
  }

  private def buildGraph(input: IndexedSeq[String]): Graph[String] = {
    input
      .map(line => {
        val split = line.split("-")
        List(
          (split(0), split(1)),
          (split(1), split(0))
        )
      })
      .flatten
      .groupBy(_._1)
      .map((k, v) => k -> v.map(_._2).toList)
      .asInstanceOf[Graph[String]]
  }
}
