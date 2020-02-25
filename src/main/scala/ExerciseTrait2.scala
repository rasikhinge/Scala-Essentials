sealed trait TShape {
  def sides: Int

  def perimeter: Double

  def area: Double

  def color: TColor
}

trait TRectangular extends TShape {
  val sides: Int = 4

  def width: Double

  def height: Double

  override def perimeter: Double = 2 * width + 2 * height

  override def area: Double = width * height
}

case class TCircle(radius: Double, color: TColor) extends TShape {
  val sides: Int = 1

  def perimeter: Double = 2 * radius * math.Pi

  def area: Double = math.Pi * radius * radius
}

case class TRectangle(width: Double, height: Double, color: TColor) extends TRectangular

case class TSquare(side: Double, color: TColor) extends TRectangular {
  val width: Double = side
  val height: Double = side
}

sealed trait TColor {
  def R: Int

  def G: Int

  def B: Int
}

sealed trait TLightColor extends TColor

sealed trait TDarkColor extends TColor

final case class MyLightColor(R: Int, G: Int, B: Int) extends TLightColor

final case class MyDarkColor(R: Int, G: Int, B: Int) extends TDarkColor

final case class TRed() extends TDarkColor {
  val R = 255
  val G = 0
  val B = 0
}

final case class TYellow() extends TLightColor {
  val R = 0
  val G = 255
  val B = 255
}

final case class TPink() extends TLightColor {
  val R = 255
  val G = 255
  val B = 0
}

object Draw {
  def apply(shape: TShape): Unit = shape match {
    case TCircle(radius, color) => println(s"A Circle of radius $radius of color ${identifyColor(color)}")
    case TSquare(side, color) => println(s"A Square of side $side of color ${identifyColor(color)}")
    case TRectangle(width, height, color) => println(s"A Rectangle of width $width and height $height of color ${identifyColor(color)}")
  }

  def identifyColor(color: TColor): String = color match {
    case TRed() => "Red"
    case TYellow() => "Yellow"
    case TPink() => "Pink"
    case MyLightColor(_, _, _) => "Light Color"
    case MyDarkColor(_, _, _) => "Dark Color"
  }

}

object ExerciseTrait2 {
  def calculateArea(shape: TShape): Double = shape match {
    case TCircle(_, color) => {
      println(s"Printing Area of Circle of color $color")
      shape.area
    }
    case TSquare(_, color) => {
      println(s"Printing area of Square of color $color")
      shape.area
    }
    case TRectangle(_, _, color) => {
      println(s"Printing area of Rectangle of color $color")
      shape.area
    }
  }


  def main(args: Array[String]): Unit = {
    val circle = TCircle(4, TRed())
    val square = TSquare(4, TPink())
    val rectangle = TRectangle(4, 5, TYellow())
    val myBlue = MyDarkColor(0, 0, 255)
    val myGreen = MyLightColor(0, 255, 0)
    val circle2 = TCircle(5, myBlue)
    val square2 = TSquare(5, myGreen)
    println(calculateArea(circle))
    println(calculateArea(square))
    println(calculateArea(rectangle))
    Draw(circle)
    Draw(square)
    Draw(rectangle)
    Draw(circle2)
    Draw(square2)
  }
}
