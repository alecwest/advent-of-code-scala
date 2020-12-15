name := "advent-of-code-2020"

version := "0.1"

scalaVersion := "2.13.4"

idePackagePrefix := Some("com.alecnwest")


// Build dependencies
libraryDependencies += "org.scala-lang.modules" %% "scala-parser-combinators" % "1.1.2"
libraryDependencies += "io.monix" %% "monix" % "3.3.0"

// Test dependencies
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8" % Test
