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

  def head() = obj().head
  def tail() = obj().tail
  def sort_value(): Series
  def unique = obj().distinct
  def boolIdx(that: BoolSeries): Series

  def size() = obj().size
  def iloc(i: Int) = obj()(i)
  def toArray = obj().toArray
  def toVector = obj()
  def toList = obj().toList



}
