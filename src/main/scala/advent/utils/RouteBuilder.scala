package com.alecnwest
package advent.utils

import akka.http.scaladsl.server.Route

trait RouteBuilder {
  def buildRoute(): Route
}
