package io.muic.scandas.dataframe

import io.muic.scandas.series.{BoolSeries, DoubleSeries, StringSeries}

import scala.reflect.{ClassTag, classTag}


object Util {
  def chkType[A : ClassTag](x: Seq[A]) = x match {
      case a: Seq[String @unchecked] if classTag[A] == classTag[String] => new StringSeries(a)
      case a: Seq[Double @unchecked] if classTag[A] == classTag[Double] => new DoubleSeries(a)
      case a: Seq[Boolean @unchecked] if classTag[A] == classTag[Boolean] => new BoolSeries(a)
      case _ => throw new NotImplementedError("Not support this type yet")
    }

  def chkType2[A : ClassTag](x: Seq[A]) = x match {
    case a: Seq[String @unchecked] if classTag[A] == classTag[String] => println("String")
    case a: Seq[Double @unchecked] if classTag[A] == classTag[Double] => println("Double")
    case a: Seq[Boolean @unchecked] if classTag[A] == classTag[Boolean] => println("Boolean")
    case _ => throw new NotImplementedError("Not support this type yet")
  }

}
