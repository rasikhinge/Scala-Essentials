"foo" take 1

1.+(2).+(3)

object Test {}

Test

object Test1 {
  val field1 = {
    println("Field")
    42
  }

  def method = {
    println("Method")
    43
  }
}

Test1
Test1.field1
Test1.field1
Test1.method
Test1.method