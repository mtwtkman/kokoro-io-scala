package io.kokoro.entities.enums

object ProfileType {
  sealed trait ProfileType
  case object User extends ProfileType
  case object Bot extends ProfileType
}
