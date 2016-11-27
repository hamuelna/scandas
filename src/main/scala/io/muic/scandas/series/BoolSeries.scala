package io.muic.scandas.series

class BoolSeries(seq: Seq[Boolean]) extends Series {
  def obj(): Vector[Boolean] = seq.toVector

  def index(): Map[_, Int] = ???

}
