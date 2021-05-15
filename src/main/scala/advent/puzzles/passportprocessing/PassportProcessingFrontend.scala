package com.alecnwest
package advent.puzzles.passportprocessing

import advent.utils.{InputParser, RouteBuilder}

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.server.{Directives, Route}
import spray.json.{DefaultJsonProtocol, RootJsonFormat}

final case class IsValidPassport(passport: String)

trait JsonSupport extends SprayJsonSupport with DefaultJsonProtocol {
  implicit val isValidPassportFormat: RootJsonFormat[IsValidPassport] =
    jsonFormat1(IsValidPassport)
}

object PassportProcessingFrontend
    extends Directives
    with JsonSupport
    with RouteBuilder {
  def buildRoute(): Route = {
    concat(
      path("isValidPassport") {
        post {
          decodeRequest {
            entity(as[IsValidPassport]) { input =>
              complete {
                "output" -> PassportProcessing.isValidPassport(
                  InputParser.parse[String](input.passport))
              }
            }
          }
        }
      },
      path("countValidPassports") {
        post {
          decodeRequest {
            entity(as[IsValidPassport]) { input =>
              complete {
                "output" -> PassportProcessing.countValidPassports(
                  InputParser.parse[IndexedSeq[String]](input.passport))
              }
            }
          }
        }
      }
    )
  }
}
