package recursion

sealed trait RTree {
  def sum(): Int = {
    this match {
      case RLeaf(value) => value
      case RNode(left, right) => left.sum() + right.sum()
    }
  }

  def double(): RTree = {
    this match {
      case RLeaf(value) => RLeaf(2 * value)
      case RNode(left, right) => RNode(left.double(), right.double())
    }
  }
}

final case class RNode(left: RTree, right: RTree) extends RTree

final case class RLeaf(value: Int) extends RTree

object Exercise2 {
  def main(args: Array[String]): Unit = {
    val leaf = RLeaf(1)
    println(leaf)
    val tree = RNode(RLeaf(1), RLeaf(2))
    println(tree)
    val tree1 = RNode(RNode(RLeaf(3), RLeaf(4)), RNode(RLeaf(2), RLeaf(1)))
    println(tree1)
    val sum = tree1.sum()
    println(sum)
    println(tree1.double())
  }
}
