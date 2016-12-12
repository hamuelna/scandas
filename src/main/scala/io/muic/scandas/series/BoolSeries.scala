package io.muic.scandas.series

class BoolSeries(seq: Seq[Boolean], in: Option[Seq[String]] = None) extends Series {
  def obj(): Vector[Boolean] = seq.toVector

  def &&(that: BoolSeries): BoolSeries =
    new BoolSeries(obj().zip(that.obj()).map(x => x._1 && x._2))

  def ||(that: BoolSeries): BoolSeries =
    new BoolSeries(obj().zip(that.obj()).map(x => x._1 || x._2))

  def sort_value(): BoolSeries = new BoolSeries(obj().sorted)

  def boolIdx(that: BoolSeries): BoolSeries =
    new BoolSeries(obj().zip(that.obj()).filter(x => x._2).map(x => x._1))

  def unary_!(): BoolSeries =
    new BoolSeries(obj().map(x => !x))

  def arloc(ii: Seq[Int]): BoolSeries = new BoolSeries(ii.map(i => obj()(i)))

}
