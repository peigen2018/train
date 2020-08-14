package com.pg.demo.spark

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

import scala.collection.mutable

object TopN {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("topn").setMaster("local")

    val context = new SparkContext(conf)
    context.setLogLevel("ERROR")
    val fileRdd: RDD[String] = context.textFile("data/topN.txt")

    val tp: RDD[(Int, Int, Int, Int)] = fileRdd.map(line => {
      val strings = line.split(" ")
      var date = strings(0).split("-")
      (date(0).toInt, date(1).toInt, date(2).toInt, strings(1).toInt)
    })


    val groupedData = tp.map(t => {
      ((t._1, t._2), (t._3, t._4))
    }).groupByKey()

    val res = groupedData.mapValues(arr => {
      val map = new mutable.HashMap[Int, Int]()

      arr.foreach(x => {
        if (map.getOrElse(x._1, 0) < x._2) {
          map.put(x._1, x._2)
        }
      })

      map.toList.sorted(new Ordering[(Int, Int)] {
        override def compare(x: (Int, Int), y: (Int, Int)): Int = y._2.compareTo(x._2)
      })
    })


    res.foreach(println)
  }
}
