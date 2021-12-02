package advent.puzzles.twentyOne

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers
import advent.puzzles.twentyOne.depthmeasurement.DepthMeasurement
import advent.utils.InputParser
import scala.io.Source

class DepthMeasurementTests extends AnyWordSpec with Matchers {
  "DepthMeasurementTests" when {
    "measure" should {
      "return the number of increases in a series of measurements" in {
        DepthMeasurement.measure(
          InputParser.parse[Int]("199\n200\n208\n210\n200\n207\n240\n269\n260\n263")
        ) should be(7)
      }
     
      "return the number of increases in a series of measurements with larger input" in {
        DepthMeasurement.measure(
          InputParser.parse[Int](Source.fromResource("twentyOne/DepthMeasurement.txt").mkString)
        ) should be(1521)
      }
    }
  }
}
