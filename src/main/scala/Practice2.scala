class Person(first: String, last: String) {
  val firstName = first
  val lastName = last

  def name = firstName + " " + lastName

  def greet(person: Person = new Person("Some", "Body")): Unit = {
    println(s"Hello,  ${person.name}")
  }
}

class Cat(val name: String, val color: String, val food: String) {
  def details = name + "  " + color + "  " + food
}

object ChipShop {
  def willServe(cat: Cat): Boolean = {
    if (cat.food == "Chips")
      true
    else
      false
  }
}

object Practice2 {
  def main(args: Array[String]): Unit = {
    /*
        val rasik = new Person("Rasik", "Hinge")
        println(rasik.name)
        val ras1 = new Person(last = "ABC", first = "Rasik")
        println(ras1.name)
        ras1.greet(rasik)
        ras1.greet()
    */

    val oswald = new Cat("Oswald", "Black", "Milk")
    val henderson = new Cat("Henderson", "Ginger", "Chips")
    val quentin = new Cat("Quentin", "Tabby And White", "Curry")

    println(oswald.details)
    println(henderson.details)
    println(quentin.details)

    assert(ChipShop.willServe(oswald) == false)
    assert(ChipShop.willServe(henderson) == true)
    assert(ChipShop.willServe(quentin) == false)
  }
}
