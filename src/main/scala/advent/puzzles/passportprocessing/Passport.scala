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

  def validate(passport: Passport): Option[Passport] = {
    if ((passport.birthYear > 2002 || passport.birthYear < 1920) ||
      (passport.issueYear > 2020 || passport.issueYear < 2010) ||
      (passport.expirationYear > 2030 || passport.expirationYear < 2020) ||
      validateHeight(passport).isEmpty ||
      validateHairColor(passport).isEmpty ||
      validateEyeColor(passport).isEmpty ||
      validatePassportID(passport).isEmpty) {
      None
    } else {
      Some(passport)
    }
  }

  private def validateHeight(passport: Passport): Option[Passport] = {
    if (passport.height.matches("^1([5-8][0-9]|9[0-3])cm$") ||
      passport.height.matches("^(59|6[0-9]|7[0-6])in$")) {
      Some(passport)
    } else None
  }

  private def validateHairColor(passport: Passport): Option[Passport] = {
    if (passport.hairColor.matches("^#([0-9]|[a-f]){6}$")) {
      Some(passport)
    } else None

  }

  private def validateEyeColor(passport: Passport): Option[Passport] = {
    if (passport.eyeColor.matches("^(amb|b(lu|rn)|gr[yn]|hzl|oth)$")) {
      Some(passport)
    } else None
  }

  private def validatePassportID(passport: Passport): Option[Passport] = {
    if (passport.passportID.matches("^[0-9]{9}$")) {
      Some(passport)
    } else None
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
