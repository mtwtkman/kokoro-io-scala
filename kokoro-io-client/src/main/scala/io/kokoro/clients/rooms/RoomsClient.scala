package io.kokoro.clients.rooms

import scala.concurrent.Future
import akka.http.scaladsl.model.HttpResponse

import io.kokoro.clients.Client
import io.kokoro.entities.Room
import io.kokoro.utils.Configurations._

trait Rooms {
  protected val client: Client
  private val uri = s"$kokoroioApiUrl/$kokoroioVersion/rooms"

  def rooms(): Future[HttpResponse] = {
    import client._
    get[Seq[Room]](uri)
  }
}
