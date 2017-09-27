package io.kokoro.marshallings

import org.json4s.{ DefaultFormats, Formats, native }
import de.heikoseeberger.akkahttpjson4s.Json4sSupport

trait JsonSupport extends Json4sSupport {
  implicit val serialization = native.serialization

  implicit lazy val json4sFormats: Formtas =
    CustomSerializers.all ++ EnumSerializers.all ++ StreamingMessageSerializers.all
}
