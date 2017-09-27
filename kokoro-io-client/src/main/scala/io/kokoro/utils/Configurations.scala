package io.kokoro.utils

import com.typesafe.config.{Config, ConfigFactory}
import scala.util.Properties

object Configurations extends ConfigurationDetector {
  val config = ConfigFactory.load

  lazy val accessToken = envVarOrConfig("KOKOROIO_ACCESS_TOKEN", "kokoroio.access_token")
  lazy val kokoroioApiUrl = "https://kokoro.io/api"
  lazy val kokoroioVersion = "v1"
}

trait ConfigurationDetector {
  val config: Config

  protected def envVarOrConfig(envVar: String, configName: String): String =
    try {
      environmentVariable(envVar) getOrElse configuration(configName)
    } catch {
      case _: Throwable =>
        val msg = s"[kokoro-io] configuration missing: Environment variable $envVar or configuration $configName not found."
        throw new RuntimeException(msg)
    }

  protected def environmentVariable(name: String): Option[String] = Properties.envOrNone(name)
  protected def configuration(path: String): String = config.getString(path)
}
