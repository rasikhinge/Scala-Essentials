case class CasePerson(firstName: String, lastName: String) {
  def name = s"$firstName $lastName"
}

object CasePerson {
  def apply(name: String): CasePerson = {
    val details = name.split(" ")
    new CasePerson(details(0), details(1))
  }
}
object CaseClassPerson {
  def main(args: Array[String]): Unit = {
    val p = CasePerson("A", "B")
    val p1 = CasePerson("A1 B1")

  }
}
