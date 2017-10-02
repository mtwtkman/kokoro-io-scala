package io.kokoro.entities

import io.kokoro.entities.enums.ProfileType.ProfileType

final case class Profile(
  id: String,
  `type`: ProfileType,
  screen_name: String,
  display_name: String,
  avatar: String,
  archived: Boolean,
  invited_channels_count: Int
)
