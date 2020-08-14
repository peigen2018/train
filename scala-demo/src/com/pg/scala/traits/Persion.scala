package com.pg.scala.traits

trait Man{
  def haha(): Int ={
    return 0;
  }
}
trait Woman{
  def wuwu(): Int ={
    return 1;
  }
}
class Persion extends Man with Woman {


}

object Persion{
  def main(args: Array[String]): Unit = {
    var ps = new Persion();
    ps.haha()
    ps.wuwu()

  }
}