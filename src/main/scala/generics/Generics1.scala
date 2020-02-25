package generics

final case class Box[A](value: A)

object Generics1 {
  def main(args: Array[String]): Unit = {
    println(Box(2))
  }
}
