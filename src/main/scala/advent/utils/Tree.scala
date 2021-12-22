package advent.utils

sealed abstract class Tree(depth: Int) {
  def inOrder(): List[Leaf] = {
    this match {
      case l: Leaf              => List(l)
      case Node(left, right, _) => left.inOrder() ++ right.inOrder()
    }
  }
}

case class Leaf(
    elem: Option[Int] = None,
    depth: Int = 0,
    index: Int = 0
) extends Tree(depth)
case class Node(left: Tree = Leaf(), right: Tree = Leaf(), depth: Int = 0)
    extends Tree(depth)

object Tree {
  def fromLine(input: String): Tree = {
    def _fromLine(input: String, currDepth: Int = 0, currIndex: Int = 0): (Tree, String, Int) = {
      val firstMatch = "(\\[|\\d+)".r.findFirstIn(input).get
      val numCharsToFirstMatch = input.indexOf(firstMatch) + firstMatch.length
      firstMatch match {
        case "[" => {
          val left = _fromLine(input.drop(numCharsToFirstMatch), currDepth + 1, currIndex)
          val right = _fromLine(left._2, currDepth + 1, left._3)
          (Node(left._1, right._1, currDepth), right._2, right._3)
        }
        case num if num.toIntOption.isDefined =>
          (
            Leaf(
              Some(num.toInt),
              currDepth,
              currIndex
            ),
            input.drop(numCharsToFirstMatch),
            currIndex + 1
          )
        case _ => throw new Exception("impossible")
      }
    }
    _fromLine(input)._1
  }

  // def fromLeafList(list: List[Leaf]): Tree = {
  //   val pairs = list.sliding(2).toList
  //   val asString = pairs.zipWithIndex
  //     .map((leaves, i) => {
  //       val a = (if (i == 0) {
  //                  "[" * leaves(0).depth + leaves(0).elem.get + ","
  //                } else if (leaves(0).depth < leaves(1).depth) {
  //                  leaves(0).elem.get + "," + "[" * (leaves(1).depth - leaves(
  //                    0
  //                  ).depth)
  //                } else if (leaves(0).depth > leaves(1).depth) {
  //                  leaves(0).elem.get + "]" * (leaves(0).depth - leaves(
  //                    1
  //                  ).depth) + ","
  //                } else if (leaves(0).depth == leaves(1).depth) {
  //                  leaves(0).elem.get + ","
  //                } else "")
  //       val b = (if (i == pairs.length - 1) {
  //                  leaves(1).elem.get + "]" * leaves(1).depth
  //                } else "")
  //       a + b
  //     })
  //     .mkString
  //   val asString2 = list.zipWithIndex.map((leaf, i) => {
  //     leaf.stringPrefix + leaf.elem.get + (if (i == list.length - 1)
  //                                            "]" * leaf.depth
  //                                          else "")
  //   }).mkString
  //   Tree.fromLine(asString2)
  // }
}
