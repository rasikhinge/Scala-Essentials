package patternmatching

import scala.Option

case class Person(name: String, age: Int)

object Person {
  def unapply(p:Person): Option[String] = {
    Some(p.name)
  }
}

object Extractors {
  def main(args: Array[String]): Unit = {
    /*val p = Person("name", 1)
    p match {
      case Person(p,n) => println(p)
    }*/
  }
}
