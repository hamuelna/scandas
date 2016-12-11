package io.muic.scandas.dataframe

import io.muic.scandas.series._


class DataFrame(x: Map[String, Series]){
  //Column Name -> Series
  var obj: Map[String, Series] = x

  def toMap: Map[String, Series] = obj

  def getCol(x: String): Series = obj(x)
  def getNumCol(x: String): NumericSeries = obj(x).asInstanceOf[NumericSeries]
  def getRow(i: Int) = obj.map(x => x._2.iloc(i))
  def head = obj.map(x => x._2.head())
  def last = obj.map(x => x._2.iloc(x._2.size() - 1))
  def keys = obj.keys.toSeq
  def datalen: Int = obj.values.head.size()
  def clear = obj = Map[String, Series]()

  //fun stuff start here

  def boolIdx(seq: BoolSeries) ={
    val ix = seq.obj().indices.filter(i => seq.obj()(i))
    obj = obj.mapValues(x => x.arloc(ix))
    new DataFrame(obj)
  }

}
