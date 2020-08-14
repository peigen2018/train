package com.pg.scala.traits

import java.util
 class xx[T](list: util.LinkedList[T]) {
  def foreach2(f: (T) => Unit): Unit = {
    val iter: util.Iterator[T] = list.iterator()
    while (iter.hasNext) {
      f(iter.next())
    }
  }
}
object ImplicitDemo {
  def main(args: Array[String]): Unit = {
    var list = new util.LinkedList[Int]()

    list.add(1)
    list.add(2)
    list.add(3)

    implicit def x[T](list: util.LinkedList[T])={
      new xx(list)
    }

    list.foreach2(println)
    //隐式转换方法
    //隐式转换类
    //隐式转换参数
  }
}

