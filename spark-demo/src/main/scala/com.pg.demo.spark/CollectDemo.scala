package com.pg.demo.spark

import org.apache.spark.rdd.{ParallelCollectionRDD, RDD}
import org.apache.spark.{SparkConf, SparkContext}

object CollectDemo {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("collection").setMaster("local")

    val context = new SparkContext(conf)
    context.setLogLevel("ERROR")


    val rdd1 = context.parallelize(List(1, 2, 3, 4))
    val rdd2 = context.parallelize(List(3, 4, 5, 6))
    println("rdd1.partitions" + rdd1.partitions.size)
    val unionRdd = rdd1.union(rdd2);
    unionRdd.foreach(println)
    println("unionRdd.partitions" + unionRdd.partitions.size)

    println("----------------cartesian--------------------")
    val cartestionRdd = rdd1.cartesian(rdd2)
    cartestionRdd.foreach(println)

    println("----------------intersection--------------------")
    val intersectionRdd = rdd1.intersection(rdd2)
    intersectionRdd.foreach(println)


    println("------------------subtract------------------")
    val subtractRdd = rdd1.subtract(rdd2)
    subtractRdd.foreach(println)


    println("------------------cogroup------------------")
    val kv1: RDD[(String, Int)] = context.parallelize(List(("k1", 1), ("k1", 2), ("k3", 3), ("k4", 4)))
    val kv2: RDD[(String, Int)] = context.parallelize(List(("k1", 10), ("k2", 12), ("k3", 13), ("k4", 14)))
    val cogroup = kv1.cogroup(kv2)
    cogroup.foreach(println)

    println("------------------join------------------")
    val join: RDD[(String, (Int, Int))] = kv1.join(kv2)
    join.foreach(println)
    println("------------------leftOuterJoin------------------")
    val leftOuterJoin: RDD[(String, (Int, Option[Int]))] = kv1.leftOuterJoin(kv2)
    leftOuterJoin.foreach(println)
    println("------------------rightOuterJoin------------------")
    val rightOuterJoin = kv1.rightOuterJoin(kv2)
    rightOuterJoin.foreach(println)
    println("------------------fullOuterJoin------------------")
    val fullOuterJoin: RDD[(String, (Option[Int], Option[Int]))] = kv1.fullOuterJoin(kv2)
    fullOuterJoin.foreach(println)


    Thread.sleep(Long.MaxValue)


  }
}
