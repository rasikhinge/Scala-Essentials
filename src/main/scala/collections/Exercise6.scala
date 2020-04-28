package collections

object Exercise6 {
  val ages = Map(
    "Alice" -> 20,
    "Bob" -> 30,
    "Charlie" -> 50,
    "Derek" -> 40,
    "Edith" -> 10,
    "Fred" -> 60)
  val favoriteColors = Map(
    "Bob" -> "green",
    "Derek" -> "magenta",
    "Fred" -> "yellow")
  val favoriteLolcats = Map(
    "Alice" -> "Long Cat",
    "Charlie" -> "Ceiling Cat",
    "Edith" -> "Cloud Cat")

  val people = Set(
    "Alice",
    "Bob",
    "Charlie",
    "Derek",
    "Edith",
    "Fred")

  def main(args: Array[String]): Unit = {
    val color = getFavoriteColor("Rasik")
    println(color)
    println("=========================================")
    printColors()
    println("=========================================")
    val color2 = lookUp("Bob", favoriteColors)
    println(color2)
    println("=========================================")
    val age = lookUp("Bob", ages)
    println(age)
    println("=========================================")
    val oldestPerson = oldest
    val oldestColor = getFavoriteColor(oldestPerson.getOrElse(""))
    println(oldestColor)
    println("=========================================")

    val set1 = Set(1, 2, 3, 4, 5, 6)
    val set2 = Set(1, 2, 3, 4, 5, 6, 7)
    val union = setUnion(set1, set2)
    println(union)
    val map1 = Map("a" -> 1, "b" -> 2, "c" -> 3)
    val map2 = Map("a" -> 1, "b" -> 2)
    val unionMap = mapUnion(map1, map2)
    val generic = genericMapUnion[String, Int](map1, map2, (x, y) => x + y)
    println(unionMap)
    println(generic)
  }

  def oldest = people.foldLeft(Option.empty[String]) {
    (older, name) => {
      if (ages.getOrElse(name, 0) > older.flatMap(olderName => ages.get(olderName)).getOrElse(0)) {
        Some(name)
      } else {
        older
      }
    }
  }

  def getFavoriteColor(personName: String): String = {
    favoriteColors.getOrElse(personName, "Beige")
  }

  def printColors(): Unit = {
    people.foreach(p => println(getFavoriteColor(p)))
  }

  def lookUp[A](name: String, map: Map[String, A]): A = {
    map(name)
  }

  def setUnion[A](set1: Set[A], set2: Set[A]): Set[A] = {
    set2.foldLeft(set1)((result, set2Ele) => {
      if (!result.contains(set2Ele))
        result + set2Ele
      else
        result
    })
  }

  def mapUnion[A](map1: Map[A, Int], map2: Map[A, Int]): Map[A, Int] = {
    map1.foldLeft(map2)((map, element) => {
      val (key, value) = element
      val value2 = map.getOrElse(key, 0)
      val totalVal = value + value2
      map + (key -> totalVal)
    })
  }

  def genericMapUnion[A, B](map1: Map[A, B], map2: Map[A, B], addFn: (B, B) => B): Map[A, B] = {
    map1.foldLeft(map2)((map, keyValuePair) => {
      val (key, value) = keyValuePair
      val value2 = map.get(key)
      val newVal = value2.map(v2 => addFn(value, v2)).getOrElse(value)
      map + (key -> newVal)
    })
  }
}
