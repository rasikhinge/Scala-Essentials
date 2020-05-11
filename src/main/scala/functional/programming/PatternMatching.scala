package functional.programming

sealed trait List[A] {
}

object List {
  def sum(list: List[Int]): Int = {
    list match {
      case Nil() => 0
      case Cons(h, t) => h + sum(t)
    }
  }

  def tail[A](list: List[A]) = {
    list match {
      case Nil() => Nil()
      case Cons(h, t) => t
    }
  }

  def setHead[A](list: List[A], head: A): List[A] = list match {
    case Nil() => Cons(head, Nil())
    case Cons(h, t) => Cons(head, t)
  }

  def drop[A](list: List[A], n: Int): List[A] = {
    list match {
      case Cons(h, t) =>
        if (n == 0) {
          list
        } else {
          drop(t, n - 1)
        }
      case Nil() => Nil()
    }
  }

  def dropWhile[A](list: List[A], predicate: A => Boolean): List[A] = {
    list match {
      case Nil() => Nil()
      case Cons(h, t) =>
        if (predicate(h)) {
          dropWhile(t, predicate)
        } else {
          list
        }
    }
  }

  def foldRight[A, B](list: List[A], defaultValue: B, f: (A, B) => B): B = {
    list match {
      case Nil() => defaultValue
      case Cons(h, t) => f(h, foldRight(t, defaultValue, f))
    }
  }

  def foldLeft[A, B](list: List[A], defaultValue: B, f: (B, A) => B): B = {
    list match {
      case Cons(h, t) => f(foldLeft(t, defaultValue, f), h)
      case Nil() => defaultValue
    }
  }
}

case class Nil[A]() extends List[A]

case class Cons[A](head: A, tail: List[A]) extends List[A]


class PatternMatchingPractice {
  val list = Cons(1, Cons(2, Cons(3, Cons(4, Cons(5, Nil())))))

  def matching(): Int = {
    val result = list match {
      case Cons(x, Cons(2, Cons(4, _))) => x
      case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => x + y
      case Cons(h, t) => h + List.sum(t)
      case _ => 101
    }
    result
  }
}

object PatternMatching {
  def main(args: Array[String]): Unit = {
    val pm = new PatternMatchingPractice()
    val result = pm.matching()
    println(result)

    val list = Cons(1, Cons(2, Cons(3, Cons(4, Cons(5, Nil())))))

    val filteredList = List.dropWhile[Int](list, x => x < 3)
    println(filteredList)

    val sumResult = List.foldRight[Int, Int](list, 0, (x, y) => x + y)
    println(sumResult)

    val doubleList = List.foldRight[Int, List[Int]](list, Nil(), (x, y) => Cons(2 * x, y))

    println(doubleList)
    val reverse = List.foldLeft[Int, List[Int]](list, Nil(), (x, y) => Cons(y,x))
    println(reverse)
  }
}
