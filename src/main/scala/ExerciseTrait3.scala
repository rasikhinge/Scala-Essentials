

sealed trait DivideResult {
  def result: Int
}

final case class Finite(result: Int) extends DivideResult

final case class Infinite(result: Int) extends DivideResult

object divide {
  def apply(n1: Int, n2: Int): DivideResult = n2 match {
    case 0 => Infinite(0)
    case _ => Finite(n1 / n2)
  }
}

object ExerciseTrait3 {
  def main(args: Array[String]): Unit = {
    println(divide(1, 2))
    println(divide(1, 0))
  }
}
