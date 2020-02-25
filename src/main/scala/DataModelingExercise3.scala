import java.util.Date

sealed trait DMVisitor {
  def id: String

  def createdAt: Date

  def age: Long = new Date().getTime - createdAt.getTime
}

final case class DMAnonymous(id: String, createdAt: Date = new Date()) extends DMVisitor

final case class DMUser(id: String, createdAt: Date = new Date(), email: String) extends DMVisitor

object DMEmailService {
  def send(emailSettings: String, visitor: DMVisitor) = visitor match {
    case DMUser(id, date, email) => println(s"Sending email to $email for user $id")
    case DMAnonymous(id, date) => println("Can not Send Email")
  }
}

object DataModelingExercise3 {
  def main(args: Array[String]): Unit = {
    val user1 = DMUser("user1", new Date(), "abc@gmail.com")
    val visitor1 = DMAnonymous("visitor1", new Date())

    DMEmailService.send("emailSettings", visitor1)
    DMEmailService.send("emailSettings", user1)
  }
}
