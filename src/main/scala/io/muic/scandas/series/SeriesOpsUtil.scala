package io.muic.scandas.series

import io.muic.scandas.core.ScException.DiffDimException

import scala.reflect.{ClassTag, classTag}


object SeriesOpsUtil {

  def checkDim(ar1: Seq[_], ar2: Seq[_]) ={
    if (ar1.size != ar2.size) throw new DiffDimException
  }

  def matchVec[A : ClassTag](vec: Seq[A]): Boolean = vec match {
    case intSeq: Seq[Int @unchecked] if classTag[A] == classTag[Int] => true
    case _ => false
  }

  def matchCon[A](con: A) = con match {
    case a:Int => true
    case _ => false
  }

  def pairMatch(a1: Seq[_], a2: Seq[_]) = matchVec(a1) && matchVec(a2)

  def eltOps[T,K](ops: (Double,Double) => Double, a1: Vector[T], a2: Vector[K])
                    (aNum: Numeric[T], bNum: Numeric[K]) = {
    try {
      checkDim(a1, a2)
      if (pairMatch(a1, a2)){
        val res = eltOpsInt(ops, a1, a2)(aNum, bNum)
        new NumericSeries(res)
      } else {
        val res = eltOpsFrac(ops , a1, a2)(aNum, bNum)
        new NumericSeries(res)
      }
    }catch {
      case DiffDimException(_,_) => {
        val res = eltOpsEx(ops, a1, a2)(aNum, bNum)
        new NumericSeries[Double](res)
      }
    }
  }

//  def eltOpsSingle[T,K](ops: (Double, Double) => Double, vec: Vector[T], con: K)
//                       (vNum: Numeric[T], cNum: Numeric[K]) = {
//    if (matchVec(vec) && matchCon(con)) {
//      val res = vec.map( elt => {
//        val a = vNum.mkNumericOps(elt).toInt()
//        val b = cNum.mkNumericOps(con).toInt()
//        ops(a, b).toInt
//      })
//      new NumericSeries(res)
//    }else {
//      val res = vec.map( elt => {
//        val a = vNum.mkNumericOps(elt).toDouble()
//        val b = cNum.mkNumericOps(con).toDouble()
//        ops(a,b)
//      })
//      new NumericSeries(res)
//    }
//
//  }

  def eltOpsInt[T,K](ops: (Double,Double) => Double, a1: Vector[T], a2: Vector[K])
                    (aNum: Numeric[T], bNum: Numeric[K]): Vector[Int] = {
    a1.indices.map(i => {
      val a = aNum.mkNumericOps(a1(i)).toInt()
      val b = bNum.mkNumericOps(a2(i)).toInt()
      ops(a,b).toInt}).toVector
  }

  def eltOpsFrac[T,K](ops: (Double,Double) => Double, a1: Vector[T], a2: Vector[K])
                    (aNum: Numeric[T], bNum: Numeric[K]): Vector[Double] = {
    a1.indices.map(i => {
      val a = aNum.mkNumericOps(a1(i)).toDouble()
      val b = bNum.mkNumericOps(a2(i)).toDouble()
      ops(a,b)}).toVector
  }

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
