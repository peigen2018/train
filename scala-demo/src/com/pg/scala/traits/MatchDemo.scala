package com.pg.scala.traits

object MatchDemo {

  def main(args: Array[String]): Unit = {
    val tuple = (1.0, 23, "string", true, 0.72)

    val iterator = tuple.productIterator

    var res = iterator.map(x => {
      x match {
        case Int => println(s"$x Int")
        case 23 => println(s"$x 23 ")
        case w:String if w.equals("string") => println(s"$x string ")
        case true => println(s"$x true ")
        case _=> println(s"$x true ")
      }
    })

    while (res.hasNext){
      println(res.next())
    }
  }
}
