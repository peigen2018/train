package com.pg.demo.spark

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Combine {

  def main(args: Array[String]): Unit = {

    val context = new SparkContext(new SparkConf().setAppName("combine").setMaster("local"))
    context.setLogLevel("ERROR")


    val data: RDD[(String, Double)] = context.parallelize(
      List(
        ("xiaomi", 99.2)
        , ("xiaomi", 88.2)
        , ("vivo", 78.2)
        , ("vivo", 98.2)
        , ("vivo", 97.2)
        , ("vivo", 96.2)
        , ("vivo", 95.2)
        , ("huawei", 100.2)
        , ("huawei", 95.2)
      ))

    val countByKey = data.map(x => (x._1, 1)).reduceByKey(_ + _);
    countByKey.foreach(println)
    val max = data.reduceByKey((o, n) => {
      if (o > n) o else n
    })
    max.foreach(println)

    val min = data.reduceByKey((o, n) => {
      if (o < n) o else n
    })
    min.foreach(println)

    val sum = data.reduceByKey((o, n) => {
      o + n
    })
    sum.foreach(println)

    val avg = sum.join(countByKey).map(x => {
      (x._1, x._2._1 / x._2._2)
    }).foreach(println)

    println("------------------------")


    val avgCombine: RDD[(String, (Double, Int))] = data.combineByKey(
      value => (value, 1),
      (oldvalue: (Double, Int), newValue: Double) => (oldvalue._1 + newValue, oldvalue._2 + 1),
      (v1: (Double, Int), v2: (Double, Int)) => (v1._1 + v2._1, v1._2 + v2._2)
    )

    avgCombine.mapValues(x =>  x._1 / x._2).foreach(println)
  }
}
