package io.kokoro.entities

import io.kokoro.entities.enums.Authority.Authority

sealed trait IMembership {
  def id: String
  def authority: Authority
  def disable_notification: Boolean
  def unread_count: Int
  def profile: Profile
}

final case class Membership (
  id: String,
  authority: Authority,
  disable_notification: Boolean,
  unread_count: Int,
  profile: Profile,
  channel: ChannelWithoutMembership
) extends IMembership

final case class MembershipWithtoutChannel(
  id: String,
  authority: Authority,
  disable_notification: Boolean,
  unread_count: Int,
  profile: Profile
) extends IMembership
