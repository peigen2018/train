package com.pg.scala.loop

import scala.collection.immutable

object LoopDemo {
  def main(args: Array[String]): Unit = {
    var i = 0
    while (i < 10) {
      i += 1
      println(i)
    }

    var seqs = 2 until(10, 1)
    println(seqs)

    for (i <- seqs) {
      println(i)
    }

    println("---------------------------------")
    for (i <- seqs if (i % 2 == 0)) {
      println(i)
    }
    println("---------------------------------")
    for (i <- 1 to 9) {
      for (j <- 1 to i) {
        print(s"$j * $i = ${i * j}\t")
        if (i == j) {
          println()
        }
      }
    }

    println("---------------------------------")
    for (i <- 1 to 9; j <- 1 to i if (i != 1)) {
      print(s"$j * $i = ${i * j}\t")
      if (i == j) {
        println()
      }
    }
    println("---------------------------------")
    var seqa: immutable.IndexedSeq[Int] = for (i <- 1 to 10) yield {
      var x = 8
      x + i
    }
    for (i <- seqa) {
      println(i)
    }

    println("---------------------------------")


  }
}
