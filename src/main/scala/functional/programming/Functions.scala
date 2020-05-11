package functional.programming

class PracticeFunctions {
  def isSorted[A](array: Array[A], sortF: (A, A) => Boolean): Boolean = {
    val sortedArray = array.sortWith(sortF)
    println(sortedArray.mkString(" "))
    println(array.mkString(" "))
    val bool = sortedArray.sameElements(array)
    println(bool)
    bool
  }
}

object Functions {
  def main(args: Array[String]): Unit = {
    val array = Array(1, 2, 3, 4, 5, 6, 7)
    val pf = new PracticeFunctions
    val isDecending = pf.isSorted[Int](array, (x, y) => x > y)
    val isAcending = pf.isSorted[Int](array, (x, y) => x < y)
    println(isAcending + "   " + isDecending)
  }
}
