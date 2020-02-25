class Practice1 {
  /*
2 4
16 32 96
   */
  def getTotalX(a: Array[Int], b: Array[Int]) = {
    (1 to 100)
      .filter(i => {
        //        println(i)
        a.toSeq.forall(a1 => i % a1 == 0) &&
          b.toSeq.forall(b1 => b1 % i == 0)
      }).toList
  }
}

object Prac1 {
  def main(args: Array[String]): Unit = {
    val prac = new Practice1
    val numbers = prac.getTotalX(Array(2, 4), Array(16, 32, 96))
    numbers.foreach(println)
  }
}
