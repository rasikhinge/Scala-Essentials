package typeclasses.implicits

import typeclasses.Order

object OrderByTotalPrice {
  implicit val ordering = Ordering.fromLessThan[Order]((x, y) => x.totalPrice < y.totalPrice)
}
