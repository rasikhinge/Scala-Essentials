sealed trait DMTrafficSignal {
  def next: DMTrafficSignal = this match {
    case DMRedSignal => DMGreenSignal
    case DMGreenSignal => DMYellowSignal
    case DMYellowSignal => DMRedSignal
  }
}

case object DMRedSignal extends DMTrafficSignal

case object DMGreenSignal extends DMTrafficSignal

case object DMYellowSignal extends DMTrafficSignal

object DataModelingExercise1 {
  def main(args: Array[String]): Unit = {
    val red = DMRedSignal
    val green = DMGreenSignal
    val yellow = DMYellowSignal
    println(s"Red Next - ${red.next}")
    println(s"Green Next - ${green.next}")
    println(s"Yellow Next - ${yellow.next}")
  }
}
