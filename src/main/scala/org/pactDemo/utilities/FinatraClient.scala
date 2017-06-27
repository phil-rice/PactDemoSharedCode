package org.pactDemo.utilities

import com.twitter.finagle.http.Request
import com.twitter.finagle.{Http, Service}
import com.twitter.util.Future


class FinatraClient(host: String, defaultPort: Int, fn: String => String) extends Service[Int, String] {
  val actualPort = Heroku.port(defaultPort)
  val service = Http.newService(s"$host:$actualPort")

  override def apply(id: Int): Future[String] =
    service(Request(s"/id/$id")).map(res => fn(res.contentString))

}
