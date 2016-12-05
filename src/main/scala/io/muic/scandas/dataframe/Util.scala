package io.muic.scandas.dataframe

import io.muic.scandas.series.{BoolSeries, DoubleSeries, StringSeries}

import scala.reflect.runtime.universe.{TypeTag, typeOf}


object Util {
  def findT[A: TypeTag](f: Int => A): String = ""+typeOf[A]

  def castType(seq: Seq[Seq[Any]]) = seq.map(x => {
    if (x.head.isInstanceOf[Double]) {
      val temp = x.asInstanceOf[Seq[Double]]
      new DoubleSeries(temp)
    }else if (x.head.isInstanceOf[Boolean]) {
      val temp = x.asInstanceOf[Seq[Boolean]]
      new BoolSeries(temp)
    }else if (x.head.isInstanceOf[String]){
      val temp = x.asInstanceOf[Seq[String]]
      new StringSeries(temp)
    }else throw new NotImplementedError()
  })
}
