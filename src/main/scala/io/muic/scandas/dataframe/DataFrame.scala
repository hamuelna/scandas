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

  def boolIdx(seq: BoolSeries): DataFrame ={
    val ix = seq.obj().indices.filter(i => seq.obj()(i))
    obj = obj.mapValues(x => x.arloc(ix))
    new DataFrame(obj)
  }

  def max = obj.map {
    case (col,data:StringSeries) => (col, data.max)
    case (col, data:NumericSeries) => (col, data.max())
    case (col, _) => (col, Double.NaN)
  }

  def min = obj.map {
    case (col, data:StringSeries) => (col, data.min)
    case (col, data:NumericSeries) => (col, data.min())
    case (col, _) => (col, Double.NaN)
  }

  def mean: Map[String, Double] = {
    obj.filter(x => x._2.isInstanceOf[NumericSeries])
        .mapValues(x => x.asInstanceOf[NumericSeries].mean())
  }

  def std = {
    obj.filter(x => x._2.isInstanceOf[NumericSeries])
      .mapValues(x => x.asInstanceOf[NumericSeries].std())
  }

  def describe = ??? //aggregate all the statistic together

  def join(that: DataFrame, l_suffix: String = "", r_suffix: String = "", how: String = "left"): DataFrame = {
      val mapping = how match {
        case "left" => obj.zip(that.obj).map {
          case ((k1,v1),(k2,v2)) => Map(k1 -> v1, k2 -> v2)
          case ((k1,v1),(k2,v2)) if k1 == k2 => Map(k1+l_suffix -> v1, k2+r_suffix -> v2)
          case ((k1,v1),(k2,v2)) if k1 == k2 && l_suffix == r_suffix => throw new Exception("suffix is the same")
        }
        case "right" => obj.zip(that.obj).map {
          case ((k1,v1),(k2,v2)) => Map(k1 -> v1, k2 -> v2)
          case ((k1,v1),(k2,v2)) if k1 == k2 => Map(k1+l_suffix -> v1, k2+r_suffix -> v2)
          case ((k1,v1),(k2,v2)) if k1 == k2 && l_suffix == r_suffix => throw new Exception("suffix is the same")
        }
      }
    new DataFrame(mapping.flatten.toMap)
  }


}
