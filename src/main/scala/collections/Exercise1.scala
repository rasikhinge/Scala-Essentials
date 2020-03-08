package collections

object Exercise1 {
  def main(args: Array[String]): Unit = {
    val animals = Seq("cat", "dog", "penguin")
    val append = animals :+ ("tyrannosaurus")
    val prepend = "mouse" +: append
    val intPrepend = 2 +: prepend
    println(animals)
    println(append)
    println(prepend)
    println(intPrepend)
  }
}
