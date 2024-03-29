package io.muic.scandas.dataframe

import io.muic.scandas.series.{DoubleSeries, IntSeries, Series, StringSeries}

import scala.collection.immutable.Vector
import scala.collection.mutable.Map

object Df {
  def apply[T](d: Seq[T], c: Seq[String]): DataFrame = {
      if (c.isEmpty){
        val obj = d.indices.map {i => (i.toString , d(i) match {
          case x: Seq[_] => Util.castSingle(x)
          case x: Series => x
          case _ => throw new Exception("should not reach here")
        })}.toMap
        new DataFrame(obj)
      }else{
        val obj = c.zip(d).map {
          case (col: String, data:Series) => (col, data)
          case (col: String, data: Seq[_]) => (col, Util.castSingle(data))
          case _ => throw new Exception("should not reach here")
        }.toMap
        new DataFrame(obj)
      }
  }


  def apply[T](m: Map[String, T]): DataFrame = {
    val obj = m.map {
      case (col:String, data: Series) => (col,data)
      case (col:String, data: Seq[_]) => (col,Util.castSingle(data))
      case _ => throw new Exception("should not reach here")
    }.toMap

    new DataFrame(obj)
  }

  def processData(data: Map[String,Vector[_]], coltype: Map[String,String]): DataFrame = {
    val processData = data.map {
      case (k,d) if coltype(k) == "Double" => (k, new DoubleSeries(d.asInstanceOf[Vector[Double]]))
      case (k,d) if coltype(k) == "Int" => (k,new IntSeries(d.asInstanceOf[Vector[Int]])) //will change to seriesInt when it is finish
      case (k,d) if coltype(k) == "String" => (k,new StringSeries(d.asInstanceOf[Vector[String]]))
      case _ => throw new Exception("should not reach here")
    }
    val obj = processData.toMap
    new DataFrame(obj)
  }


  //from csv
  def apply(src: String): DataFrame = {
    import io.muic.scandas.adapter.DataLoader.readCSV
    val dd = readCSV(src)
    val coltype = dd._1
    val df = dd._2
    processData(df, coltype)
  }

  def read_json(src: String): DataFrame = {
    import io.muic.scandas.adapter.DataLoader.readJSON
    val dd = readJSON(src)
    val coltype = dd._1
    val df = dd._2
    processData(df, coltype)


  }

}
