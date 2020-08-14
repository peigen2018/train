package com.pg.scala.demo

object SameObjAndClass {
  private var text = "hello"

  def main(args: Array[String]): Unit = {
    val clazz = new SameObjAndClass();
    clazz.printer()
  }
}

class SameObjAndClass{
  def printer(): Unit ={
    //因为伴生所以可以访问到object中的私有属性
    println(SameObjAndClass.text)
  }
}
