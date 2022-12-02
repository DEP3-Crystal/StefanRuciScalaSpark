ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.12.17"

lazy val root = (project in file("."))
  .settings(
    name := "scalaProjects"
  )
libraryDependencies+="org.scala-lang.modules"%%"scala-xml"%"2.1.0"
libraryDependencies += "org.scala-lang.modules" %% "scala-parser-combinators" % "2.1.1"
