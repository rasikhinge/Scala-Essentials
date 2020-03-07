package mapFlatmap


object Exercise1 {
  def main(args: Array[String]): Unit = {
    val list = List(1, 2, 3)
    val listNegation = list.flatMap(ele => List(ele, -ele))
    println(listNegation)
  }
}
