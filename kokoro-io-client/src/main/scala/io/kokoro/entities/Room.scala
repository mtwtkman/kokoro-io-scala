package io.kokoro.entities

import io.kokoro.entities.enums.RoomKind.RoomKind

final case class Room(
  id: String,
  channel_name: String,
  kind: RoomKind,
  archived: Boolean,
  description: String,
  membership: Membership
)
