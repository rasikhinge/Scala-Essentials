package collections

import scala.util.Try

object Exercise5 {
  def main(args: Array[String]): Unit = {
    val opt1 = Some(1)
    val opt2 = Some(2)
    val opt3 = Some(3)
    val optResult = for {
      op1 <- opt1
      op2 <- opt2
      op3 <- opt3
    } yield op1 + op2 + op3
    println(optResult)

    val seq1 = Seq(1)
    val seq2 = Seq(2)
    val seq3 = Seq(3)
    val seqResult = for {
      ele1 <- seq1
      ele2 <- seq2
      ele3 <- seq3
    } yield ele1 + ele2 + ele3
    println(seqResult)

    val try1 = Try(1)
    val try2 = Try(2)
    val try3 = Try(3)
    val tryResult = for {
      t1 <- try1
      t2 <- try2
      t3 <- try3
    } yield t1 + t2 + t3
    println(tryResult)
  }
}
