package com.alecnwest
package advent.utils

import scala.reflect.ClassTag

/**
 * Convert string input to a supported type
 * https://stackoverflow.com/a/49739642/8726276
 */
object InputParser {
  def parse[A:ClassTag](input: String)(implicit converter: Converter[A]): IndexedSeq[A] = {
    input.split("\\s*\\n").map[A](element => converter.convert(element.trim)).toIndexedSeq
  }

  trait Converter[A] {
    def convert(target: String): A
  }

  object Converter {
    implicit val longLoader: Converter[Long] = (target: String) => target.toLong

    implicit val stringLoader: Converter[String] = (target: String) => target

    implicit val intLoader: Converter[Int] = (target: String) => target.toInt

    implicit val floatLoader: Converter[Float] = (target: String) => target.toFloat

    implicit val doubleLoader: Converter[Double] = (target: String) => target.toDouble
  }
}
