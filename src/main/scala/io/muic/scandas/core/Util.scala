package io.muic.scandas.core

import scala.math


object Util {

  def checkDim(ar1: Seq[Any], ar2: Seq[Any]) ={
    import ScException.DiffDimException
    if (ar1.size != ar2.size) throw new DiffDimException
  }


}
