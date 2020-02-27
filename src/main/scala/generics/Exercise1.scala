package generics

sealed trait Tree[A] {
  def fold[B](leafFn: A => B, nodeFn: (B, B) => B): B = this match {
    case Node(left, right) => nodeFn(left.fold(leafFn, nodeFn), right.fold(leafFn, nodeFn))
    case Leaf(value) => leafFn(value)
  }
}

final case class Node[A](left: Tree[A], right: Tree[A]) extends Tree[A]

final case class Leaf[A](value: A) extends Tree[A]

object Exercise1 {
  def main(args: Array[String]): Unit = {
    val tree = Leaf(4)
    val tree2 = Node(Leaf(4), Leaf(3))
    println(tree.fold[Int]((leafValue) => leafValue.toString.toInt, (x, y) => x + y)) // SUM
    println(tree2.fold[String](x => x.toString + "   ", (x, y) => x + y)) // COUNT
    val tree3: Tree[String] = Node(Node(Leaf("To"), Leaf("iterate")),
      Node(Node(Leaf("is"), Leaf("human, ")), Node(Leaf("to"), Node(Leaf("rescue"), Leaf("divine")))))
    println(tree3.fold[String](x => x, (x, y) => x + "   " + y))

  }
}
