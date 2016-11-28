package io.muic.scandas.series

class BoolSeries(seq: Seq[Boolean], in: Option[Seq[String]] = None) extends Series {
  def obj(): Vector[Boolean] = seq.toVector

  def &&(that: BoolSeries): BoolSeries =
    new BoolSeries(obj().zip(that.obj()).map(x => x._1 && x._2))

  def ||(that: BoolSeries): BoolSeries =
    new BoolSeries(obj().zip(that.obj()).map(x => x._1 || x._2))

  def unary_!(): BoolSeries =
    new BoolSeries(obj().map(x => !x))

}
