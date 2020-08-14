package com.pg.demo.spark

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object WordCountScala {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
    conf.setAppName("wordcount")
    conf.setMaster("local")

    val context = new SparkContext(conf)
    val fileRdd: RDD[String] = context.textFile("data/data.txt")

    val words: RDD[String] = fileRdd.flatMap((x: String) => {
      x.split(" ")
    })

    val parWord: RDD[(String, Int)] = words.map((x1: String) => {
      new Tuple2(x1, 1)
    })

    val res = parWord.reduceByKey((x: Int, y: Int) => {
      x + y
    })

    val revertMap = res.map((x) => {
      (x._2, 1)
    })

    val revertRes = revertMap.reduceByKey(_ + _)
    revertRes.foreach(println)
    res.foreach(println)
    Thread.sleep(Long.MaxValue)
  }
}
