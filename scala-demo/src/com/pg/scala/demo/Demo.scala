package com.pg.scala.demo

object Demo {
  var objName ="demo"

  println("demo before")
  def main(args: Array[String]): Unit = {
    val printer = new Printer("baba")
    val num:Int = 4;

    println(s"hello ${num + 8}")
    printer.prin();
    println("hello world")

  }
  println("demo after")
}

class Printer(name:String){
  var text = "world";
  def  this(text:String,name:String){
    this(name);
    this.text = text;
  }
  println(" class before")
  def prin(): Unit ={
    println(s"hello ${Demo.objName}")
    println(s"hello $text")
  }
  println(" class after")
}