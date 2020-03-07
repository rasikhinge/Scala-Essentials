final case class Box1[A](value: A)

Box1(2)
Box1("Rasik")

def generic[B](input: B): B = input

generic("RAsik")
generic[Int](1)

object Sum {
  def sum(x: Int, y: Int) = {
    x + y
  }
}

val fn = (Sum.sum _)
fn(1, 2)

