sealed trait DMCalculation

final case class DMSuccess(result: Int) extends DMCalculation

final case class DMFailure(message: String) extends DMCalculation

object DMCalculator {
  def +(calculation: DMCalculation, a: Int) = {
    calculation match {
      case DMSuccess(result) => DMSuccess(result + a)
      case DMFailure(msg) => DMFailure(msg)
    }
  }

  def -(calculation: DMCalculation, a: Int) = {
    calculation match {
      case DMSuccess(result) => DMSuccess(result - a)
      case DMFailure(msg) => DMFailure(msg)
    }
  }

  def /(calculation: DMCalculation, a: Int): DMCalculation = calculation match {
    case DMSuccess(result) => a match {
      case 0 => DMFailure("Divide By Zero Error")
      case i => DMSuccess(result / i)
    }
    case DMFailure(msg) => DMFailure(msg)
  }
}

object DataModelingExercise2 {
  def main(args: Array[String]): Unit = {
    val addition = DMCalculator.+(DMSuccess(1), 1)
    assert(addition == DMSuccess(2))
    val sub = DMCalculator.-(DMSuccess(4), 3)
    assert(sub == DMSuccess(1))

    val errorAdd = DMFailure("AdditionError")
    assert(DMCalculator.+(errorAdd, 2) == DMFailure("AdditionError"))
    val errorSub = DMFailure("Subtraction Failed")
    assert(DMCalculator.-(errorSub, 3) == DMFailure("Subtraction Failed"))

    val divide = DMCalculator./(DMSuccess(4), 2)
    assert(divide == DMSuccess(2))
    val divideByZero = DMCalculator./(DMSuccess(4), 0)
    assert(divideByZero == DMFailure("Divide By Zero Error"))
    val divideError = DMFailure("Division Failed")
    assert(divideError == DMFailure("Division Failed"))
  }
}
