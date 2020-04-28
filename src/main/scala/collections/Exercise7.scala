package collections

case class Distribution[A](list: List[(A, Double)])

object Distribution {
  def uniform[A](atoms: List[A]): Distribution[A] = {
    val uniformProbability = 1.0 / atoms.size
    Distribution(atoms.map(a => a -> uniformProbability))
  }
}

object Exercise7 {
  def main(args: Array[String]): Unit = {
    val subjects = List("Noel", "The cat", "The dog")
    val verbs = List("wrote", "chased", "slept on")
    val objects = List("the book", "the ball", "the bed")
    for {
      sub <- subjects
      verb <- verbs
      obj <- objects
    } println(sub + " " + verb + " " + obj)
  }
}
