package io.kokoro.entities.enums

object ChannelKind {
  sealed trait ChannelKind
  case object PublicChannel extends ChannelKind
  case object PrivateChannel extends ChannelKind
  case object DirectMessage extends ChannelKind
}
