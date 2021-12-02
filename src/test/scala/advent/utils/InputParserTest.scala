package advent.utils

import org.scalatest.wordspec.AnyWordSpecLike
import org.scalatest.matchers.should.Matchers

class InputParserTest extends AnyWordSpecLike with Matchers {

  "InputParser" should {
    "parse an input of string values" in {
      InputParser.parse[String]("hello\nworld") should be(IndexedSeq("hello", "world"))
    }

    "parse an input of integer values" in {
      InputParser.parse[Int]("123\n456   \n987") should be(IndexedSeq(123, 456, 987))
    }

    "parse an input of float values" in {
      InputParser.parse[Float]("3.14159  \n2.78\n987") should be(IndexedSeq(3.14159f, 2.78f, 987.0f))
    }

    "parse an input of double values" in {
      InputParser.parse[Double]("3.14159\n2.78\n987") should be(IndexedSeq(3.14159, 2.78, 987.0))
    }

    "parse an input of long values" in {
      InputParser.parse[Long]("922337203685477580\n92233720368547756\n987   ") should be(IndexedSeq(922337203685477580L, 92233720368547756L, 987L))
    }
  }
}
