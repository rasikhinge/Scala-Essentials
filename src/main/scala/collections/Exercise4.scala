package collections

object Exercise4 {
  def main(args: Array[String]): Unit = {
    val addition = addOptions(Some(1), Some(2))
    val addition2 = addOptions(Some(1), Some(2), Some(3))
    println(addition2)
    val division = divide(1, 2)
    println(division)
    val division2 = divide(2, 0)
    println(division2)
    println("===================================================")
    val result = calculator("4", "+", "5")
    val result2 = calculator("4", "-", "5")
    println(result)
    println(result2)
    val result3 = calculator("4a", "-", "5")
  }


  def addOptions1(a: Option[Int], b: Option[Int]): Option[Int] = {
    for {
      num1 <- a
      num2 <- b
    } yield num1 + num2
  }

  def addOptions(a: Option[Int], b: Option[Int]): Option[Int] = {
    a.flatMap(num1 => b.map(num2 => num1 + num2))
  }

  /*def addOptions(a: Option[Int], b: Option[Int], c: Option[Int]): Option[Int] = {
    for {
      num1 <- a
      num2 <- b
      num3 <- c
    } yield num1 + num2 + num3
  }*/
  def addOptions(a: Option[Int], b: Option[Int], c: Option[Int]): Option[Int] = {
    a.flatMap(num1 => b.flatMap(num2 => c.map(num3 => num1 + num2 + num3)))
  }

  def divide(a: Int, b: Int): Option[Int] = {
    if (b == 0) None else Some(a / b)
  }

  def divideFor(a: Option[Int], b: Option[Int]): Option[Int] = {
    for {
      n1 <- a
      n2 <- b
      n3 <- divide(n1, n2)
    } yield n3
  }


  def calculator(operand1: String, operation: String, operand2: String): Option[Int] = {
    require(operand1.matches("-?\\d+"), "Operand should be proper Integer")
    require(operand2.matches("-?\\d+"), "Operand should be proper Integer")

    /*val op1 = operand1.toInt
    val op2 = operand2.toInt

    operation match {
      case "+" => Some(op1 + op2)
      case "-" => Some(op1 - op2)
      case "*" => Some(op1 * op2)
      case "/" => if (op2 == 0) None else Some(op1 / op2)
      case _ => None*/

    for {
      op1 <- toInt(operand1)
      op2 <- toInt(operand2)
      ans <- operation match {
        case "+" => Some(op1 + op2)
        case _ => None
      }
    } yield ans
  }

  def toInt(str: String): Option[Int] = {
    if (str.matches("-?\\d+")) Some(str.toInt) else None
  }

}
