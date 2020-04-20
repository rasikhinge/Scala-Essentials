package generics

sealed trait Sum[A, B] {
  def fold[C](leftFn: A => C, rightFn: B => C): C = this match {
    case Right(value) => rightFn(value)
    case Left(value) => leftFn(value)
  }
}

final case class Left[A, B](value: A) extends Sum[A, B]

final case class Right[A, B](value: B) extends Sum[A, B]

object Exercise2 {
  def main(args: Array[String]): Unit = {
    val sum: Sum[Int, String] = Left(1)
    val sum1: Sum[Int, String] = Right("Good Night")

    println(sum)
    println(sum1.fold(l => false, r => true))

    val result = sum1 match {
      case Left(x) => x.toString
      case Right(x) => x
    }

    println(result)

  }
}
