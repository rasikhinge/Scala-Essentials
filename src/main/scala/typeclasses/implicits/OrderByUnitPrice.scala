package typeclasses.implicits

import typeclasses.Order

object OrderByUnitPrice {
  implicit val ordering = Ordering.fromLessThan[Order]((x, y) => {
    x.unitPrice < x.unitPrice
  })
}
