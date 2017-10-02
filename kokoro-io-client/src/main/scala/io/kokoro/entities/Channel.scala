package io.kokoro.entities

import io.kokoro.entities.enums.ChannelKind.ChannelKind

final case class Channel(
  id: String,
  channel_name: String,
  kind: ChannelKind,
  archived: Boolean,
  description: String
)
