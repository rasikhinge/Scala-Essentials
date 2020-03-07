package mapFlatmap

trait Maybe[A] {
  def map[B](f: A => B): Maybe[B] = {
    this match {
      case Full(value) => Full(f(value))
      case Empty() => Empty[B]()
    }
    flatMap(v => Full(f(v)))
  }

  def flatMap[B](f: A => Maybe[B]): Maybe[B] = {
    this match {
      case Full(value) => f(value)
      case Empty() => Empty[B]()
    }
  }
}

final case class Full[A](value: A) extends Maybe[A]

final case class Empty[A]() extends Maybe[A]

object MaybeMap {
  def main(args: Array[String]): Unit = {
    val maybe: Maybe[Int] = Full(1)
    val empty: Maybe[Int] = Empty()

    println(maybe)
    println(empty)
    val double = maybe.map(x => x * 2)
    val emptyMap = empty.map(x => x * 2)
    val maybeMaybeMap = maybe.map(x => Full(x))
    val maybeFlatMap = maybe.flatMap(x => Full(x))
    println(double)
    println(emptyMap)
    println(maybeMaybeMap)
    println(maybeFlatMap)
  }
}
