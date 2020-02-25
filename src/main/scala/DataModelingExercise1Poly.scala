sealed trait DMPTrafficSignal {
  def next: DMPTrafficSignal
}

case object DMPRedSignal extends DMPTrafficSignal {
  def next = DMPGreenSignal
}

case object DMPGreenSignal extends DMPTrafficSignal {
  def next = DMPYellowSignal
}

case object DMPYellowSignal extends DMPTrafficSignal {
  def next = DMPRedSignal
}

object DataModelingExercise1Poly {
  def main(args: Array[String]): Unit = {
    val red = DMPRedSignal
    val green = DMPGreenSignal
    val yellow = DMPYellowSignal
    println(s"Red Next - ${red.next}")
    println(s"Green Next - ${green.next}")
    println(s"Yellow Next - ${yellow.next}")
  }
}
