package typeclasses.implicits

import typeclasses.{Equal, Person}

object NameAndEmailImplicit {

 implicit object NameAndEmailComparer extends Equal[Person] {
    def equal(p1: Person, p2: Person): Boolean = {
      p1.name.equals(p2.name) && p1.email.equals(p2.email)
    }
  }

}