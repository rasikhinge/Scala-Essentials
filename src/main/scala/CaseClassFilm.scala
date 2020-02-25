case class CaseDirector(firstName: String, lastName: String, yearOfBirth: Int) {
  def name: String = s"$firstName $lastName"
}

object CaseDirector {
  def older(dir1: CaseDirector, dir2: CaseDirector): CaseDirector = {
    if (dir1.yearOfBirth < dir2.yearOfBirth) dir1 else dir2
  }
}

case class CaseFilm(name: String, yearOfRelease: Int, imdbRating: Double, director: CaseDirector) {
  def isDirectedBy(dir: CaseDirector): Boolean = director == dir

  def directorAge: Int = yearOfRelease - director.yearOfBirth

  def olderDirectorAtTime(f2: CaseFilm): CaseDirector = {
    if (directorAge > f2.directorAge) director else f2.director
  }
}

object CaseFilm {
  def highestRating(f1: CaseFilm, f2: CaseFilm): Double = {
    if (f1.imdbRating > f2.imdbRating) f1.imdbRating else f2.imdbRating
  }
}

object CaseDad {
  def rating(film: CaseFilm): Double = {
    film match {
      case CaseFilm(_, _, _, CaseDirector("Clint", "Eastwood", _)) => 10.0
      case CaseFilm(_, _, _, CaseDirector("John", "McTiernan", _)) => 7.0
      case CaseFilm(_, _, _, CaseDirector(_, _, _)) => 3.0
    }
  }
}

object CaseClassFilm {
  def main(args: Array[String]): Unit = {
    val eastwood = new CaseDirector("Clint", "Eastwood", 1930)
    val mcTiernan = new CaseDirector("John", "McTiernan", 1951)
    val nolan = new CaseDirector("Christopher", "Nolan", 1970)
    val someBody = new CaseDirector("Just", "Some Body", 1990)
    val memento = new CaseFilm("Memento", 2000, 8.5, nolan)
    val darkKnight = new CaseFilm("Dark Knight", 2008, 9.0, nolan)
    val inception = new CaseFilm("Inception", 2010, 8.8, nolan)
    val highPlainsDrifter = new CaseFilm("High Plains Drifter", 1973, 7.7,
      eastwood)
    val outlawJoseyWales = new CaseFilm("The Outlaw Josey Wales", 1976, 7.9,
      eastwood)
    val unforgiven = new CaseFilm("Unforgiven", 1992, 8.3, eastwood)
    val granTorino = new CaseFilm("Gran Torino", 2008, 8.2, eastwood)
    val invictus = new CaseFilm("Invictus", 2009, 7.4, eastwood)
    val predator = new CaseFilm("Predator", 1987, 7.9, mcTiernan)
    val dieHard = new CaseFilm("Die Hard", 1988, 8.3, mcTiernan)
    val huntForRedOctober = new CaseFilm("The Hunt for Red October", 1990,
      7.6, mcTiernan)
    val thomasCrownAffair = new CaseFilm("The Thomas Crown Affair", 1999, 6.8,
      mcTiernan)

    println(invictus.isDirectedBy(nolan))

    val film1 = CaseFilm("A", 1990, 9.0, CaseDirector("Karan", "Johar", 1970))
    val film2 = CaseFilm("B", 1985, 7.0, CaseDirector("Anurag", "Kashyap", 1970))
    println(film1.olderDirectorAtTime(film2))

    println(CaseDad.rating(CaseFilm("A", 2019, 9.0, CaseDirector("A", "B", 1990))))
    println(CaseDad.rating(CaseFilm("B", 2019, 9.0, CaseDirector("Clint", "Eastwood", 1990))))
    println(CaseDad.rating(CaseFilm("C", 2019, 9.0, CaseDirector("John", "McTiernan", 1990))))
  }
}
