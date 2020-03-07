package generics

sealed trait Maybe[A] {
  def fold[B](default: B, fn: A => B): B = {
    this match {
      case Empty() => default
      case Full(value) => fn(value)
    }
  }
}

final case class Full[A](value: A) extends Maybe[A]

final case class Empty[A]() extends Maybe[A]

object Exercise3 {
  def main(args: Array[String]): Unit = {
    val maybe1: Maybe[Int] = Full[Int](1)
    val maybe2: Maybe[Int] = Empty[Int]()

    println(maybe1)
    println(maybe2)
    println(maybe1.fold("No Value", x => s"has value $x"))
    println(maybe2.fold("No Value", x => s"has value $x"))
  }
}
