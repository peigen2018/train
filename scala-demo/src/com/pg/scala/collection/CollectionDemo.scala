package com.pg.scala.collection

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object CollectionDemo {

  def main(args: Array[String]): Unit = {
    val arr = Array[Int](1, 2, 3, 4)

    println(arr(2))

    for (elem <- arr) {
      println(elem)
    }

    println("------------------------------")


    arr.foreach(println)

    val list01 = List(1, 2, 3, 4)
    list01.foreach(println)

    println("------------------------------")

    val list02 = ListBuffer(1, 2, 3, 4, 5)

    list02.addOne(6)

    list02.+=(3);
    //++ +=: :++
    list02.foreach(println)
    println("------------------------------")
    var set01: Set[Int] = Set(1, 3, 4, 5, 6)
    set01.foreach(println)
    println("------------------------------")

    var set02 = mutable.Set(1, 2, 3)
    set02.+=(4);
    set02.foreach(println)
    println("------------------------------")

    val tuple2 = Tuple2(1, "b")
    val tuple3 = Tuple3(1, "b", true)
    //22个

    val tuple6 = (1, 2, 3, 4, 5, true)

    println(tuple2._2)
    println(tuple3._3)

    println("--------------map----------------")

    val value = Map(("k1", 1), "k2" -> 2, ("k3", 3), ("k4", 4))
    val keys = value.keys
    println(keys)
    println(value.get("k1"))
    println(value.getOrElse("k1",0))
  }
}
