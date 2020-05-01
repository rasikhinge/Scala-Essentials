package typeclasses.jsonConverter

import java.util.Date
import typeclasses.jsonConverter.JsConverterClass.JsUtils
import typeclasses.jsonConverter.jswriter.VisitorWriter.VisitorJsWriter

sealed trait JsValue {
  def stringify: String
}

final case class JsObject(values: Map[String, JsValue]) extends JsValue {
  override def stringify: String = {
    values.map {
      case (name, value: JsValue) => "\"" + name + "\"" + ":" + "\"" + value.stringify
    }.mkString("{", ", ", "}")
  }
}

final case class JsString(value: String) extends JsValue {
  def stringify: String = value.replaceAll("\\|\"", "\\\\$1") + "\""
}

trait JsWriter[A] {
  def write(value: A): JsValue
}

object JsConverterClass {

  implicit class JsUtils[A](value: A) {
    def toJson(implicit jsWriter: JsWriter[A]): JsValue =
      jsWriter.write(value)
  }

}

object JsonConverter {
  def main(args: Array[String]): Unit = {
    val obj = JsObject(Map("foo" -> JsString("a"), "bar" -> JsString("b"), "bazz" -> JsString("c")))
    val jsString = obj.stringify
    println(jsString)

    val seq: Seq[Visitor] = Seq(Ananymous("001", new Date), User("002", new Date(), "abcd@gmail.com"))
    val values = seq.map(v => v.toJson.stringify)
    println(values)
  }
}
