import Dependencies._

val AkkaHttp = "10.0.10"
val ScalaLogging = "3.7.2"
val Typesafe = "1.3.1"
val Logback = "1.2.3"

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "io.kokoro",
      scalaVersion := "2.12.1",
      version      := "0.0.1-SNAPSHOT"
    )),
    name := "KokoroIOClient",
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-http" % AkkaHttp,
      "com.typesafe.akka" %% "akka-http-spray-json" % AkkaHttp,
      "com.typesafe.scala-logging" %% "scala-logging" % ScalaLogging,
      "ch.qos.logback" % "logback-classic" % Logback,
      "com.typesafe" % "config" % Typesafe,
      scalaTest % Test
    )
  )
