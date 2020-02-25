case class CaseCounter(count: Int = 0) {
  def inc(delta: Int = 1): CaseCounter = copy(count + delta)

  def dec(delta: Int = 1): CaseCounter = copy(count - delta)

  def adjust(adder: CaseAdder): CaseCounter = {
    CaseCounter(adder.apply(count))
  }
}

case class CaseAdder(amount: Int) {
  def apply(in: Int): Int = {
println(amount+" "+in)
    in + amount
  }
}

object CaseClassCounter {
  def main(args: Array[String]): Unit = {
    val counter1 = CaseCounter()
    val counter2 = CaseCounter(1)

    assert(counter1.inc().dec(2).inc(4).inc(3) == CaseCounter(6))
    assert(counter2.inc(2).dec(-2).inc().dec(3) == CaseCounter(3))
    assert(counter2. adjust(CaseAdder(2)) == CaseCounter(3))
  }
}
