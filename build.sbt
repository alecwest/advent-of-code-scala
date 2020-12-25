name := "advent-of-code-2020"

version := "0.1"

scalaVersion := "2.13.4"

idePackagePrefix := Some("com.alecnwest")

val AkkaVersion = "2.6.8"
val AkkaHttpVersion = "10.2.2"

// Build dependencies
libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion,
  "com.typesafe.akka" %% "akka-stream" % AkkaVersion,
  "com.typesafe.akka" %% "akka-http" % AkkaHttpVersion,
  "com.typesafe.akka" %% "akka-http-spray-json" % AkkaHttpVersion,
  "org.scala-lang.modules" %% "scala-parser-combinators" % "1.1.2",
  "io.monix" %% "monix" % "3.3.0"
)

// Test dependencies
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8" % Test
