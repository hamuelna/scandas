package io.muic.scandas.series


trait NumericSeries extends Series {
  def abs(): NumericSeries

  def +(that: DoubleSeries): DoubleSeries
  def +(that: Double): DoubleSeries

  def -(that: DoubleSeries): DoubleSeries
  def -(that: Double): DoubleSeries

  def *(that: DoubleSeries): DoubleSeries
  def *(that: Double): DoubleSeries

  def /(that: DoubleSeries): DoubleSeries
  def /(that: Double): DoubleSeries

  def > (that: DoubleSeries): BoolSeries
  def > (that: Double): BoolSeries

  def >= (that: DoubleSeries): BoolSeries
  def >= (that: Double): BoolSeries

  def < (that: DoubleSeries): BoolSeries
  def < (that: Double): BoolSeries

  def <= (that: DoubleSeries): BoolSeries
  def <= (that: Double): BoolSeries

  def nonzero(): NumericSeries
  def max(): AnyVal
  def argMax(): Int
  def mean(): Double
  def min(): AnyVal
  def argMin(): Int
  def mode(): AnyVal
  def sum(): AnyVal


}
