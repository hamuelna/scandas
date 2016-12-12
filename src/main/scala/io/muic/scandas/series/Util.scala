package io.muic.scandas.series

object Util {
  /// compare Double
  def compNum(a: Vector[Double], b: Vector[Double],
              ops: (Double, Double) => Boolean) = a.zip(b).map(x => ops(x._1, x._2))
  def compNumOne(a: Vector[Double], b: Double,
                ops: (Double, Double) => Boolean) = a.map(x =>  ops(x,b))
  def opsNum(a: Vector[Double], b: Vector[Double],
             ops: (Double, Double) => Double) = a.zip(b).map(x => ops(x._1, x._2))
  def opsNumOne(a: Vector[Double], b: Double,
                ops: (Double, Double) => Double) = a.map(x => ops(x,b))

  // int and double
  def compNumID(a: Vector[Int], b: Vector[Double],
              ops: (Int, Double) => Boolean) = a.zip(b).map(x => ops(x._1, x._2))
  def compNumDI(a: Vector[Double], b: Vector[Int],
                    ops: (Double, Int) => Boolean) = a.zip(b).map(x => ops(x._1, x._2))
  def compNumOneID(a: Vector[Int], b: Double,
                 ops: (Int, Double) => Boolean) = a.map(x =>  ops(x,b))
  def compNumOneDI(a: Vector[Double], b: Int,
                ops: (Double, Int) => Boolean) = a.map(x =>  ops(x,b))
  def opsNumID(a: Vector[Int], b: Vector[Double],
             ops: (Int, Double) => Double) = a.zip(b).map(x => ops(x._1, x._2))
  def opsNumDI(a: Vector[Double], b: Vector[Int],
             ops: (Double, Int) => Double) = a.zip(b).map(x => ops(x._1, x._2))
  def opsNumOneID(a: Vector[Int], b: Double,
                ops: (Int, Double) => Double) = a.map(x => ops(x,b))
  def opsNumOneDI(a: Vector[Double], b: Int,
                ops: (Double, Int) => Double) = a.map(x => ops(x,b))

  /// compare Int
  def compInt(a: Vector[Int], b: Vector[Int],
              ops: (Int, Int) => Boolean) = a.zip(b).map(x => ops(x._1, x._2))
  def compIntOne(a: Vector[Int], b: Int,
                 ops: (Int, Int) => Boolean) = a.map(x => ops(x,b))
  def opsInt(a: Vector[Int], b: Vector[Int],
             ops: (Int, Int) => Int) = a.zip(b).map(x => ops(x._1, x._2))
  def opsIntOne(a: Vector[Int], b: Int,
                ops: (Int, Int) => Int) = a.map(x => ops(x,b))
  def opsIntDiv(a: Vector[Int], b: Vector[Int],
             ops: (Int, Int) => Double) = a.zip(b).map(x => ops(x._1, x._2))
  def opsIntOneDiv(a: Vector[Int], b: Int,
                ops: (Int, Int) => Double) = a.map(x => ops(x,b))

  // compare String
  def compSt(a: Vector[String], b: Vector[String],
             ops: (String, String) => Boolean) = a.zip(b).map(x => ops(x._1,x._2))
  def compStOne(a: Vector[String], b: String,
                ops: (String, String) => Boolean) = a.map(x => ops(x,b))
  def opsSt(a: Vector[String], b: Vector[String],
            ops: (String, String) => String) = a.zip(b).map(x => ops(x._1,x._2))
  def opsStOne(a: Vector[String], b: String,
               ops: (String, String) => String) = a.map(x => ops(x,b))

}
