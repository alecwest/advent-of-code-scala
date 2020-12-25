package com.alecnwest
package advent.puzzles.passwordphilosophy

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.server.{Directives, Route}
import spray.json.{DefaultJsonProtocol, RootJsonFormat}

final case class IsValidPassword(policy: String, input: String)

trait JsonSupport extends SprayJsonSupport with DefaultJsonProtocol {
  implicit val isValidPasswordFormat: RootJsonFormat[IsValidPassword] = jsonFormat2(IsValidPassword)
}

object Frontend extends Directives with JsonSupport {
  def build(): Route = {
    path("isValidPassword") {
      post {
        decodeRequest {
          entity(as[IsValidPassword]) { input =>
            complete {
              "output" -> PasswordPhilosophy.isValidPassword(input.input, input.policy)
            }
          }
        }
      }
    }
  }
}
