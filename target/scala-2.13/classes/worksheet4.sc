case class Person(firstName:String, lastName:String) {
  def name = s"$firstName $lastName"
}

case class P1() {
  def hello = println("Hello")
}

val p1  = P1()
p1.hello

val p =Person("R","H")
Person
p.firstName
p.name

new Person("A","B").equals(new Person("A","B"))
new Person("A","B") == new Person("A","B")

p.copy()

class Emp(firstName:String, lastName : String) {
  def name = s"$firstName $lastName"
}

new Emp("A","B").equals(new Emp("A","B"))
new Emp("A","B") == new Emp("A","B")
