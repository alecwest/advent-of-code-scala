package com.alecnwest
package advent.frontend

import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import com.alecnwest.advent.puzzles.passwordphilosophy.Frontend


class Frontend {
  implicit val system = ActorSystem(Behaviors.empty, "advent-system")
  implicit val executionContext = system.executionContext

  def build() = {
    val route: Route =
      pathPrefix("puzzles") {
        pathPrefix("passwordphilosophy") {
          Frontend.build()
        }
      }
  }
}
