package io.kokoro.entities

import io.kokoro.entities.enums.Authority.Authority

final case class Membership(
  id: String,
  room: Room,
  authority: Authority,
  disable_notification: Boolean,
  unread_count: Int,
  profile: Profile
)
