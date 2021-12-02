name := "advent-of-code-2020"

version := "0.1"

scalaVersion := "3.1.0"

// Build dependencies
libraryDependencies ++= Seq(
  "org.scala-lang.modules" %% "scala-parser-combinators" % "2.1.0",
  "io.monix" %% "monix" % "3.4.0"
)

// Test dependencies
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.10" % Test
