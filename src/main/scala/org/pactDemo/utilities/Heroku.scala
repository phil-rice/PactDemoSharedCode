package org.pactDemo.utilities

object Heroku {

  def port(default: Int): Int = Option(System.getenv("PORT")) match {
    case Some(p) => p.toInt
    case _ => default
  }

  def provider = Option(System.getenv("PORT")) match {
    case Some(p) => "pact-demo-provider.herokuapp.com:80"// we are in the heroku world
    case _ => "localhost:9000"
  }
}
