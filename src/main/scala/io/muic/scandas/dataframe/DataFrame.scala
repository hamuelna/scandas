package io.muic.scandas.dataframe

import io.muic.scandas.series._


object DataFrame{
  var obj: Map[String, Series] = Map[String, Series]()

  def fromSeq[T](d: Seq[Seq[T]], c: Seq[String]= Nil ) = {
    if (c.isEmpty){
      obj = d.indices.map(i => i.toString -> Util.castSingle(c(i))).toMap
    }else{
      obj = d.zip(c).map(x => x._2 -> Util.castSingle(x._1)).toMap
    }
    DataFrame
  }

  def fromSeries[T <: Series](d : Seq[T], c: Seq[String] = Nil) = {
    if (c.isEmpty){
        obj = d.indices.map(i => i.toString -> d(i)).toMap
    }else {
        obj = d.zip(c).map(x => x._2 -> x._1).toMap
    }
    DataFrame
  }

  def fromSeqMap(d : Map[String, Seq[Any]])= {
    obj = d.map(x => x._1 -> Util.castSingle(x._2))
    DataFrame
  }

  def fromSeriesMap[T <: Series](d: Map[String, T])= {
    obj = d
    DataFrame
  }

  def toMap: Map[String, Series] = obj

  def getCol(x: String): Series = obj(x)
  def getNumCol(x: String): NumericSeries = obj(x).asInstanceOf[NumericSeries]
  def getRow(i: Int) = obj.map(x => x._2.iloc(i))
  def head = obj.map(x => x._2.head())
  def last = obj.map(x => x._2.iloc(x._2.size() - 1))

  //fun stuff start here

  def boolIdx(seq: BoolSeries) ={
    val ix = seq.obj().indices.filter(i => seq.obj()(i))
    obj.mapValues(x => x.arloc(ix))
    DataFrame
  }

}
