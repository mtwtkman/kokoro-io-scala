import Dependencies._

val AkkaHttp = "10.0.10"
val AkkaHttpJson4s = "10.0.10"
val Json4s = "3.5.3"
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
      "org.json4s" %% "json4s-native" % Json4s,
      "org.json4s" %% "json4s-ext" % Json4s,
      "com.typesafe.akka" %% "akka-http" % AkkaHttp,
      "de.heikoseeberger" %% "akka-http-json4s" % AkkaHttpJson4s,
      "com.typesafe.scala-logging" %% "scala-logging" % ScalaLogging,
      "ch.qos.logback" % "logback-classic" % Logback,
      "com.typesafe" % "config" % Typesafe,
      scalaTest % Test
    )
  )
