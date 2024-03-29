package io.muic.scandas.series

import io.muic.scandas.core.ScException.DiffDimException


trait Series {
  def obj(): Vector[Any]
  def index(in: Option[Seq[String]] = None): Option[Vector[String]] =
    if (in.isEmpty) None else {
      if (in.size == size()) Some(in.get.toVector)
      else throw new DiffDimException("Index Seq must have the same size as the data itself")
    }

  def ==(that: Series): BoolSeries = new BoolSeries(obj().zip(that.obj()).map(x => x._1 == x._2))
  def ==(that: String): BoolSeries = new BoolSeries(obj().map(x => x == that))

  def head() = obj().head
  def tail() = obj().tail
  def sort_value(): Series
  def unique = obj().distinct
  def boolIdx(that: BoolSeries): Series

  def size() = obj().size
  def iloc(i: Int) = obj()(i)
  def arloc(ii: Seq[Int]): Series
  def toArray = obj().toArray
  def toVector = obj()
  def toList = obj().toList

}

object Series {
  def apply[T](seq: Seq[T]): Series = {
    val tt = seq.head match {
      case _: Double => "Double"
      case _: Int => "Int"
      case _: String => "String"
      case _: Boolean => "Boolean"
      case _ => throw new Exception("this type is not supported")
    }
    val msg = "some type is not the same in the array"
    seq.foreach {
      case _:Double if tt == "Double" => ()
      case _:Int if tt == "Int" => ()
      case _:String if tt == "String" => ()
      case _: Boolean if tt == "Boolean" => ()
      case _ => throw new Exception(msg)
    }

    seq match {
      case x: Seq[Double @unchecked] if tt == "Double" => new DoubleSeries(x)
      case x: Seq[Boolean @unchecked] if tt == "Boolean" => new BoolSeries(x)
      case x: Seq[Int @unchecked] if tt == "Int" => new IntSeries(x)
      case x: Seq[String @unchecked] if tt == "String" => new StringSeries(x)
      case _ => throw new Exception("should not reach here or you use int which is not supported")
    }
  }
}
