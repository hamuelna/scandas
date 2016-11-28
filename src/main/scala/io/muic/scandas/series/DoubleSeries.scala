package io.muic.scandas.series
import Util._
class DoubleSeries(seq: Seq[Double]) extends NumericSeries{


  def abs(): NumericSeries = new DoubleSeries(obj().map(x => x.abs))

  def median(): Double = obj().sorted.toVector(size()/2 + 1)

  def mean(): Double = sum()/size()

  def /(that: DoubleSeries): DoubleSeries =
    new DoubleSeries(opsNum(obj(), that.obj(), _/_))

  def /(that: Double): DoubleSeries =
    new DoubleSeries(opsNumOne(obj(), that, _/_))

  def max(): Double = obj().toParArray.max

  def +(that: DoubleSeries): DoubleSeries =
    new DoubleSeries(opsNum(obj(), that.obj(), _+_))
  def +(that: Double): DoubleSeries =
    new DoubleSeries(opsNumOne(obj(), that, _+_))

  def mode(): Double = obj().toParArray.groupBy(x => x).maxBy(x => x._2.size)._1

  def min(): Double = obj().toParArray.min

  def sum(): Double = obj().toParArray.sum

  def -(that: DoubleSeries): DoubleSeries =
    new DoubleSeries(opsNum(obj(), that.obj(), _-_))

  def -(that: Double): DoubleSeries =
    new DoubleSeries(opsNumOne(obj(), that, _-_))

  def *(that: DoubleSeries): DoubleSeries =
    new DoubleSeries(opsNum(obj(), that.obj(), _*_))

  def *(that: Double): DoubleSeries =
    new DoubleSeries(opsNumOne(obj(), that, _*_))


  def >(that: DoubleSeries): BoolSeries =
    new BoolSeries(compNum(obj(), that.obj(), _>_))

  def >(that: Double): BoolSeries =
    new BoolSeries(compNumOne(obj(), that, _>_))

  def <=(that: DoubleSeries): BoolSeries =
    new BoolSeries(compNum(obj(), that.obj(), _<=_))

  def <=(that: Double): BoolSeries =
    new BoolSeries(compNumOne(obj(), that, _<=_))

  def <(that: DoubleSeries): BoolSeries =
    new BoolSeries(compNum(obj(), that.obj(), _<_))

  def <(that: Double): BoolSeries =
    new BoolSeries(compNumOne(obj(), that, _<_))

  def >=(that: DoubleSeries): BoolSeries =
    new BoolSeries(compNum(obj(), that.obj(), _>=_))

  def >=(that: Double): BoolSeries =
    new BoolSeries(compNumOne(obj(), that, _>=_))

  def nonzero(): DoubleSeries = new DoubleSeries(obj().filter(x => x != 0))

  def obj(): Vector[Double] = seq.toVector
}
