package typeclasses.jsonConverter

import java.util.Date

sealed trait Visitor {
  def id: String

  def createdAt: Date

  def age: Long = new Date().getTime - createdAt.getTime
}

final case class User(id: String, createdAt: Date = new Date(), email: String) extends Visitor

final case class Ananymous(id: String, createdAt: Date = new Date()) extends Visitor
