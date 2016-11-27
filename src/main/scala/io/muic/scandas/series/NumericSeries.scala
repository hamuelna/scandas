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

  def max()
  def mean(): Double
  def median()
  def min()
  def mode()
  def sum()


}
