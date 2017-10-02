package io.kokoro.utils

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import spray.json._

import io.kokoro.entities._
import enums._

trait JsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
  implicit object AuthorityFormat extends RootJsonFormat[Authority.Authority] {
    def read(json: JsValue): Authority.Authority = json match {
      case JsString("administrator") => Authority.Administrator
      case JsString("maintainer") => Authority.Maintainer
      case JsString("member") => Authority.Member
      case JsString("invited") => Authority.Invited
      case x => deserializationError(s"Expected `administrator`, `maintainer`, `member`, `invited`. But got $x")
    }

    def wraite(obj: Authority.Authority): JsValue = obj match {
      case Authority.Administrator => JsString("administrator")
      case Authority.Maintainer => JsString("maintainer")
      case Authority.Member => JsString("member")
      case Authority.Invited => JsString("invited")
    }
  }

  implicit object ChannelKindFormat extends RootJsonFormat[ChannelKind.ChannelKind] {
    def read(json: JsValue): ChannelKind.ChannelKind = json match {
      case JsString("public_channel") => ChannelKind.PublicChannel
      case JsString("private_channel") => ChannelKind.PrivateChannel
      case JsString("direct_message") => ChannelKind.DirectMessage
      case x => deserializationError(s"Expected `public_channel`, `private_channel`, `direct_message`. But got $x")
    }

    def write(obj: ChannelKind.ChannelKind): JsValue = obj match {
      case ChannelKind.PublicChannel => JsString("public_channel")
      case ChannelKind.PrivateChannel => JsString("private_channel")
      case ChannelKind.DirectMessage => JsString("direct_message")
    }
  }

  implicit object ProfileTypeFormat extends RootJsonFormat[ProfileType.ProfileType] {
    def read(json: JsValue): ProfileType.ProfileType = json match {
      case JsString("user") => ProfileType.User
      case JsString("bot") => ProfileType.Bot
      case x => deserializationError(s"Expected `user`, `bot`. But got $x")
    }

    def write(obj: ProfileType.ProfileType): JsValue = obj match {
      case ProfileType.User => JsString("user")
      case ProfileType.Bot => JsString("bot")
    }
  }

  implicit val channelProtocol = jsonFormat5(Channel)
  implicit val profileProtocol = jsonFormat7(Profile)
  implicit val membershipProtocol = jsonFormat6(Membership)
}
