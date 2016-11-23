package io.muic.scandas.core

class Series(data: Array[Double], index: Option[Array[Int]]= None){
  val g_data = data
  val i_data = index

  def abs(): Series = ???
  def +(that: Series): Series = ???
  def -(that: Series): Series = ???
  def *(that: Series): Series = ???
  def /(that: Series): Series = ???
  //comparing element wise i.e. List(True, False, True)
  def comparable(that: Series): Series = ???
  //append series to this series
  def append(that: Series) = ???

  def first() = ???
  def last() = ???
  def count() = ??? //count non-NA fields


  //print the series in a beautiful way
  override def toString: String = ???

}
