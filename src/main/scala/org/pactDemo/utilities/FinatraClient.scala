package org.pactDemo.utilities

import com.twitter.finagle.http.Request
import com.twitter.finagle.{Http, Service}
import com.twitter.util.Future


class FinatraClient(hostAndPort: String, fn: String => String) extends Service[Int, String] {

  val service = Http.newService(hostAndPort)

  override def apply(id: Int): Future[String] =
    service(Request(s"/id/$id")).map(res => fn(res.contentString))

}
