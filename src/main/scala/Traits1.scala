trait TFeline {
  def color: String

  def sound: String
}

trait TBigCat extends TFeline {
  val sound: String = "roar"
}

case class TCat(color: String, sound: String = "Meow", favoriteFood: String) extends TFeline

case class TLion(color: String, maneSize: Int) extends TBigCat

case class TTiger(color: String) extends TBigCat

case class TPanther(color: String) extends TBigCat


object Traits1 {
  def main(args: Array[String]): Unit = {

  }
}
