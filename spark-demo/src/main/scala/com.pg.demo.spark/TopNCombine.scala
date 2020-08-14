package com.pg.demo.spark

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable

object TopNCombine {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("topn combine").setMaster("local")

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
    }).combineByKey(
      (v:(Int,Int))=>{
        Array(v,(0,0),(0,0))
      },
      (oldValue:Array[(Int,Int)],newValue:(Int,Int))=>{
        if(oldValue(0)._2 < newValue._2){

        }
      }
    )


  }
}
