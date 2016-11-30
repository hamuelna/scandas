package io.muic.scandas.dataframe

import io.muic.scandas.series.{BoolSeries, DoubleSeries, Series, StringSeries}

import scala.collection.immutable.HashMap

object DataFrame{
  var col: Seq[String] = Nil
  var data: Seq[Series] = Nil

  def fromSeq(d: Seq[Seq[Any]], c: Seq[String]= Nil ) = {
    this.data = d.map(x => Util.chkType(x))
    if (c.nonEmpty) col = c
    DataFrame
  }

  def fromSeries(d : Seq[Series], c: Seq[String] = Nil) = {
    data = d
    col = c
    DataFrame
  }

  def fromSeqMap(d : Map[String, Seq[Any]])= {
    val temp = d.map(x => (x._1, x._2 match {
      case a: Seq[Double] => new DoubleSeries(a)
      case a: Seq[String] => new StringSeries(a)
      case a: Seq[Boolean] => new BoolSeries(a)
      case _ => throw new NotImplementedError()
    })).toSeq
    col = temp.map(x => x._1)
    data = temp.map(x => x._2)
    DataFrame
  }

  def fromSeriesMap(d: Map[String, Series]): Unit = {
    val temp = d.map(x => (x._1, x._2)).toSeq
    col = temp.map(x => x._1)
    data = temp.map(x => x._2)
    DataFrame
  }

  def toMap(): Map[String, Series] = {
    val temp = new HashMap[String, Series]
    temp++col.zip(data)
    temp
  }
  def getCol(x: String) = data(col.indexOf(x))
  def getRow(i: Int) = data.map(x => x.iloc(i))

}
