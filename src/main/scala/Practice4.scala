class Counter(val count: Int) {
  def inc(delta: Int = 1): Counter = new Counter(count + delta)

  def dec(delta: Int = 1): Counter = new Counter(count - delta)

  def inc: Counter = new Counter(count)

  def dec: Counter = new Counter(count)

  def adjust(adder: Adder): Counter = {
    new Counter(adder(count))
  }

  override def toString = s"Counter($count)"
}

class Adder(amount: Int) {
  def apply(in: Int): Int = in + amount
}

object Practice4 extends App {
  println(new Counter(110).inc(5).dec(2).inc(-1).inc.count)
  println(new Counter(4).adjust(new Adder(7)).count)
}
