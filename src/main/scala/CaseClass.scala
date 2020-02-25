case class CaseCat(color: String, food: String)

object CaseChipShop {
  def willServe(cat: CaseCat): Boolean = {
    cat match {
      case CaseCat(_, "Chips") => true
      case CaseCat(_, _) => false
    }
  }
}

object CaseClass {
  def main(args: Array[String]): Unit = {
    val oswald = CaseCat("Black", "Milk")
    val henderson = CaseCat("Ginger", "Chips")
    val quentin = CaseCat("Tabby and White", "Curry")

    println(oswald)
    println(henderson)
    println(quentin)
    println(CaseChipShop.willServe(oswald))
    println(CaseChipShop.willServe(henderson))
    println(CaseChipShop.willServe(quentin))
  }
}
