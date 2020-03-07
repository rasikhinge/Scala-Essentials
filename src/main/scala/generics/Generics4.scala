package generics

final case class GPair[A, B](one: A, two: B)

object Generics4 {
  def main(args: Array[String]): Unit = {
    val pair = GPair[String, Int]("Rasik", 29)
    println(pair.one)
    println(pair.two)
    Tuple10
  }
}
