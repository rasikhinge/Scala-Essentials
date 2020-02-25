class P1 {
  def hello(str: String) = println("Hello, " + str)

  def apply(i: Int) = println("printing" + i)
}

class Ras {
  private val name: String = "Rasik Hinge"

  private def disp123 = println("Hello Private")

  def apply(s: String) = {
    Ras.disp
    println("Printing Ras - " + s)
  }
}


object Ras {
  private def disp = println("Hello Private")

  def app(i: Int) = {
    disp
    println("Printing from PracObj - ")
    println("Printing from PracObj - ")
  }

  def apply() = {
    new Ras
  }
}


object CaseClassPrac {
  def main(args: Array[String]): Unit = {
    val r1 = Ras()
    val r2 = Ras
    println(r1)
    println(r2)

    //    val p1 = new Ras
    //    println(p1)
    //    println(p1("1"))
    //    println(p1.apply("5"))
    //    val obj = Ras
    //    println(obj)
    //    println(obj())
    //    val r1 = new Ras
    //    println(r1("1"))
    //    val r2 = Ras()
    //    println(r2)
  }
}
