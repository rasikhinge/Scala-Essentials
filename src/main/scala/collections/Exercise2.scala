package collections

case class Film(name: String, yearOfRelease: Int, imdbRating: Double)

case class Director(firstName: String, lastName: String, yearOfBirth: Int, films: Seq[Film])

object Exercise2 {
  def main(args: Array[String]): Unit = {
    val memento = new Film("Memento", 2000, 8.5)
    val darkKnight = new Film("Dark Knight", 2008, 9.0)
    val inception = new Film("Inception", 2010, 8.8)
    val highPlainsDrifter = new Film("High Plains Drifter", 1973, 7.7)
    val outlawJoseyWales = new Film("The Outlaw Josey Wales", 1976, 7.9)
    val unforgiven = new Film("Unforgiven", 1992, 8.3)
    val granTorino = new Film("Gran Torino", 2008, 8.2)
    val invictus = new Film("Invictus", 2009, 7.4)
    val predator = new Film("Predator", 1987, 7.9)
    val dieHard = new Film("Die Hard", 1988, 8.3)
    val huntForRedOctober = new Film("The Hunt for Red October", 1990, 7.6)
    val thomasCrownAffair = new Film("The Thomas Crown Affair", 1999, 6.8)
    val eastwood = new Director("Clint", "Eastwood", 1930,
      Seq(highPlainsDrifter, outlawJoseyWales, unforgiven, granTorino, invictus))
    val mcTiernan = new Director("John", "McTiernan", 1951,
      Seq(predator, dieHard, huntForRedOctober, thomasCrownAffair))
    val nolan = new Director("Christopher", "Nolan", 1970, Seq(memento, darkKnight, inception))
    val someGuy = new Director("Just", "Some Guy", 1990, Seq())
    val directors = Seq(eastwood, mcTiernan, nolan, someGuy)

    val filteredDirectors = directors.filter(d => d.films.length > 3)
    //    println(filteredDirectors)

    val filterDirectorsByYear = directors.find(d => d.yearOfBirth < 1975)
    //    println(filterDirectorsByYear)

    val filterDirectorsByYearAndNoOfFilms = directors.filter(d => d.yearOfBirth < 1975 && d.films.length > 4)
    println(filterDirectorsByYearAndNoOfFilms)
    println("==========================================================================================")

    val filterByAge = directors.filter(d => d.yearOfBirth < 1975)
    val filterByNoOfFilms = directors.filter(d => d.films.length > 4)
    val result = filterByAge.filter(d => filterByNoOfFilms.contains(d))
    println(result)
    println("==========================================================================================")

    val ascending = true
    val orderByYear = if (ascending) directors.sortWith((d1, d2) => d1.yearOfBirth < d2.yearOfBirth) else directors.sortWith((d1, d2) => d1.yearOfBirth > d2.yearOfBirth)
    println(orderByYear)
    println("==========================================================================================")

    val comparator: (Director, Director) => Boolean = {
      if (ascending)
        (d1: Director, d2: Director) => d1.yearOfBirth < d2.yearOfBirth
      else
        (d1: Director, d2: Director) => d1.yearOfBirth > d2.yearOfBirth
    }
    val order = directors.sortWith(comparator)
    println(order)
    println("==========================================================================================")

    val nolanFilms = nolan.films.map(f => f.name)
    println(nolanFilms)
    println("==========================================================================================")

    val directorFilms = directors.flatMap(d => d.films.map(film => film.name))
    println(directorFilms)
    println("==========================================================================================")

    val earlierFilmMac = mcTiernan.films.foldLeft(9999999)((current, film2) => math.min(current, film2.yearOfRelease))
    println(earlierFilmMac)
    println("==========================================================================================")


    val decendingImdRating = directors.flatMap(d => d.films.sortWith((film1, film2) => film1.imdbRating > film2.imdbRating))
    println(decendingImdRating)
    println("==========================================================================================")

    val value = directors.flatMap(director => director.films.map(film => film.imdbRating))

    //    value.fold(0)((rating1, rating2) => rating1 + rating2)

    val average = value.foldLeft(0.0)((total, rating) => total + rating) / value.length
    println(average)
    println("==========================================================================================")

    directors
      .foreach(director =>
        director.films
          .foreach(film => println(s"Tonight Only ! ${film.name} By ${director.firstName} ${director.lastName}")))
    println("==========================================================================================")

    val earlierFilmYear = directors.flatMap(director => director.films)
      .foldLeft(99999)((result, film) => Integer.min(result, film.yearOfRelease))
    println(earlierFilmYear)
    println("==========================================================================================")

    val list = Seq(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println(minimum(list))
    println("==========================================================================================")

    val duplicate = Seq(1, 2, 3, 4, 5, 6, 1, 23, 4, 5)
    val uniqueSeq = unique(duplicate)
    println(uniqueSeq)
    println("==========================================================================================")

    val revSeq = reverse(list)
    println(revSeq)
    println("==========================================================================================")

    val stringList = map[Int, String](list, x => "String " + x.toString)
    println(stringList)
    println("==========================================================================================")
  }

  def minimum(seq: Seq[Int]): Int = {
    seq.foldLeft(Int.MaxValue)((result, element) => Integer.min(result, element))
  }

  def unique(seq: Seq[Int]): Seq[Int] = {
    def insert(sequence: Seq[Int], ele: Int): Seq[Int] = {
      if (!sequence.contains(ele)) {
        sequence :+ ele
      } else {
        sequence
      }
    }

    seq.foldLeft(Seq.empty[Int])((uniqueSeq, element) => insert(uniqueSeq, element))
  }

  def reverse[A](seq: Seq[A]): Seq[A] = {
    def insert(sequence: Seq[A], ele: A): Seq[A] = {
      ele +: sequence
    }

    seq.foldLeft(Seq.empty[A]) {
      (reverseSeq, element) => insert(reverseSeq, element)
    }
  }

  def map[A, B](seq: Seq[A], f: A => B): Seq[B] = {
    seq.foldRight(Seq.empty[B])((element, transformedSeq) => {
      f(element) +: transformedSeq
    })
  }

  def foldLeft1[A, B](seq: Seq[A], zero: B, fn: (B, A) => B): B = {
    var result: B = zero

    seq.foreach(element => {
      result = fn(result, element)
    })
    result
  }

}
