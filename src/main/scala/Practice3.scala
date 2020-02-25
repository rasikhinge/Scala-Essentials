class Director(first: String, last: String, dob: Int) {
  val firstName: String = first
  val lastName: String = last
  val yearOfBirth: Int = dob

  def name = s"$firstName $lastName"

  override def toString = s"Director(name = $name, yearOfBirth = $yearOfBirth)"
}

object Director {
  def apply(first: String, last: String, dob: Int): Director = {
    new Director(first, last, dob)
  }

  def older(dir1: Director, dir2: Director): Director = {
    if (dir1.yearOfBirth < dir2.yearOfBirth) dir1 else dir2
  }
}

class Film(filmName: String, year: Int, rating: Double, dirtr: Director) {
  val name: String = filmName
  val yearOfRelease: Int = year
  val imdbRating: Double = rating
  val director: Director = dirtr

  def directorsAge: Int = yearOfRelease - director.yearOfBirth

  def isDirectedBy(dir: Director): Boolean = director == dir

  def copy(filmName: String = name,
           year: Int = yearOfRelease,
           rating: Double = imdbRating,
           dir: Director = director): Film = {
    new Film(filmName, year, rating, dir)
  }

  override def toString: String = s"Film(name = $name, yearOfRelease = $yearOfRelease , imdbRating = $imdbRating, director = $director)"
}

object Film {
  def apply(filmName: String, year: Int, imdbRating: Double, dir: Director): Film = {
    new Film(filmName, year, imdbRating, dir)
  }

  def highestRating(f1: Film, f2: Film): Double = {
    if (f1.imdbRating > f2.imdbRating) f1.imdbRating else f2.imdbRating
  }

  def oldestDirectorAtTheTime(f1: Film, f2: Film): Director = {
    if (f1.directorsAge > f2.directorsAge) f1.director else f2.director
  }
}

object Practice3 extends App {
   val eastwood = new Director("Clint", "Eastwood", 1930)
   val mcTiernan = new Director("John", "McTiernan", 1951)
   val nolan = new Director("Christopher", "Nolan", 1970)
   val someBody = new Director("Just", "Some Body", 1990)
   val memento = new Film("Memento", 2000, 8.5, nolan)
   val darkKnight = new Film("Dark Knight", 2008, 9.0, nolan)
   val inception = new Film("Inception", 2010, 8.8, nolan)
   val highPlainsDrifter = new Film("High Plains Drifter", 1973, 7.7,
     eastwood)
   val outlawJoseyWales = new Film("The Outlaw Josey Wales", 1976, 7.9,
     eastwood)
   val unforgiven = new Film("Unforgiven", 1992, 8.3, eastwood)
   val granTorino = new Film("Gran Torino", 2008, 8.2, eastwood)
   val invictus = new Film("Invictus", 2009, 7.4, eastwood)
   val predator = new Film("Predator", 1987, 7.9, mcTiernan)
   val dieHard = new Film("Die Hard", 1988, 8.3, mcTiernan)
   val huntForRedOctober = new Film("The Hunt for Red October", 1990,
     7.6, mcTiernan)
   val thomasCrownAffair = new Film("The Thomas Crown Affair", 1999, 6.8,
     mcTiernan)

   println(eastwood.yearOfBirth)

   println(dieHard.director.name)

   println(invictus.isDirectedBy(nolan))

   println(highPlainsDrifter.copy(filmName = "L'homme des hautes plaines"))
   println(thomasCrownAffair.copy(year = 1968, dir = new Director("Norman", "Jewison", 1926)))
   println(inception.copy().copy().copy())
}