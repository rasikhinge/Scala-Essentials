package typeclasses

final case class Rational(numerator: Int, denominator: Int)

object Rational {

  implicit val rationalOrdering = Ordering.fromLessThan[Rational]((x, y) => {
    (x.numerator.toDouble / x.denominator.toDouble) < (y.numerator.toDouble / y.denominator.toDouble)
  })

}
object Exercise1 {
  def main(args: Array[String]): Unit = {
    implicit val absOrdering = Ordering.fromLessThan[Int]((val1, val2) => math.abs(val1) < math.abs(val2))
    assert(List(-4, -1, 0, 2, 3).sorted == List(0, -1, 2, 3, -4))
    assert(List(-4, -3, -2, -1).sorted == List(-1, -2, -3, -4))

    assert(List(Rational(1, 2), Rational(1, 3), Rational(3, 4)).sorted ==
      List(Rational(1, 3), Rational(1, 2), Rational(3, 4)))

  }
}
