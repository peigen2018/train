package com.pg.demo.spark

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

object PartitionDemo {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("partition").setMaster("local")

    val context = new SparkContext(conf)
    context.setLogLevel("ERROR")


    val data: RDD[(Int)] = context.parallelize(1 to 10, 2)

    data.map(x => {
      println("connect")
      println(x + " select")

      x
    }).foreach(println)

    println("-------mapPartitionsWithIndex-----------------")
    data.mapPartitionsWithIndex((partNo, parsedValue) => new Iterator[String] {
      println(s"partNo:${partNo} connect")

      override def hasNext: Boolean = {
        if (!parsedValue.hasNext) {
          println(s"partNo:${partNo} close")
        }
        parsedValue.hasNext
      }

      override def next(): String = parsedValue.next() + "select"
    }).foreach(println)





        println("----------rand number------------")
        data.sample(true,0.1,222).foreach(println)
        println("----------------------")
        data.sample(true,0.1,222).foreach(println)
        println("----------------------")
        data.sample(false,0.1,221).foreach(println)

    println(s"data:${data.getNumPartitions}")

    val data1: RDD[(Int, Int)] = data.mapPartitionsWithIndex(
      (pi, pt) => {
        pt.map(e => (pi, e))
      }
    )


    val repartition: RDD[(Int, Int)] = data1.coalesce(3,false)

    val res: RDD[(Int, (Int, Int))] = repartition.mapPartitionsWithIndex(
      (pi, pt) => {
        pt.map(e => (pi, e))
      }

    )

    println(s"data:${res.getNumPartitions}")


    data1.foreach(println)
    println("---------------")
    res.foreach(println)



  }
}
