package typeclasses

import typeclasses.intimplicits.Extension._

object Exercise4 {
  def main(args: Array[String]): Unit = {
    5.yeah()
    println("===========================")
    1.yeah()
    println("===========================")
    (-1).yeah()
    println("===========================")

    4.times(i => println(s"printing $i"))
    println("===========================")
    10.times(i => println(s" printing 2 table - 2 X $i = ${2 * i}"))
  }
}
