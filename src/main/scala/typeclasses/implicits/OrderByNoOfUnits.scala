package typeclasses.implicits

import typeclasses.Order

object OrderByNoOfUnits {
  implicit val ordering = Ordering.fromLessThan[Order]((x, y) => {
    x.units < y.units
  })
}
