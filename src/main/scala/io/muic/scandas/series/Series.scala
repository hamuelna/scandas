package io.muic.scandas.series

import io.muic.scandas.core.ScException.DiffDimException


trait Series {
  def obj(): Vector[_]
  def index(in: Option[Seq[String]] = None): Option[Vector[String]] =
    if (in.isEmpty) None else {
      if (in.size == size()) Some(in.get.toVector)
      else throw new DiffDimException("Index Seq must have the same size as the data itself")
    }

  def ==(that: Series): BoolSeries = new BoolSeries(obj().zip(that.obj()).map(x => x._1 == x._2))

  def head() = obj().head
  def tail() = obj().tail
  def sort_value() = obj().sorted
  def unique = obj().distinct

  def size() = obj().size
  def toArray = obj().toArray
  def toVector = obj()
  def toList = obj().toList


}
