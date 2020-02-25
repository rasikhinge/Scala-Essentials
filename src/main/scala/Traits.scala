import java.util.Date

sealed trait Visitor {
  def id: String

  def createdAt: Date

  def age: Long = new Date().getTime - createdAt.getTime
}

final case class User(
                       id: String,
                       email: String,
                       createdAt: Date = new Date()
                     ) extends Visitor

final case class Anonymous(
                            id: String,
                            createdAt: Date = new Date()
                          ) extends Visitor

object Traits {

  def older(v1: Visitor, v2: Visitor) = {
    println(s"v1 - ${v1.createdAt} , v2 - ${v2.createdAt}")
    v1.createdAt.before(v2.createdAt)
  }

  def main(args: Array[String]): Unit = {
    println(older(Anonymous("1"), User("2", "abc@abc.com")))
  }
}
