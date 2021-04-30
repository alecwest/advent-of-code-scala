package com.alecnwest
package advent.puzzles.passportprocessing

import scala.util.control.NonFatal

sealed case class Passport(birthYear: Int,
                           issueYear: Int,
                           expirationYear: Int,
                           height: String,
                           hairColor: String,
                           eyeColor: String,
                           passportID: String,
                           countryID: Option[String])

object Passport {
  def fromStringArray(s: IndexedSeq[String]): Option[Passport] = {
    val attributes = s
      .view
      .map(attr => {
        val keyVal = attr.split(":")
        keyVal(0) -> keyVal(1)
      })
      .toMap
    Passport.unapply(attributes)
  }

  private def unapply(values: Map[String, String]): Option[Passport] =
    try {
      Some(
        Passport(
          values("byr").toInt,
          values("iyr").toInt,
          values("eyr").toInt,
          values("hgt"),
          values("hcl"),
          values("ecl"),
          values("pid"),
          values.get("cid")
        ))
    } catch {
      case NonFatal(ex) => None
    }
}
