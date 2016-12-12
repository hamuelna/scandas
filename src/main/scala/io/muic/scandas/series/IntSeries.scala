package io.muic.scandas.series
import Util._

class IntSeries(seq: Seq[Int]) extends NumericSeries{


  def sort_value(): IntSeries = new IntSeries(obj().sorted)

  def boolIdx(that: BoolSeries): IntSeries =
    new IntSeries(obj().zip(that.obj()).filter(x => x._2).map(x => x._1))

  def abs(): NumericSeries = new IntSeries(obj().map(x => x.abs))

  def mean(): Double = sum()/size()

  def median(): Double = {
    val (lower, upper) = seq.sortWith(_<_).splitAt(seq.size / 2)
    if (seq.size % 2 == 0) (lower.last + upper.head) / 2.0 else upper.head
  }
  /// dont have case of having two mode -> Seq(4.0, 4.0, 5.0 ,5.0)
  def mode(): Int = obj().toParArray.groupBy(x => x).maxBy(x => x._2.size)._1

  def min(): Int = obj().toParArray.min

  def max(): Int = obj().toParArray.max

  def sum(): Int = obj().toParArray.sum

  def argMax(): Int = obj().indexOf(max())

  def argMin(): Int = obj().indexOf(min())

  def /(that: IntSeries): DoubleSeries =
    new DoubleSeries(opsIntDiv(obj(), that.obj(), _/_))
  def /(that: Int): DoubleSeries =
    new DoubleSeries(opsIntOneDiv(obj(), that, _/_))
// int double
  def /(that: DoubleSeries): DoubleSeries =
    new DoubleSeries(opsNumID(obj(), that.obj(), _/_))
  def /(that: Double): DoubleSeries =
    new DoubleSeries(opsNumOneID(obj(), that, _/_))

  def +(that: IntSeries): IntSeries =
    new IntSeries(opsInt(obj(), that.obj(), _+_))
  def +(that: Int): IntSeries =
    new IntSeries(opsIntOne(obj(), that, _+_))
  // int double
  def +(that: DoubleSeries): DoubleSeries =
    new DoubleSeries(opsNumID(obj(), that.obj(), _+_))
  def +(that: Double): DoubleSeries =
    new DoubleSeries(opsNumOneID(obj(), that, _+_))

  def -(that: IntSeries): IntSeries =
    new IntSeries(opsInt(obj(), that.obj(), _-_))
  def -(that: Int): IntSeries =
    new IntSeries(opsIntOne(obj(), that, _-_))
  // in doulble
  def -(that: DoubleSeries): DoubleSeries =
    new DoubleSeries(opsNumID(obj(), that.obj(), _-_))
  def -(that: Double): DoubleSeries =
    new DoubleSeries(opsNumOneID(obj(), that, _-_))

  def *(that: IntSeries): IntSeries =
    new IntSeries(opsInt(obj(), that.obj(), _*_))
  def *(that: Int): IntSeries =
    new IntSeries(opsIntOne(obj(), that, _*_))
  //
  def *(that: DoubleSeries): DoubleSeries =
    new DoubleSeries(opsNumID(obj(), that.obj(), _*_))
  def *(that: Double): DoubleSeries =
    new DoubleSeries(opsNumOneID(obj(), that, _*_))

  def >(that: IntSeries): BoolSeries =
    new BoolSeries(compInt(obj(), that.obj(), _>_))
  def >(that: Int): BoolSeries =
    new BoolSeries(compIntOne(obj(), that, _>_))
  ///
  def >(that: DoubleSeries): BoolSeries =
    new BoolSeries(compNumID(obj(), that.obj(), _>_))
  def >(that: Double): BoolSeries =
    new BoolSeries(compNumOneID(obj(), that, _>_))

  def <=(that: IntSeries): BoolSeries =
    new BoolSeries(compInt(obj(), that.obj(), _<=_))
  def <=(that: Int): BoolSeries =
    new BoolSeries(compIntOne(obj(), that, _<=_))
  ///
  def <=(that: DoubleSeries): BoolSeries =
    new BoolSeries(compNumID(obj(), that.obj(), _<=_))
  def <=(that: Double): BoolSeries =
    new BoolSeries(compNumOneID(obj(), that, _<=_))

  def <(that: IntSeries): BoolSeries =
    new BoolSeries(compInt(obj(), that.obj(), _<_))
  def <(that: Int): BoolSeries =
    new BoolSeries(compIntOne(obj(), that, _<_))
  def <(that: DoubleSeries): BoolSeries =
    new BoolSeries(compNumID(obj(), that.obj(), _<_))
  def <(that: Double): BoolSeries =
    new BoolSeries(compNumOneID(obj(), that, _<_))

  def >=(that: IntSeries): BoolSeries =
    new BoolSeries(compInt(obj(), that.obj(), _>=_))
  def >=(that: Int): BoolSeries =
    new BoolSeries(compIntOne(obj(), that, _>=_))
  def >=(that: DoubleSeries): BoolSeries =
    new BoolSeries(compNumID(obj(), that.obj(), _>=_))
  def >=(that: Double): BoolSeries =
    new BoolSeries(compNumOneID(obj(), that, _>=_))

  def nonzero(): IntSeries = new IntSeries(obj().filter(x => x != 0))

  def obj(): Vector[Int] = seq.toVector
}
