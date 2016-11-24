package io.muic.scandas.core

import io.muic.scandas.series.NumericSeries

trait Stats {
  def mean[T](data: NumericSeries[T]) = ???
  def min[T](data: NumericSeries[T]) = ???
  def max[T](data: NumericSeries[T]) = ???
//  def variance(data: Series) = ???
//  def covariance(data: Series) = ???
//  def std(data: Series) = ???
//
//  def describe(data: DataFrame) = ???

}
