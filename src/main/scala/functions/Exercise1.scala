package functions

sealed trait IntList {
  def length(totalLength: Int = 0): Int = {
    this match {
      case Pair(_, tail) => tail.length(1 + totalLength)
      case End() => totalLength
    }
  }

  def lengthFold(): Int = {
    foldGeneric[Int](0, (x, y) => 1 + y)
  }

  def sum(total: Int = 0): Int = {
    this match {
      case Pair(head, tail) => tail.sum(head + total)
      case End() => total
    }
  }

  def sumFold(total: Int = 0): Int = {
    foldGeneric[Int](0, (x, y) => x + y)
  }

  def product(total: Int = 1): Int = {
    this match {
      case Pair(head, tail) => tail.product(head * total)
      case End() => total
    }
  }

  def productFold(): Int = {
    foldGeneric[Int](1, (x, y) => x * y)
  }

  def double(): IntList = {
    foldGeneric(End(), (x, y) => Pair(x * 2, y))
  }

  def foldDouble(end: IntList, f: (Int, IntList) => IntList): IntList = {
    this match {
      case Pair(head, tail) => f(head, tail.foldDouble(end, f))
      case End() => end
    }
  }

  def fold(end: Int, f: (Int, Int) => Int): Int = {
    this match {
      case Pair(head, tail) => f(head, tail.fold(end, f)) //head + trail.fold( 0, (x, y) => x + y)
      case End() => end
    }
  }

  def foldGeneric[A](end: A, f: (Int, A) => A): A = {
    this match {
      case End() => end
      case Pair(head, tail) => f(head, tail.foldGeneric(end, f))
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
    println(" DOUBLE -  " + list.double())
    println(" DOUBLE FOLD -  " + list.foldDouble(End(), (x: Int, y: IntList) => Pair(2 * x, y)))


    println("FOLD GENERIC SUM - " + list.foldGeneric[Int](0, (x, y) => x + y))
    println("FOLD GENERIC PRODUCT -  " + list.foldGeneric[Int](1, (x, y) => x * y))
    println("FOLD GENERIC LENGTH -  " + list.foldGeneric[Int](0, (x, y) => 1 + y))
    println("FOLD GENERIC DOUBLE -  " + list.foldGeneric(End(), (x, y) => Pair(x * 2, y)))
  }
}
