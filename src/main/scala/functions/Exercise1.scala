package functions

sealed trait IntList {
  def length(totalLength: Int = 0): Int = {
    this match {
      case Pair(_, tail) => tail.length(1 + totalLength)
      case End() => totalLength
    }
  }

  def lengthFold(): Int = {
    fold(0, (x, y) => 1 + y)
  }

  def sum(total: Int = 0): Int = {
    this match {
      case Pair(head, tail) => tail.sum(head + total)
      case End() => total
    }
  }

  def sumFold(total: Int = 0): Int = {
    fold(0, (x, y) => x + y)
  }

  def product(total: Int = 1): Int = {
    this match {
      case Pair(head, tail) => tail.product(head * total)
      case End() => total
    }
  }

  def productFold(): Int = {
    fold(1, (x, y) => x * y)
  }

  def fold(end: Int, f: (Int, Int) => Int): Int = {
    this match {
      case Pair(head, tail) => f(head, tail.fold(end, f)) // head + trail.fold( 0, (x, y) => x + y)
      case End() => end
    }
  }
}

final case class Pair(head: Int, tail: IntList) extends IntList

final case class End() extends IntList


object Exercise1 {
  def main(args: Array[String]): Unit = {
    val list = Pair(1, Pair(2, Pair(3, End())))
    println(list.length())
    println(list.sum())
    println(list.product())
    println(" SUM - " + list.fold(0, (x, y) => x + y))
    println(" PRODUCT -  " + list.fold(1, (x, y) => x * y))
    println(" LENGTH -  " + list.fold(0, (x, y) => 1 + y))

    println(" SUM - " + list.sumFold())
    println(" PRODUCT -  " + list.productFold())
    println(" LENGTH -  " + list.lengthFold())
  }
}
