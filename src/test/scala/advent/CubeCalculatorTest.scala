package advent

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class CubeCalculatorTest extends AnyWordSpec with Matchers {

  "CubeCalculatorTest" should {
    "cube" in {
      CubeCalculator.cube(3) should be(27)
    }
  }
}
