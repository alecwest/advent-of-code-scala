package advent.utils

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

val line1 = "[1,2]"
val list1 = List(Leaf(Some(1), 1, 0), Leaf(Some(2), 1, 1))
val tree1 = Node(Leaf(Some(1), 1, 0), Leaf(Some(2), 1, 1), 0)
val line2 = "[[1,2], 3]"
val list2 =
  List(Leaf(Some(1), 2, 0), Leaf(Some(2), 2, 1), Leaf(Some(3), 1, 2))
val tree2 = Node(
  Node(
    Leaf(Some(1), 2, 0),
    Leaf(Some(2), 2, 1),
    1
  ),
  Leaf(Some(3), 1, 2),
  0
)
val line3 = "[[[[[4,3],4],4],[7,[[8,4],9]]],[1,1]]"
val list3 = List(
  Leaf(Some(4), 5, 0),
  Leaf(Some(3), 5, 1),
  Leaf(Some(4), 4, 2),
  Leaf(Some(4), 3, 3),
  Leaf(Some(7), 3, 4),
  Leaf(Some(8), 5, 5),
  Leaf(Some(4), 5, 6),
  Leaf(Some(9), 4, 7),
  Leaf(Some(1), 2, 8),
  Leaf(Some(1), 2, 9)
)
val tree3 = Node(
  Node(
    Node(
      Node(
        Node(
          Leaf(Some(4), 5, 0),
          Leaf(Some(3), 5, 1),
          4
        ),
        Leaf(Some(4), 4, 2),
        3
      ),
      Leaf(Some(4), 3, 3),
      2
    ),
    Node(
      Leaf(Some(7), 3, 4),
      Node(
        Node(
          Leaf(Some(8), 5, 5),
          Leaf(Some(4), 5, 6),
          4
        ),
        Leaf(Some(9), 4, 7),
        3
      ),
      2
    ),
    1
  ),
  Node(
    Leaf(Some(1), 2, 8),
    Leaf(Some(1), 2, 9),
    1
  ),
  0
)

class TreeTest extends AnyWordSpec with Matchers {
  "Tree" when {
    "inOrder" when {
      "small input" in {
        Tree.fromLine(line1).inOrder() should be(list1)
      }
      "large input" in {
        Tree
          .fromLine(line3)
          .inOrder() should be(list3)
      }
    }

    // "fromLeafList" when {
    //   "small input" in {
    //     Tree.fromLeafList(list1) should be(tree1)
    //   }
    //   "small nested input" in {
    //     Tree.fromLeafList(list2) should be(tree2)
    //   }
    //   "large input" in {
    //     Tree.fromLeafList(list3) should be(tree3)
    //   }
    // }

    "fromLine" when {
      "small input" in {
        Tree.fromLine(line1) should be(tree1)
      }
      "small nested input" in {
        Tree.fromLine(line2) should be(tree2)
      }
      "large input" in {
        Tree.fromLine(line3) should be(tree3)
      }
    }
  }
}
