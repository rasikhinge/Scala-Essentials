sealed trait DFeline {
  def pDinner: DFood

  def ptDinner: DFood = this match {
    case DLion() => DAntelope
    case DTiger() => DTigerFood
    case DPanther() => DLicorice
    case DCat(food) => DCatFood(food)
  }
}

final case class DLion() extends DFeline {
  def pDinner: DFood = DAntelope
}

final case class DTiger() extends DFeline {
  def pDinner: DFood = DTigerFood
}

final case class DPanther() extends DFeline {
  def pDinner: DFood = DLicorice
}

final case class DCat(favoriteFood: String) extends DFeline {
  def pDinner = DCatFood(favoriteFood)
}

sealed trait DFood

case object DAntelope extends DFood

case object DTigerFood extends DFood

case object DLicorice extends DFood

case class DCatFood(food: String) extends DFood

object Dinner {
  def dinner(feline: DFeline): DFood = feline match {
    case DLion() => DAntelope
    case DTiger() => DTigerFood
    case DPanther() => DLicorice
    case DCat(food) => DCatFood(food)
  }
}


object DataModeling1 {
  def main(args: Array[String]): Unit = {
    val lion = DLion()
    val tiger = DTiger()
    val panther = DPanther()
    val cat = DCat("Chips")
    println("==========Polymorphic==============")
    println(lion.pDinner)
    println(tiger.pDinner)
    println(panther.pDinner)
    println(cat.pDinner)
    println("================Base Trait Method Pattern Matching==================")
    println(lion.ptDinner)
    println(tiger.ptDinner)
    println(panther.ptDinner)
    println(cat.ptDinner)
    println("================External Object Method Pattern Matching==================")
    println(Dinner.dinner(lion))
    println(Dinner.dinner(tiger))
    println(Dinner.dinner(panther))
    println(Dinner.dinner(cat))

  }
}
