package com.pg.demo.spark

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object SortTopN {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("sortTopN").setMaster("local")

    val context = new SparkContext(conf)
    context.setLogLevel("ERROR")
    val fileRdd: RDD[String] = context.textFile("data/domain.txt")

    val mapRdd = fileRdd.map(line => {
      val columns = line.split(" ")
      (columns(1), 1)
    })


    val reduceRdd = mapRdd.reduceByKey(_ + _)
    reduceRdd.foreach(println)

    val swapRdd = reduceRdd.map(_.swap).sortByKey(false)
    val top3: Array[(String, Int)] = swapRdd.map(_.swap).take(3)
    top3.foreach(println)



    val uvRDD = fileRdd.map(line => {
      val columns = line.split(" ")
      (columns(1), columns(0))
    })

    val distinct = uvRDD.distinct()

    val uv = distinct.map(x => (x._1, 1)).reduceByKey(_ + _)

    uv.foreach(println)
  }
}
