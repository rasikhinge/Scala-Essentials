package typeclasses.implicits

import typeclasses.{Equal, Person}

object CaseInsensitiveNameComparer {
  implicit val comparer = new Equal[Person] {
    def equal(val1:Person, val2:Person):Boolean    = {
      val1.name.toLowerCase == val2.name.toLowerCase
    }
  }
}
