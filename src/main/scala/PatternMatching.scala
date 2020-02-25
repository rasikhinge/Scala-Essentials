case class PatternPerson(firstName: String, lastName: String)

object Stormtrooper {
  def inspect(p: PatternPerson) = {
    p match {
      case PatternPerson("Luke", "Skywalker") => "Stop, rebel scum !"
      case PatternPerson("Han", "Solo") => "Stop, rebel scum !"
      case PatternPerson(first, last) => s"move along, $first"
    }
  }
}

object PatternMatching {
  def main(args: Array[String]): Unit = {
    val p1 = PatternPerson("R", "H")
    val p2 = PatternPerson("Luke", "Skywalker")
    val p3 = PatternPerson("Han", "Solo")

    println(Stormtrooper.inspect(p1))
    println(Stormtrooper.inspect(p2))
    println(Stormtrooper.inspect(p3))
  }
}
