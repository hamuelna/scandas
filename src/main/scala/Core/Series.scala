package Core
class Series(data: Array, index: Array){

  def this(data: Array) = {
    //create a default index for the data
    this
  }


  def abs()
  def +(that: Series): Series = ???
  def -(that: Series): Series = ???
  def *(that: Series): Series = ???
  def /(that: Series): Series = ???
  def comparable(that: Series): Series = ???

  def append(that: Series) = ???

  def first() = ???
  def last() = ???
  def count() = ??? //count non-NA fields


  //print the series in a beautiful way
  override def toString = ???

}
