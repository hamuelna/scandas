package io.muic.scandas.series


trait Series {
  def obj(): Vector[_]
  def index(): Map[_,Int]

  def ==(that: Series): BoolSeries = new BoolSeries(obj().zip(that.obj()).map(x => x._1 == x._2))

  def head() = obj().head
  def tail() = obj().tail
//  def get(i : _)
  def sort_value() = obj().sorted

  def size() = obj().size

}
