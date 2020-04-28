package typeclasses

import typeclasses.implicits.NameAndEmailImplicit._

trait Equal[A] {
  def equal(val1: A, val2: A): Boolean
}

object Equal {
  def apply[A](implicit equal: Equal[A]): Equal[A] = {
    equal
  }
}

object Eq {
  def apply[A](v1: A, v2: A)(implicit equal: Equal[A]): Boolean = {
    equal.equal(v1, v2)
  }
}

case class Person(name: String, email: String)

object Exercise3 {
  def main(args: Array[String]): Unit = {
    println(Eq(Person("ABC", "abc@gmail.com"), Person("ABC", "abc@gmail.com")))
    println(Eq(Person("ABC", "abc1@gmail.com"), Person("ABC", "abc@gmail.com")))

    Equal[Person].equal(Person("XYZ", "xyz@gmail.com"), Person("XYZ", "xyz@gmail.com"))
  }
}
