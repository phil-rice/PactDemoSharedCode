package org.pactDemo.utilities

import com.twitter.finagle.http.Request
import com.twitter.finagle.{Http, Service}
import com.twitter.util.Future
import com.twitter.inject.Logging


class FinatraClient(hostAndPort: String, fn: String => String) extends Service[Int, String] with com.twitter.inject.Logging{

  val service = Http.newService(hostAndPort)

  override def apply(id: Int): Future[String] =
    service(Request(s"/id/$id")).map(res => fn(res.contentString)).respond { tryT => info(s"FinatraClient $hostAndPort with $id resulted in $tryT")
    }

}
