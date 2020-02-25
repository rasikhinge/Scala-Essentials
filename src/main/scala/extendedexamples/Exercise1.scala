package extendedexamples

sealed trait Expression {
  def eval: Result
}

final case class Addition(left: Expression, right: Expression) extends Expression {
  val eval: Result = {
    left.eval match {
      case Success(l1) => right.eval match {
        case Success(r1) => Success(l1 + r1)
        case Failure(msg) => Failure(msg)
      }
      case Failure(msg) => Failure(msg)
    }
  }
}

final case class Subtraction(left: Expression, right: Expression) extends Expression {
  val eval: Result = {
    left.eval match {
      case Success(l1) => right.eval match {
        case Success(r1) => Success(l1 - r1)
        case Failure(msg) => Failure(msg)
      }
      case Failure(msg) => Failure(msg)
    }
  }
}

final case class Division(left: Expression, right: Expression) extends Expression {
  val eval: Result = {
    right.eval match {
      case Success(r1) => r1 match {
        case 0 => Failure("Divide By Zero")
        case r2 => left.eval match {
          case Success(l1) => Success(l1 / r2)
          case Failure(msg) => Failure(msg)
        }
      }
      case Failure(msg) => Failure(msg)
    }
  }
}

final case class SquareRoot(value: Expression) extends Expression {
  val eval: Result = {
    value.eval match {
      case Success(v1) => v1 match {
        case v2 if v2 < 0 => Failure("Square root of negative number")
        case v2 => Success(math.sqrt(v2))
      }
      case Failure(msg) => Failure(msg)
    }
  }
}

final case class Number(value: Double) extends Expression {
  val eval: Result = value match {
    case v1: Double => Success(v1)
    case v2 => Failure("Not a valid Number")
  }
}

sealed trait Result

final case class Success(value: Double) extends Result

final case class Failure(message: String) extends Result


object Exercise1 {
  def main(args: Array[String]): Unit = {
    val n1 = Number(1)
    val n2 = Number(2)
    val n3 = Number(3)

    val addition = Addition(Subtraction(n1, n2), Addition(n1, n3)).eval
    println(addition)
    assert(addition == Success(3.0))
    assert(Addition(SquareRoot(Number(-4.0)), Number(2.0)).eval == Failure("Square root of negative number"))
    assert(Addition(SquareRoot(Number(4.0)), Number(2.0)).eval == Success(4.0))
    assert(Division(Number(4), Number(0)).eval == Failure("Divide By Zero"))
  }
}
