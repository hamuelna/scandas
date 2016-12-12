package io.muic.scandas.dataframe

import io.muic.scandas.series.{BoolSeries, DoubleSeries, StringSeries}



object Util {

  def castSingle(x: Seq[Any]) = {
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
  }

  def castAll(seq: Seq[Seq[Any]]) = seq.map(x => castSingle(x))
}
