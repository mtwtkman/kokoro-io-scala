package io.kokoro.entities.enums

object Authority extends Enumeration {
  type Authority = Value

  val Administrator = Value("administrator")
  val Maintainer = Value("maintainer")
  val Member = Value("member")
  val Invited = Value("invited")
}
