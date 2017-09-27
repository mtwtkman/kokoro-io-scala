package io.kokoro.entities.enums

object ProfileType extends Enumeration {
  type ProfileType = Value

  val User = Value("user")
  val Bot = Value("bot")
}
