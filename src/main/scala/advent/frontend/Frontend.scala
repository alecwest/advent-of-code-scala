package com.alecnwest
package advent.frontend

import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.server.{Directives, Route}
import com.alecnwest.advent.puzzles.passwordphilosophy.{PasswordPhilosophyFrontend, JsonSupport}
import com.alecnwest.advent.puzzles.passportprocessing.PassportProcessingFrontend
import com.alecnwest.advent.utils.RouteBuilder


class Frontend extends Directives with JsonSupport with RouteBuilder {
  implicit val system = ActorSystem(Behaviors.empty, "advent-system")
  implicit val executionContext = system.executionContext

  def buildRoute(): Route = {
    pathPrefix("puzzles") {
      concat(
        pathPrefix("passwordphilosophy") {
          PasswordPhilosophyFrontend.buildRoute()
        },
        pathPrefix("passportprocessing") {
          PassportProcessingFrontend.buildRoute()
        }
      )
    }
  }
}
