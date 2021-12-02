package advent.utils

import scala.reflect.ClassTag

/**
 * Convert string input to a supported type
 * https://stackoverflow.com/a/49739642/8726276
 */
object InputParser {
  /**
   * Read simple input that should be split by newline only
   * i.e.
   * line1
   * line2
   * line3
   * etc...
   */
  def parse[A:ClassTag](input: String)(implicit converter: Converter[A]): IndexedSeq[A] = {
    mapToSeq[A](input.split("\\s*\\n"))
  }

  /**
   * Read input that should be split by all spaces or newlines
   * i.e.
   * val1 val2 val3
   * val4 val5 val6 val7 etc...
   */
  def parseLine[A:ClassTag](input: String)(implicit converter: Converter[A]): IndexedSeq[A] = {
    mapToSeq[A](input.split("(\\s+|\\s*\\n)"))
  }

  /**
   * Read input that can span multiple lines and consist of multiple entries per "input"
   *
   * Each "input" is divided by 2+ newlines
   * i.e.
   * val1 val2
   * val3 val4
   * 
   * val5 val6
   * val7 val8
   * 
   * etc...
   */
  def parseMultiLine[A:ClassTag](input: String)(implicit converter: Converter[A]): IndexedSeq[A] = {
    mapToSeq[A](input.split("\\s*\\n{2,}"))
  }

  private def mapToSeq[A:ClassTag](input: Iterable[String])(implicit converter: Converter[A]): IndexedSeq[A] = {
    input.map[A](element => converter.convert(element.trim)).toIndexedSeq
  }

  trait Converter[A] {
    def convert(target: String): A
  }

  object Converter {
    implicit val longLoader: Converter[Long] = (target: String) => target.toLong

    implicit val stringLoader: Converter[String] = (target: String) => target

    implicit val stringArrayLoader: Converter[IndexedSeq[String]] = (target: String) => target.split("(\\s|\\n)+")

    implicit val intLoader: Converter[Int] = (target: String) => target.toInt

    implicit val floatLoader: Converter[Float] = (target: String) => target.toFloat

    implicit val doubleLoader: Converter[Double] = (target: String) => target.toDouble
  }
}
