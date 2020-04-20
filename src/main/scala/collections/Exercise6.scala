package collections

object Exercise6 {
  def main(args: Array[String]): Unit = {
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
  }

  def getFavoriteColor(personName: String): String = {
    favoriteColor.get    (personName)
  }
}
