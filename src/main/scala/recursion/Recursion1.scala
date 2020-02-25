package recursion

import scala.annotation.tailrec

sealed trait RIntList

case object REnd extends RIntList

final case class RPair(head: Int, tail: RIntList) extends RIntList


object Recursion1 {

  def sum(list: RIntList): Int = {
    list match {
      case RPair(head, tail) => head + sum(tail)
      case REnd => 0
    }
  }

  @tailrec
  def tailSum(list: RIntList, total: Int = 0): Int = {
    list match {
      case RPair(head, tail) => tailSum(tail, total + head)
      case REnd => total
    }
  }

  def main(args: Array[String]): Unit = {
    /*    val list1to3 =RPair(1, RPair(2, RPair(3,REnd)))

        val a = REnd
        val b = RPair(1,a)
        val c = RPair(2,b)
        val d = RPair(3,c)

        println(list1to3)
        println(s"a - $a")
        println(s"b - $b")
        println(s"c - $c")
        println(s"d - $d")*/

    val example = RPair(1, RPair(2, RPair(3, REnd)))

    assert(sum(example) == 6)
    assert(sum(example.tail) == 5)
    assert(sum(REnd) == 0)

    assert(tailSum(example) == 6)
    assert(tailSum(example.tail) == 5)
    assert(tailSum(REnd) == 0)
  }
}
