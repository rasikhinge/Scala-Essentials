class Person1(first: String, last: String) {
  val firstName = first
  val lastName = last

  def name = s"$firstName $lastName"
}

object Person1 {
  def apply(name: String) = {
    val names = name.split(" ")
    new Person(names(0), names(1))
  }
}

object Practice5 {
  def main(args: Array[String]): Unit = {
    val person = new Person1("Rasik", "Hinge")
    println(person.name)
    val p1 = Person1("Rasik Hinge")
    println(p1.name)
    println(p1.getClass)
  }
}
