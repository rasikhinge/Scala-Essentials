package generics

sealed trait LinkedList2[A] {

  def fold[T](end: T, f: (A, T) => T): T = {
    this match {
      case End2() => end
      case Pair2(head, tail) => f(head, tail.fold(end, f)) // (Int, T)=> T  = head + tail.fold OR  head * tail.fold OR  Pair(head, tail.fold) etc
    }
  }
}

final case class End2[A]() extends LinkedList2[A]

final case class Pair2[A](head: A, tail: LinkedList2[A]) extends LinkedList2[A]

object Generics4WithFold {
  def main(args: Array[String]): Unit = {
    val list1 = Pair2(1, Pair2(2, Pair2(3, End2())))
    val list2 = Pair2("A", Pair2("AB", Pair2("ABC", End2())))

    println(list2.fold[Int](0, (x: String, y: Int) => x.length + y)) // length of string
    println(list2.fold[Boolean](true, (x: String, y: Boolean) => x.contains("D") && y)) // contains of string
  }
}
