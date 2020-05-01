package typeclasses.jsonConverter.jswriter

import java.util.Date

import typeclasses.jsonConverter.jswriter.AnanymousWriter.AnanymousJsWriter
import typeclasses.jsonConverter.jswriter.UserWriter.UserJsWriter
import typeclasses.jsonConverter.{Ananymous, JsObject, JsString, JsValue, JsWriter, User, Visitor}
import typeclasses.jsonConverter.JsConverterClass._
import typeclasses.jsonConverter.jswriter.StringWriter.StringJsWriter
import typeclasses.jsonConverter.jswriter.DateWriter.DateJsWriter

object StringWriter {
  implicit object StringJsWriter extends JsWriter[String]  {
    def write(value:String):JsValue = JsString(value)
  }
}

object DateWriter {
  implicit object DateJsWriter extends JsWriter[Date]  {
    def write(value:Date):JsValue = JsString(value.toString)
  }
}


object UserWriter {

  implicit object UserJsWriter extends JsWriter[User] {
    override def write(value: User): JsValue = {
      JsObject(
        Map(
          "id" -> value.id.toJson,
          "email" -> value.email.toJson,
          "createdAt" -> value.createdAt.toJson
        )
      )

    }
  }

}


object AnanymousWriter {

  implicit object AnanymousJsWriter extends JsWriter[Ananymous] {
    def write(value: Ananymous): JsValue = {
      JsObject(
        Map(
          "id" -> value.id.toJson,
          "createdAt" -> value.createdAt.toJson
        )
      )
    }
  }

}

object VisitorWriter {

  implicit object VisitorJsWriter extends JsWriter[Visitor] {
    def write(value: Visitor): JsValue = {
      value match {
        case v: User => v.toJson
        case v: Ananymous => v.toJson
      }
    }
  }

}
