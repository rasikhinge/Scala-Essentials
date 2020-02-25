sealed trait TrafficSignal
final case class TSRed() extends TrafficSignal
final case class TSGreen() extends TrafficSignal
final case class TSYellow() extends TrafficSignal

sealed trait CalcResult
final case class Succeed(result:Int) extends CalcResult
final case class Failed(message:String) extends CalcResult

sealed trait WaterBottleSource
final case class Well() extends WaterBottleSource
final case class Spring() extends WaterBottleSource
final case class Tap() extends WaterBottleSource

case class WaterBottle(size:Int, source:WaterBottleSource, carbonated:Boolean)

object ExerciseTrait4{
  def main(args: Array[String]): Unit = {

  }
}
