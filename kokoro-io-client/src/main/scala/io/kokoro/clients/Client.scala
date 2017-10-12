package io.kokoro.clients

import java.util.UUID
import scala.reflect.runtime.universe.typeTag
import scala.util.Try
import scala.concurrent.{ Future, ExecutionContextExecutor }
import scala.util.{ Success, Failure }

import spray.json._
import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import HttpMethods._
import akka.http.scaladsl.model.headers.RawHeader
import akka.stream.ActorMaterializer
import akka.http.scaladsl.unmarshalling.Unmarshal

import io.kokoro.utils.KokoroIOJsonProtocol

class Client(val accessToken: String) extends KokoroIOJsonProtocol {
  private def request[T](method: HttpMethod, uri: String): Future[T] = {
    implicit val system = ActorSystem(s"kokoro-io-api-${UUID.randomUUID}")
    implicit val materializer = ActorMaterializer()
    implicit val ec = system.dispatcher

    val accessTokenHeader = RawHeader("X-Access-Token", accessToken)
    val request = HttpRequest(method = method, uri = uri).withHeaders(accessTokenHeader)
    Http().singleRequest(request) flatMap { response =>
      Unmarshal(response.entity).to[T]
    }
  }

  def get[T](uri: String): Future[T] = request[T](GET, uri)
  def post[T](uri: String): Future[T] = request[T](POST, uri)
  def put[T](uri: String): Future[T] = request[T](PUT, uri)
  def delete[T](uri: String): Future[T] = request[T](DELETE, uri)
}
