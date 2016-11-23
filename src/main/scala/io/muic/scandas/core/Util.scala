package io.muic.scandas.core

import scala.reflect.{ClassTag, classTag}


object Util {



  def checkDim(ar1: Seq[_], ar2: Seq[_]) ={
    import ScException.DiffDimException
    if (ar1.size != ar2.size) throw new DiffDimException
  }

  def matchVec[A : ClassTag](vec: Seq[A]) = vec match {
    case intSeq: Seq[Int @unchecked] if classTag[A] == classTag[Int] => true
    case _ => false
  }

  def pairMatch(a1: Seq[_], a2: Seq[_]) = matchVec(a1) && matchVec(a2)


  def eltOpsEx[T,K](ops: (Double,Double) => Double, ar1: Vector[T], ar2: Vector[K])
                   (aNum: Numeric[T], bNum: Numeric[K]): Vector[Double] ={
    val n = math.min(ar1.size, ar2.size)
    val res = (0 until n).map(i => {
      val aops = aNum.mkNumericOps(ar1(i)).toDouble()
      val bops = bNum.mkNumericOps(ar2(i)).toDouble()
      ops(aops, bops)
    })
    val nm = math.max(ar1.size, ar2.size)
    val nres = (0 until nm-n).map(i => Double.NaN)
    (res ++ nres).toVector
  }


}
