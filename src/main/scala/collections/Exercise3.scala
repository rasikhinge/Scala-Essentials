package collections

case class FFilm(name: String, yearOfRelease: Int, imdbRating: Double)

case class FDirector(firstName: String, lastName: String, yearOfBirth: Int, films: Seq[FFilm])

object Exercise3 {
  def main(args: Array[String]): Unit = {
    val memento = new FFilm("Memento", 2000, 8.5)
    val darkKnight = new FFilm("Dark Knight", 2008, 9.0)
    val inception = new FFilm("Inception", 2010, 8.8)
    val highPlainsDrifter = new FFilm("High Plains Drifter", 1973, 7.7)
    val outlawJoseyWales = new FFilm("The Outlaw Josey Wales", 1976, 7.9)
    val unforgiven = new FFilm("Unforgiven", 1992, 8.3)
    val granTorino = new FFilm("Gran Torino", 2008, 8.2)
    val invictus = new FFilm("Invictus", 2009, 7.4)
    val predator = new FFilm("Predator", 1987, 7.9)
    val dieHard = new FFilm("Die Hard", 1988, 8.3)
    val huntForRedOctober = new FFilm("The Hunt for Red October", 1990, 7.6)
    val thomasCrownAffair = new FFilm("The Thomas Crown Affair", 1999, 6.8)
    val eastwood = new FDirector("Clint", "Eastwood", 1930,
      Seq(highPlainsDrifter, outlawJoseyWales, unforgiven, granTorino, invictus))
    val mcTiernan = new FDirector("John", "McTiernan", 1951,
      Seq(predator, dieHard, huntForRedOctober, thomasCrownAffair))
    val nolan = new FDirector("Christopher", "Nolan", 1970, Seq(memento, darkKnight, inception))
    val someGuy = new FDirector("Just", "Some Guy", 1990, Seq())
    val directors = Seq(eastwood, mcTiernan, nolan, someGuy)


    val nolanFilmNames = for {
      film <- nolan.films
    } yield film.name

    println(nolanFilmNames)
    println("=====================================================================")

    val allfilmNames = for {
      director <- directors
      film <- director.films
    } yield film.name
    println(allfilmNames)
    println("=====================================================================")

    val descending = for {
      director <- directors
      film <- director.films
    } yield film.imdbRating

    val descendingImdbRating = descending.sortWith((d1, d2) => d1 > d2)

    println(descendingImdbRating)
    println("=====================================================================")

    for {
      director <- directors
      film <- director.films
    } println(s"Tonight Only ! ${film.name} by ${director.firstName} ${director.lastName}")
    println("=====================================================================")
  }
}
