package com.pg.scala.func

import java.util.Date

object FunctionDemo {
  def main(args: Array[String]): Unit = {
    println("-------------------------------------------")

    def func01(): Unit = {
      println("hello world")
    }

    func01()
    var func01Var = func01();
    println(func01Var)


    println("-------------------------------------------")

    def func02(): String = {
      "hello world2"
    }

    var func02Var = func02();
    println(func02Var)

    println("-------------------------------------------")

    //函数参数 为值引用 一定不可用使用var
    def func03(a: Int): Int = {
      a
    }

    var func03Var = func03(3);
    println(func03Var)


    println("-------------------------------------------")

    //函数参数 为值引用 一定不可用使用var
    def func04(a: Int): Int = {
      println(s"print $a")
      if (a == 5) {
        a
      } else {
        func04(a + 1)
      }
    }

    var func04Var = func04(3);
    println(func04Var)


    println("-------------------------------------------")

    //函数可以有默认值
    def func05(a: Int = 7, b: String = "hello") {
      println(s"$b $a")

    }

    func05()

    func05(b = "world")

    println("-------------------------------------------")
    //匿名函数
    var func06 = (c: Int, d: Int) => {
      c + d
    }

    val r: Int = func06(8, 2)

    println(r)


    println("-------------------------------------------")
    //签名 参数列表  ()=> 返回值
    var func07: (Int, Int) => Int = (c: Int, d: Int) => {
      c + d
    }


    println("-------------------------------------------")
    var func08: (Int, Int, Date) => Int = (c: Int, d: Int, dt: Date) => {
      println(dt)
      c + d
    }
    //偏应用函数
    //可以定义一些参数值
    var func08Ex = func08(1, _: Int, new Date())

    println(func08Ex(2))


    println("-------------------------------------------")

    //超级语法糖
    def func09(a: Int*): Unit = {
      for (i <- a) {
        println(i)
      }
      println("-------------------------------------------")
      a.foreach((x: Int) => {
        println(x)
      })

      println("-------------------------------------------")
      a.foreach(println(_))
      println("-------------------------------------------")
      a.foreach(println)
    }

    func09(1)
    func09(1, 2, 3)

    //高阶函数

    def func10(num1: Int, num2: Int, f: (Int, Int) => Int): Int = {
      f(num1, num2)
    }


    val i = func10(2, 4, (a, b) => {
      a + b
    })
    val d = func10(2, 4, _ * _)
    println(i)
    println(d)


    def funcFac(f: String): (Int, Int) => Int = {
      def plus(a: Int, b: Int): Int = {
        a + b
      }

      def m(a: Int, b: Int): Int = {
        a - b
      }

      if (f.equals("+")) {
        plus
      } else {
        m
      }
    }


    val as = func10(2, 4, funcFac("-"))
  }
}
