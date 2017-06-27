package org.pactDemo.utilities

object Heroku {

  def port(default: Int): Int = Option(System.getenv("PORT")) match {
    case Some(p) => p.toInt
    case _ => default
  }
}
