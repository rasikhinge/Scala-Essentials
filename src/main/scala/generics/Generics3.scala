package generics

sealed trait RResult[A]

final case class RSuccess[A](value: A) extends RResult[A]

final case class RFailure[A](message: String) extends RResult[A]

sealed trait LinkedList[A] {
  def print(): String = this match {
    case Pair(h, tail) => h.toString + ", " + tail.print()
    case End() => ""
  }

  def length(totalLength: Int = 0): Int = this match {
    case Pair(head, tail) => tail.length(1 + totalLength)
    case End() => totalLength
  }

  def contains(value: A): Boolean = {
    this match {
      case Pair(head, tail) => if (head.equals(value)) true else tail.contains(value)
      case End() => false
    }
  }

  def apply(index: Int): RResult[A] = this match {
    case Pair(head, tail) => if (index == 0) RSuccess(head) else tail.apply(index - 1)
    case End() => RFailure("Index out of bounds") //throw new Exception("Index out of bounds")
  }
}

final case class Pair[A](head: A, tail: LinkedList[A]) extends LinkedList[A]

final case class End[A]() extends LinkedList[A]

object Generics3 {
  def main(args: Array[String]): Unit = {
    val list = Pair(1, Pair(2, Pair(3, End()))).print()
    val list1 = Pair("A", Pair("B", Pair("C", End()))).print()
    val list2 = Pair(1, Pair(2, Pair(3, End())))
    val list3 = Pair[String]("a", Pair[String]("1", Pair[String]("true", End())))

    println("list3 - " + list3)
    println(list)
    println(list1)
    println(list2.length())
    println(list2.tail.length())
    println(End().length())

    assert(list2.contains(2) == true)
    assert(list2.contains(4) == false)
    assert(End().contains(0) == false)
    //    assert(list2.contains("0") == false)

    /*  assert(list2(0) == 1)
      assert(list2(1) == 2)
      assert(list2(2) == 3)
      assert(try {
        list2(3)
        false
      } catch {
        case e: Exception => true
      })*/
    assert(list2(0) == RSuccess(1))
    assert(list2(1) == RSuccess(2))
    assert(list2(2) == RSuccess(3))
    assert(list2(3) == RFailure("Index out of bounds"))

  }
}
