package advent.puzzles.adapterarray
import scala.collection.mutable

object AdapterArray {
  def numberPossibleArrangements(input: IndexedSeq[Int]): Long = {
    val sorted = 0 +: input.sorted :+ input.max + 3
    val sequenceCache = mutable.Map(0 -> 0, 1 -> 1, 2 -> 1, 3 -> 2, 4 -> 4, 5 -> 7, 6 -> 13)
    var contiguousSingleAdapterCounter = Array(1)
    // count contiguous single difference adapters
    // add this to an array of values that get multiplied at the end
    for((adapterRating, index) <- sorted.zipWithIndex) {
      if (index != 0) {
        adapterRating - sorted(index - 1) match {
          case 1 =>
            contiguousSingleAdapterCounter = contiguousSingleAdapterCounter.slice(
              0, contiguousSingleAdapterCounter.length - 1).concat(
                Array(contiguousSingleAdapterCounter.last + 1))
          case 2 => throw new Exception("uhhh?")
          case 3 =>
            contiguousSingleAdapterCounter = contiguousSingleAdapterCounter.concat(Array(1))
        }
      }
    }

    val uhh = contiguousSingleAdapterCounter.filter(_ > 2).map(count => {
      if (!sequenceCache.contains(count)) {
        val result = sequenceCache(count - 3) + sequenceCache(count - 2) + sequenceCache(count - 1)
        sequenceCache(count) = result
      }
      sequenceCache(count).toLong
    })
    uhh.product
  }

  def product1And3Differences(input: IndexedSeq[Int]): Int = {
    val diffs = countDifferences(input)
    diffs._1 * diffs._3
  }

  private def countDifferences(input: IndexedSeq[Int]): (Int, Int, Int) = {
    var (a, b, c) = (0, 0, 0)
    val sorted = input.sorted
    for ((adapterRating, index) <- sorted.zipWithIndex) {
      adapterRating - (if (index == 0) 0 else sorted(index - 1)) match {
        case 1 => a += 1
        case 2 => b += 1
        case 3 => c += 1
      }
    }
    (a, b, c+1)
  }
}
