package io.muic.scandas.core

class Series[T](data: Seq[T])(implicit num: Numeric[T]) {
  val gData = data.toVector
  def abs: Series[T] = new Series[T](gData.map(x => {
    val ops = num.mkNumericOps(x)
    ops.abs()
  }))

  import io.muic.scandas.core.Util._

  def +(that: Series[T]): Series[T] = {
    checkDim(gData, that.toVector)
    val res = (0 until gData.size).map(i => {
      val aops = num.mkNumericOps(gData(i))
      aops + that.toVector(i)
    })
    new Series(res)
  }

  def -(that: Series[T]): Series[T] = {
    checkDim(gData, that.toVector)
    val res = (0 until gData.size).map(i => {
      val aops = num.mkNumericOps(gData(i))
      aops + that.toVector(i)
    })
    new Series(res)
  }

  def *(that: Series[T]): Series[T] = ???

  def /(that: Series[T]): Series[T] = ???
  
  def toVector = gData


}
