package io.muic.scandas.core

import scala.math


object Util {

  def checkDim(ar1: Seq[Any], ar2: Seq[Any]) ={
    import ScException.DiffDimException
    if (ar1.size != ar2.size) throw new DiffDimException
  }

  def eltOpsEx[T](ops: (Double,Double) => Double, ar1: Vector[T], ar2: Vector[T])
                 (implicit num: Numeric[T]): Vector[Double] ={
    val n = math.min(ar1.size, ar2.size)
    val res = (0 until n).map(i => {
      val aops = num.mkNumericOps(ar1(i)).toDouble()
      val bops = num.mkNumericOps(ar2(i)).toDouble()
      ops(aops, bops)
    })
    val nm = math.max(ar1.size, ar2.size)
    val nres = (0 until nm-n).map(i => Double.NaN)
    (res ++ nres).toVector
  }


}
