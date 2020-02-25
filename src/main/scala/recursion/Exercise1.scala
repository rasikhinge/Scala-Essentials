package recursion

sealed trait REIntList {
  def length(): Int = {
    this match {
      case REPair(_, tail) => 1 + tail.length()
      case REEnd => 0
    }
  }

  def tailLength(totalLength: Int = 0): Int = {
    this match {
      case REPair(_, tail) => tail.tailLength(1 + totalLength)
      case REEnd => totalLength
    }
  }

  def product(total: Int = 1): Int = {
    this match {
      case REPair(head, tail) => tail.product(total * head)
      case REEnd => total
    }
  }

  def double(): REIntList = {
    this match {
      case REPair(head, tail) => REPair(2 * head, tail.double())
      case REEnd => REEnd
    }
  }
}

case object REEnd extends REIntList

final case class REPair(head: Int, tail: REIntList) extends REIntList

object Exercise1 {
  def length(list: REIntList): Int = {
    list match {
      case REPair(_, tail) => 1 + length(tail)
      case REEnd => 0
    }
  }

  def tailLength(list: REIntList, listLength: Int = 0): Int = {
    list match {
      case REPair(_, tail) => tailLength(tail, 1 + listLength)
      case REEnd => listLength
    }
  }

  def main(args: Array[String]): Unit = {
    val list = REPair(1, REPair(2, REPair(3, REEnd)))

    println("=============Recursion External Object Method=====================")
    assert(length(list) == 3)
    assert(length(list.tail) == 2)
    println("=============Recursion External Object Method Tail Recursive=====================")
    assert(tailLength(list) == 3)
    assert(tailLength(list.tail) == 2)
    println("=============Recursion Base trait method=====================")
    assert(list.length() == 3)
    assert(list.tail.length() == 2)
    println("=============Recursion Base trait method tail recursive=====================")
    assert(list.tailLength() == 3)
    assert(list.tail.tailLength() == 2)
    assert(REEnd.tailLength() == 0)

    println("=====================Product of Elements==============================")
    assert(list.product() == 6)
    assert(list.tail.product() == 6)
    assert(REEnd.product() == 1)

    println("=====================Double of List=========================")
    assert(list.double() == REPair(2, REPair(4, REPair(6, REEnd))))
    assert(list.tail.double() == REPair(4, REPair(6, REEnd)))
    assert(REEnd.double() == REEnd)
  }
}
