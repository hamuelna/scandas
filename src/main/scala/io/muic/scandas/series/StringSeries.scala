package io.muic.scandas.series
import Util._

class StringSeries(seq: Seq[String]) extends Series {
  def obj(): Vector[String] = seq.toVector

  def >(that: StringSeries): BoolSeries =
    new BoolSeries(compSt(obj(), that.obj(), _>_))
  def >(that: String): BoolSeries =
    new BoolSeries(compStOne(obj(), that, _>_))

  //element-wise arithmetic operation
  def +(that: StringSeries): StringSeries =
    new StringSeries(opsSt(obj(), that.obj(), _+_))
  def +(that: String): StringSeries =
    new StringSeries(opsStOne(obj(), that, _+_))

  def <=(that: StringSeries): BoolSeries =
    new BoolSeries(compSt(obj, that.obj(), _<=_))
  def <=(that: String): BoolSeries =
    new BoolSeries(compStOne(obj(), that, _<=_))

  def <(that: StringSeries): BoolSeries =
    new BoolSeries(compSt(obj() ,that.obj(), _<_))
  def <(that: String): BoolSeries =
    new BoolSeries(compStOne(obj(), that, _<_))

  def >=(that: StringSeries): BoolSeries =
    new BoolSeries(compSt(obj(), that.obj(), _>=_))
  def >=(that: String): BoolSeries =
    new BoolSeries(compStOne(obj(), that, _>=_))

  def *(that: Int): Series =
    new StringSeries(obj().map(x => x * that))
}
