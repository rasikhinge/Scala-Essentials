package typeclasses.implicits

import typeclasses.{Equal, Person}

object EmailComparerImplicit {

  implicit object EmailComparer extends Equal[Person] {
    def equal(p1: Person, p2: Person): Boolean = {
      p1.email == p2.email
    }
  }

}
