ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.6"

lazy val root = (project in file("."))
  .settings(
    name := "Weather",
    libraryDependencies ++= Seq(
      // STTP Client v3 and v4
      "com.softwaremill.sttp.client3" %% "core" % "3.3.18",
      "com.softwaremill.sttp.client4" %% "core" % "4.0.9",

      // Circe for JSON parsing
      "io.circe" %% "circe-core" % "0.14.1",
      "io.circe" %% "circe-generic" % "0.14.1",
      "io.circe" %% "circe-parser" % "0.14.1"
    )
  )
