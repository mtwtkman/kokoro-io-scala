package io.kokoro.entities.enums

object Authority {
  sealed abstract class Authority
  case object Administrator extends Authority
  case object Maintainer extends Authority
  case object Member extends Authority
  case object Invited extends Authority
}
