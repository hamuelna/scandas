package io.muic.scandas.series

class StringSeries (data: Seq[Any]) {
  val gData = data.toVector
  def size = gData.size
  def toVector = gData


}
