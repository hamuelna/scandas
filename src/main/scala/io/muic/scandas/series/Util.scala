package io.muic.scandas.series

object Util {
  def compNum(a: Vector[Double], b: Vector[Double],
              ops: (Double, Double) => Boolean) = a.zip(b).map(x => ops(x._1, x._2))
  def compNumOne(a: Vector[Double], b: Double,
                ops: (Double, Double) => Boolean) = a.map(x =>  ops(x,b))
  def compSt(a: Vector[String], b: Vector[String],
    ops: (String, String) => Boolean) = a.zip(b).map(x => ops(x._1,x._2))
  def compStOne(a: Vector[String], b: String,
                ops: (String, String) => Boolean) = a.map(x =>  ops(x,b))
  def opsSt(a: Vector[String], b: Vector[String],
             ops: (String, String) => String) = a.zip(b).map(x => ops(x._1,x._2))
  def opsStOne(a: Vector[String], b: String,
                ops: (String, String) => String) = a.map(x =>  ops(x,b))
  def opsNum(a: Vector[Double], b: Vector[Double],
             ops: (Double, Double) => Double) = a.zip(b).map(x => ops(x._1, x._2))
  def opsNumOne(a: Vector[Double], b: Double,
                ops: (Double, Double) => Double) = a.map(x => ops(x,b))


}
