package io.kokoro.entities.enums

object RoomKind extends Enumeration {
  type RoomKind = Value

  val PublicChannel = Value("public_channel")
  val PrivateChannel = Value("private_channel")
  val DirectMessage = Value("direct_message")
}
