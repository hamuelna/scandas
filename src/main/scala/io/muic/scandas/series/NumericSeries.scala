package io.muic.scandas.series


trait NumericSeries extends Series {

  def abs(): NumericSeries

  def +(that: DoubleSeries): DoubleSeries
  def +(that: Double): DoubleSeries
  def +(that: IntSeries): IntSeries
  def +(that: Int): IntSeries

  def -(that: DoubleSeries): DoubleSeries
  def -(that: Double): DoubleSeries
  def -(that: IntSeries): IntSeries
  def -(that: Int): IntSeries

  def *(that: DoubleSeries): DoubleSeries
  def *(that: Double): DoubleSeries
  def *(that: IntSeries): IntSeries
  def *(that: Int): IntSeries

  def /(that: DoubleSeries): DoubleSeries
  def /(that: Double): DoubleSeries
  def /(that: IntSeries): DoubleSeries
  def /(that: Int): DoubleSeries

  def > (that: DoubleSeries): BoolSeries
  def > (that: Double): BoolSeries
  def > (that: IntSeries): BoolSeries
  def > (that: Int): BoolSeries

  def >= (that: DoubleSeries): BoolSeries
  def >= (that: Double): BoolSeries
  def >= (that: IntSeries): BoolSeries
  def >= (that: Int): BoolSeries

  def < (that: DoubleSeries): BoolSeries
  def < (that: Double): BoolSeries
  def < (that: IntSeries): BoolSeries
  def < (that: Int): BoolSeries

  def <= (that: DoubleSeries): BoolSeries
  def <= (that: Double): BoolSeries
  def <= (that: IntSeries): BoolSeries
  def <= (that: Int): BoolSeries

  def nonzero(): NumericSeries
  def max(): AnyVal
  def argMax(): Int
  def mean(): Double
  def min(): AnyVal
  def argMin(): Int
  def mode(): AnyVal
  def sum(): AnyVal
  def std(): Double


}
