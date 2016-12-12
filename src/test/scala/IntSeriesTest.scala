/**
  * Created by nattakarnklongyut on 12/11/16.
  */
import io.muic.scandas.series.{IntSeries}
import org.scalatest.{FlatSpec, Matchers}


class IntSeriesTest extends FlatSpec with Matchers {
  val ts1 = new IntSeries(Seq(1,2,3,4,5))
  val ts2 = new IntSeries(Seq(0,5,-8,1,-3))
  val ts3 = new IntSeries(Seq(4,2,12))
  val ts4 = new IntSeries(Seq())

  // plus
  it should "plus numbers together" in {
    (ts1 + ts2).toVector should be (Vector(1, 7, -5, 5, 2))
    (ts2 + ts3).toVector should be (Vector(4, 7, 4, Double.NaN, Double.NaN))
    (ts3 + ts4).toVector should be (Vector(Double.NaN, Double.NaN, Double.NaN))
  }

  it should "minus number together" in {
    (ts1 - ts2).toVector should be (Vector(1, -3, 11, 3, 8))
    (ts2 - ts3).toVector should be (Vector(-4, 3, -20, Double.NaN, Double.NaN))
    (ts3 - ts4).toVector should be (Vector(Double.NaN, Double.NaN, Double.NaN))
  }

  it should "multiply number together" in {
    (ts1 * ts2).toVector should be (Vector(0, 10, -24, 4, -15))
    (ts2 * ts3).toVector should be (Vector(0, 10, -96, Double.NaN, Double.NaN))
    (ts3 * ts4).toVector should be (Vector(Double.NaN, Double.NaN, Double.NaN))
  }

  it should "divide number together" in {
    (ts2 / ts1).toVector should be (Vector(0.0, 2.5, -2.6666666666666665, 0.25, -0.6))
    (ts2 / ts3).toVector should be (Vector(0.0, 2.5, -0.6666666666666666, Double.NaN, Double.NaN))
    (ts3 / ts4).toVector should be (Vector(Double.NaN, Double.NaN, Double.NaN))
  }

  // median
  it should "return median of the series" in {
    ts1.median() should be (3.0)
    ts2.median() should be (0.0)
    ts4.median() should be (Double.NaN)
  }

  // mean
  it should "return mean value of the series" in {
    ts1.mean() should be (3.0)
    ts2.mean() should be (-1.0)
    ts4.mean() should be (Double.NaN)
  }

  // mode
  it should "return mode value of the series" in {
    val ts1 = new IntSeries(Seq(4,5,3,3,1,0))
    val ts2 = new IntSeries(Seq())
    ts1.mode() should be (3)
    ts2.mode() should  be (Seq())
  }

  // absolute
  it should "return absolute value of series" in {
    ts2.abs().toVector should be (Vector(0, 5, 8, 1, 3))
  }

  // max
  it should "return max value of series" in {
    ts1.max() should be (5)
    ts2.max() should be (5)
  }

  // argMax
  it should "return index of max value" in {
    ts1.argMax() should be (4)
    ts3.argMax() should be (1)
  }

  // min
  it should "return min value of series" in {
    ts1.min() should be (1)
    ts3.min() should be (-8)
  }

  // argMin
  it should "return index of min value" in {
    ts1.argMin() should be (0)
    ts3.argMin() should be (2)
  }

  // sum
  it should "sum all numbers in series" in {
    ts1.sum() should be (15)
    ts2.sum() should be (-5)
    ts4.sum() should be (0)
  }

  // nonzero
  it should "return number that's not zero in the series" in {
    val ts = new IntSeries(Seq(0, 1, 4, 5, 0))
    ts.nonzero().toVector should be(Vector(1, 4, 5))
  }

  // more than
  it should "return boolean of A > B" in {
    (ts1 > ts2).toVector should be (Vector(true, false, true, true, true))
    (5 > 5) should be (false)
  }

  // more than or equal
  it should "return boolean of A >= B" in {
    (ts1 >= ts2).toVector should be (Vector(true, false, true, true, true))
    (5 >= 5) should be (true)
  }

  // less than
  it should "return boolean of A < B" in {
    (ts1 < ts2).toVector should be (Vector(false, true, false, false, false))
    (5 < 5) should be (false)
  }

  // less than or equal
  it should "return boolean of A <= B" in {
    (ts1 <= ts2).toVector should be (Vector(false, true, false, false, false))
    (5 <= 5) should be (true)
  }

}
