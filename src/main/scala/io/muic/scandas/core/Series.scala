package io.muic.scandas.core

import io.muic.scandas.core.ScException.DiffDimException

class Series[+T](data: Seq[T])(implicit num: Numeric[T]) {
  val gData = data.toVector
  def abs: Series[T] = new Series[T](gData.map(x => {
    val ops = num.mkNumericOps(x)
    ops.abs()
  }))
  def toVector = gData
  def toSeq = gData.toSeq
  def size = gData.size

  import io.muic.scandas.core.Util._


  def +[A >: T](that: Series[A])(implicit thatNum: Numeric[A]) ={
    try {
      checkDim(gData, that.toVector)
      if (pairMatch(gData, that.toVector)){
        val res = gData.indices.map(i => {
          val a = num.mkNumericOps(gData(i)).toInt()
          val b = thatNum.mkNumericOps(that.toVector(i)).toInt()
          a + b
        })
        new Series(res)
      } else {
        val res = gData.indices.map(i => {
          val a = num.mkNumericOps(gData(i)).toDouble()
          val b = thatNum.mkNumericOps(that.toVector(i)).toDouble()
          a + b
        })
        new Series(res)
      }

    }catch {
      case DiffDimException(_,_) => {
        val res = eltOpsEx[T,A](_+_, gData, that.toVector)(num, thatNum)
        new Series[Double](res)
      }
    }

  }

  def -[A >: T](that: Series[A])(implicit thatNum: Numeric[A]) ={
    try {
      checkDim(gData, that.toVector)
      if (pairMatch(gData, that.toVector)) {
        val res = gData.indices.map(i => {
          val a = num.mkNumericOps(gData(i)).toInt()
          val b = thatNum.mkNumericOps(that.toVector(i)).toInt()
          a - b
        })
        new Series(res)
      } else {
        val res = gData.indices.map(i => {
          val a = num.mkNumericOps(gData(i)).toDouble()
          val b = thatNum.mkNumericOps(that.toVector(i)).toDouble()
          a - b
        })
        new Series(res)
      }

    }catch {
      case DiffDimException(_,_) => {
        val res = eltOpsEx[T,A](_-_, gData, that.toVector)(num, thatNum)
        new Series[Double](res)
      }
    }
  }

  def *[A >: T](that: Series[A])(implicit thatNum: Numeric[A]) ={
    try {
      checkDim(gData, that.toVector)
      if (pairMatch(gData, that.toVector)) {
        val res = gData.indices.map(i => {
          val a = num.mkNumericOps(gData(i)).toInt()
          val b = thatNum.mkNumericOps(that.toVector(i)).toInt()
          a * b
        })
        new Series(res)
      } else {
        val res = gData.indices.map(i => {
          val a = num.mkNumericOps(gData(i)).toDouble()
          val b = thatNum.mkNumericOps(that.toVector(i)).toDouble()
          a * b
        })
        new Series(res)
      }

    }catch {
      case DiffDimException(_,_) => {
        val res = eltOpsEx[T,A](_*_, gData, that.toVector)(num, thatNum)
        new Series[Double](res)
      }
    }
  }

  def /[A >: T](that: Series[A])(implicit thatNum: Numeric[A]) : Series[Double] = {
    try{
      checkDim(gData, that.toVector)
      val res = gData.indices.map(i => {
        val aops = num.mkNumericOps(gData(i)).toDouble()
        val bops = thatNum.mkNumericOps(that.toVector(i)).toDouble()
        aops / bops
      })
      new Series[Double](res)
    }catch {
      case DiffDimException(_,_) => {
        val res = eltOpsEx[T,A](_/_,gData, that.toVector)(num, thatNum)
        new Series[Double](res)
      }
      case _ => throw new Exception("Should not reach here")
    }
  }



}
