package com.pg.scala.traits

object ParialFunctionDemo {

  def dm:PartialFunction[Any,String]={
    case "1" => "print 1"
    case x:Int => s"print $x int"
    case _=> "..... "
  }

  def main(args: Array[String]): Unit = {
    println(dm("1"))
    println(dm(1))

  }
}
