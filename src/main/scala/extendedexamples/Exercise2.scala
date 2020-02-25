package extendedexamples


sealed trait Json {
  def print(): String = {
    this match {
      case JsonString(v) => s"""$v"""
      case JsonDouble(v) => v.toString
      case JsonBoolean(v) => v.toString
      case json: JsonArray => "[" ++ json.printArray() ++ "]"
      case json: JsonObject => "{" ++ json.print() ++ "}"
    }
  }
}

case class JsonString(value: String) extends Json

case class JsonDouble(value: Double) extends Json

case class JsonBoolean(value: Boolean) extends Json

case class JNull() extends Json

sealed trait JsonArray extends Json {
   def printArray(): String = {
    this match {
      case JArrayElement(head, tail) => head.print() + ", " + tail.print()
      case JArrayEnd() => ""
    }
  }
}

case class JArrayElement(head: Json, tail: JsonArray) extends JsonArray

case class JArrayEnd() extends JsonArray

sealed trait JsonObject extends Json {
   def printObject(): String = {
    this match {
      case JsonObjectElement(key, value, tail) =>  s"""$key""" + ":" + s"""$value""" + tail.print()
      case JsonObjectEnd() => " "
    }
  }
}

case class JsonObjectElement(key: String, value: Json, tail: JsonObject) extends JsonObject

case class JsonObjectEnd() extends JsonObject

/*

* json :  jsonString  value: String
        | jsonInt value:Double
        | jsonBoolean value:Boolean
jsonObject :   jsonObjectElement key: String  value : json tail : jsonObject
            | jsonObjectEnd
jsonArray :  jsonArrayElement head :json , tail: jsonArray
            | JArrayEnd : jsonArray


*/

object Exercise2 {
  def main(args: Array[String]): Unit = {
    val str = JArrayElement(JsonString("a string"), JArrayElement(JsonDouble(1.0), JArrayElement(JsonBoolean(true), JArrayEnd()))).print()
    println(str)
  }
}
