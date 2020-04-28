package typeclasses

import typeclasses.Extensions.ExtensionMethod

object Extensions {

  implicit class ExtensionMethod(str: String) {
    val vowels = List("a", "e", "i", "o", "u", "h")

    def numberOfVowels = str.toList.filter(cr => vowels.contains(cr.toString)).length
  }

}

object ImplicitClass {
  def main(args: Array[String]): Unit = {
    val myString = "Hello there, I am Rasik !"
    val count = myString.numberOfVowels
    println(count)
  }
}
