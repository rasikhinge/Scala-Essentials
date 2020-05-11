package functional.programming

object Fibonacci {
  /*  def calculate(n: Int): Int = {
      if (n == 0)
        0
      else if (n == 1)
        1
      else {
        calculate(n - 1) + calculate(n - 2)
      }
    }*/

  def calculate(n: Int): Int = {
    if (n == 0 || n == 1)
      n
    else {
      calculate(n - 1) + calculate(n - 2)
    }
  }

  def calculateTailRecursive(n: Int, prev: Int, curr: Int): Int = {
    if (n == 0)
      curr
    else calculateTailRecursive(n = (n - 1), prev = prev + curr, curr = prev)
  }
}

object RecursionFibo {
  def main(args: Array[String]): Unit = {
    val answer = Fibonacci.calculate(5)
    val answer2 = Fibonacci.calculateTailRecursive(5, 1, 0)
    println(answer)
    println(answer2)



    //0 1 1 2 3 5
  }
}
