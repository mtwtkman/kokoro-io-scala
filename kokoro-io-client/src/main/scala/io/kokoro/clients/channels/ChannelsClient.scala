package io.kokoro.clients.channels

import scala.concurrent.Future
import akka.http.scaladsl.model.HttpResponse

import io.kokoro.clients.Client
import io.kokoro.entities.Channel
import io.kokoro.utils.Configurations._

trait Channels {
  protected val client: Client
  private val uri = s"$kokoroioApiUrl/$kokoroioVersion/channels"

  def get(): Future[Seq[Channel]] = {
    client.get[Seq[Channel]](uri)
  }
}
