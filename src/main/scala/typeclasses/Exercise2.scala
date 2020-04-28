package typeclasses

import typeclasses.implicits.OrderByTotalPrice._

final case class Order(units: Int, unitPrice: Double) {
  val totalPrice: Double = unitPrice * units
}

object Exercise2 {
  def main(args: Array[String]): Unit = {
    val order1 = Order(5, 4.0)
    val order2 = Order(5, 3.0)
    val order3 = Order(10, 2.0)
    val order4 = Order(1, 40.0)
    val order5 = Order(15, 10.0)
    val orders = List(order1, order2, order3, order4, order5)

    println(orders.sorted)
  }
}
