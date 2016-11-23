package io.muic.scandas.core

import io.muic.scandas.core.ScException.DiffDimException

class Series[T](data: Seq[T])(implicit num: Numeric[T]) {
  val gData = data.toVector
  def abs: Series[T] = new Series[T](gData.map(x => {
    val ops = num.mkNumericOps(x)
    ops.abs()
  }))

  import io.muic.scandas.core.Util._

  def +(that: Series[T]) = {
    try {
      checkDim(gData, that.toVector)
      val res = gData.indices.map(i => {
        val aops = num.mkNumericOps(gData(i))
        aops + that.toVector(i)
      })
      new Series[T](res)
    }catch {
      case DiffDimException(_,_) => {
        new Series[Double](eltOpsEx(_+_, gData, that.toVector))
      }
    }

  }

  def -(that: Series[T]) = {
    try{
      checkDim(gData, that.toVector)
      val res = gData.indices.map(i => {
        val aops = num.mkNumericOps(gData(i))
        aops - that.toVector(i)
      })
      new Series[T](res)
    }catch {
      case DiffDimException(_,_) => {
        new Series[Double](eltOpsEx(_-_, gData, that.toVector))
      }
    }

  }

  def *(that: Series[T])= {
    try {
      checkDim(gData, that.toVector)
      val res = gData.indices.map(i => {
        val aops = num.mkNumericOps(gData(i))
        aops * that.toVector(i)
      })
      new Series(res)
    }catch {
      case DiffDimException(_,_) => {
        new Series[Double](eltOpsEx(_*_, gData, that.toVector))}
    }

  }

  def /(that: Series[T]): Series[Double] = {
    try{
      checkDim(gData, that.toVector)
      val res = gData.indices.map(i => {
        val aops = num.mkNumericOps(gData(i)).toDouble()
        val bops = num.mkNumericOps(gData(i)).toDouble()
        aops / bops
      })
      new Series[Double](res)
    }catch {
      case DiffDimException(_,_) => {
        new Series[Double](eltOpsEx(_/_, gData, that.toVector))
      }
    }
  }

  def toVector = gData
  def toArray = gData.toArray
  def size = gData.size

}
