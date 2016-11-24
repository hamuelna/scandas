package io.muic.scandas.series

import io.muic.scandas.core.ScException.DiffDimException

class NumericSeries[+T](data: Seq[T])(implicit num: Numeric[T]) {
  val gData = data.toVector
  def abs: NumericSeries[T] = new NumericSeries[T](gData.map(x => {
    val ops = num.mkNumericOps(x)
    ops.abs()
  }))
  def toVector = gData
  def toSeq = gData.toSeq
  def size = gData.size

  import SeriesOpsUtil._


  def +[A](that: NumericSeries[A])(implicit thatNum: Numeric[A]) =
    eltOps(_+_, gData, that.toVector)(num, thatNum)
//  def +[A](that: A)(implicit thatNum: Numeric[A]) =
//    eltOpsSingle(_+_, gData, that)(num, thatNum)

  def -[A](that: NumericSeries[A])(implicit thatNum: Numeric[A]) =
    eltOps(_-_, gData, that.toVector)(num, thatNum)
//  def -[A](that: A)(implicit thatNum: Numeric[A]) =
//    eltOpsSingle(_-_, gData, that)(num, thatNum)


  def *[A](that: NumericSeries[A])(implicit thatNum: Numeric[A]) =
    eltOps(_*_, gData, that.toVector)(num, thatNum)
//  def *[A](that: A)(implicit thatNum: Numeric[A]) =
//    eltOpsSingle(_*_, gData, that)(num, thatNum)

  def /[A](that: NumericSeries[A])(implicit thatNum: Numeric[A]) : NumericSeries[Double] = {
    try{
      checkDim(gData, that.toVector)
      val res = eltOpsFrac(_/_, gData, that.toVector)(num, thatNum)
      new NumericSeries[Double](res)
    }catch {
      case DiffDimException(_,_) => {
        val res = eltOpsEx[T,A](_/_,gData, that.toVector)(num, thatNum)
        new NumericSeries[Double](res)
      }
      case _ => throw new Exception("Should not reach here")
    }
  }
//  def /[A](that: A)(implicit thatNum: Numeric[A]) =
//    eltOpsSingle(_/_, gData, that)(num, thatNum)

}
