package io.kokoro

import io.kokoro.clients.Client
import io.kokoro.clients.channels.Channels
import io.kokoro.utils.Configurations

class KokoroIOClient(val accessToken: String) extends Clients {
  protected val client = new Client(accessToken)
}

trait Clients
  extends Channels

object KokoroIOClient {
  def apply(): KokoroIOClient = apply(Configurations.accessToken)
  def apply(accessToken: String): KokoroIOClient = new KokoroIOClient(accessToken)
}
