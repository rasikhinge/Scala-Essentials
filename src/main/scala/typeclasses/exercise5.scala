package typeclasses

import typeclasses.ImplicitDef._

object ImplicitDef {

  class IntOps(value: Int) {
    def times(f: Int => Unit): Unit = {
      (1 to value).foreach(i => f(i))
    }

    def yeah()= {
      times(i => println("Oh Yeah!"))
    }
  }

  implicit def intToIntOps(v: Int): IntOps = {
    new IntOps(v)
  }
}

object exercise5 {
  def main(args: Array[String]): Unit = {
    1.times(i => println(s"printing  $i"))
    5.times(i => println(s"printing  $i"))

    10.yeah()
  }
}
