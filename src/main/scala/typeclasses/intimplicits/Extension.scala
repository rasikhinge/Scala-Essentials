package typeclasses.intimplicits

object Extension {

  implicit class IntegerExtension(value: Int) {
    def yeah(): Unit = {
      times(i => println("Oh Yeah!"))
    }

    def times(f: Int => Unit): Unit = {
      (1 to value).foreach(i => f(i))
    }
  }

}
