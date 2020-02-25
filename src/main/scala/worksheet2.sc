object Oswald {
  val color = "Black"
  val favoriteFood = "Milk"
}

object Henderson {
  val color = "Ginger"
  val favoriteFood = "Chips"
}

object Quentin {
  val color = "Tabby And White"
  val favoriteFood = "Curry"
}

object Calc {
  def square(input: Double): Double = input * input

  def cube(input: Double): Double = input * square(input)

  def square(input: Int): Int = input * input

  def cube(input: Int): Int = square(input) * input

}

Calc.square(4)
Calc.cube(6)
Calc.square(2.0)
//val result : Int = Calc.square(2.0)
val result: Int = Calc.square(2.0).toInt

object argh {

  def a = {
    println("a")
    1
  }

  val b = {
    println("b")
    a + 2
  }

  def c = {
    println("c")
    a
    b + "c"
  }
}

argh.c + argh.b + argh.a

/*
b
a
b = 3

c
a

a

3c  +  3 + 1

3c31
*/

object person {
  val firstName = "";
  val lastName = "";
}

object alien {
  def greet(p: person.type ) = {
    "Hello" + p.firstName + p.lastName
  }
}


