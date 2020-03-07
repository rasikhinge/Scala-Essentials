package generics

sealed trait PTree[A] {
  def fold[B](leaf: A => B, node: (B, B) => B): B =this match {
    case PLeaf(value) => leaf(value)
    case PNode(left, right) => node(left.fold(leaf, node), right.fold(leaf, node))
  }
}

final case class PNode[A](left: PTree[A], right: PTree[A]) extends PTree[A]

final case class PLeaf[A](value: A) extends PTree[A]

final case class PTuple2[T,R](_1:T,_2:R)



object GenericTree {
  def main(args: Array[String]): Unit = {

  }
}
