package generics

sealed trait Result[A]

final case class Success[A](value: A) extends Result[A]

final case class Failure[A](message: String) extends Result[A]

object Generics2 {
  def main(args: Array[String]): Unit = {
    val s1 = Success(1)
    val s2 = Success[String]("Rasik")
    val f1 = Failure("message")
    val f2 = Failure[Int]("message")
    println(f1.getClass)
  }
}
