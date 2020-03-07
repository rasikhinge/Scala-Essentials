package mapFlatmap

sealed trait Sum[A, B] {
  def mapi[C](f: B => C): Sum[A, C] = {
    this match {
      case Success(value) => Success(f(value))
      case Failure(error) => Failure(error)
    }
  }

  def flatMap[T](f: B => Sum[A, T]): Sum[A, T] = {
    this match {
      case Success(value) => f(value)
      case Failure(error) => Failure(error)
    }
  }
}

final case class Success[A, B](value: B) extends Sum[A, B]

final case class Failure[A, B](error: A) extends Sum[A, B]

object Exercise2 {
  def main(args: Array[String]): Unit = {
    val success: Sum[String, Int] = Success(3)
    val error: Sum[String, Int] = Failure("Error")

    val result1 = calculate(2)
    val result2 = calculate(-1)
    println(success)
    println(error)
    println(result1)
    println(result2)
    println(result1.mapi(x => x.toString + "Converted to String"))
    println(result2.mapi(x => x.toString + "converted to String"))

    val map = success.mapi(x => calculate(x))
    val flatMap = success.flatMap(x => calculate(x).mapi(i => i.toDouble))
    val map2 = error.mapi(x => calculate(x))
    val flatMap2 = error.flatMap(x => calculate(x))

    println(map)
    println(flatMap)
    println(map2)
    println(flatMap2)
  }

  def calculate(x: Int): Sum[String, Int] = {
    if (x > 0)
      Success(x * 2)
    else
      Failure("Number cannot be negative ")
  }
}
