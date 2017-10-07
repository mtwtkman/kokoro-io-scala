package io.kokoro.entities

import io.kokoro.entities.enums.ChannelKind.ChannelKind

sealed trait IChannel {
  def id: String
  def channel_name: String
  def kind: ChannelKind
  def archived: Boolean
  def description: String
}

final case class Channel(
  id: String,
  channel_name: String,
  kind: ChannelKind,
  archived: Boolean,
  description: String,
  membership: Membership
) extends IChannel

final case class ChannelWithoutMembership(
  id: String,
  channel_name: String,
  kind: ChannelKind,
  archived: Boolean,
  description: String
) extends IChannel
