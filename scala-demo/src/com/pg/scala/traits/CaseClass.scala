package com.pg.scala.traits

class Question(name: String) {

}

case class Question01(name: String) {

}

object CaseClass {

  def main(args: Array[String]): Unit = {
    var q = new Question("q1")
    var q2 = new Question("q1")


    println(q.equals(q2))
    println(q == q2)

    var q3 = new Question01("q1")
    var q4 = new Question01("q1")

    println(q3.equals(q4))
    println(q3 == q4)
  }



}
