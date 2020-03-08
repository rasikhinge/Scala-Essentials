package mapFlatmap

sealed trait LinkedList[A] {
  def map[B](f: A => B): LinkedList[B] = {
    this match {
      case End() => End[B]()
      case Node(head, tail) => Node(f(head), tail.map(f))
    }
  }

  def fold[T](endFn: T, NodeFn: (A, T) => T): T = {
    this match {
      case End() => endFn
      case Node(head, tail) => NodeFn(head, tail.fold(endFn, NodeFn))
    }
  }

  def flatMap[B](f: A => LinkedList[B]) : LinkedList[B] = {
    this match {
      case End() => End[B]()
      case Node(head,tail) => f(head) 
    }
  }
}

final case class End[A]() extends LinkedList[A]

final case class Node[A](head: A, tail: LinkedList[A]) extends LinkedList[A]

object ListMap {
  def main(args: Array[String]): Unit = {
    val list = Node(1, Node(2, Node(3, End())))
    val listString = list.map(x => " String" + x.toString)
    println(listString)
    val listFold = list.fold[String]("", (x, y) => x.toString + "  " + y)
    val listMapFold = list.fold[LinkedList[String]](End[String](), (x, y) => Node("String " + x.toString, y))

    val listOfList = list.map(x => Node(x - 1, Node(x, Node(x + 1, End()))))
    println(listFold)
    println(listMapFold)
    println(listOfList)
  }
}
