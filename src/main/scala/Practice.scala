class Practice {

  def kangaroo(x1: Int, v1: Int, x2: Int, v2: Int): Unit = {
   /* var meetUpPoint = -1
    var meetUpStep = -1
    var iterate = true
    for (i <- 1 to 100;
         if iterate) {
      val firstKangarooStep = x1 + i * v1
      val secondKangarooStep = x2 + i * v2
      if (firstKangarooStep == secondKangarooStep) {
        meetUpPoint = i
        meetUpStep = firstKangarooStep
        iterate = false
      }
    }*/

    val value = LazyList.from(1)
      .find(i => {
        val kangarooOneStep: Int = x1 + i * v1
        val kangarooSecondStep: Int = x2 + i * v2
        kangarooOneStep == kangarooSecondStep || i == 100000
      }).map(i => if (i < 100000) "YES" else "NO")
    println("Meetup Step - "+ value)
  }
}

object PracticeObj {
  def main(args: Array[String]): Unit = {
    val prac = new Practice
    prac.kangaroo(0, 2, 5, 3)
  }
}
