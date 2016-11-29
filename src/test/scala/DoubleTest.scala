import io.muic.scandas.series.{DoubleSeries}
import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by nattakarnklongyut on 11/28/16.
  */
class DoubleTest extends FlatSpec with Matchers {

  "A series" should "do a lot of stuff such as element wise stuff" in {

    val ts1 = new DoubleSeries(Seq(1.0, 5.0, 7.0, 4.0, 10.0))
    val ts2 = new DoubleSeries(Seq(2.0, 3.0, 5.0, 7.0, 9.0))
    val ts3 = new DoubleSeries(Seq())

    ts1.toVector should be (Seq(1.0, 5.0, 7.0, 4.0, 10.0))
    ts2.toVector should be (Seq(2.0, 3.0, 5.0, 7.0, 9.0))
    ts3.toVector should be (Vector())
  }

  // abs
  it should "make series absolute" in {

    val ts1 = new DoubleSeries(Seq(1.0, 5.0, 7.0, 4.0, 10.0))
    val ts2 = new DoubleSeries(Seq())
    val ts3 = new DoubleSeries(Seq(-1.0,2.0,-5.0))

    ts1.abs().toVector should be (Vector(1.0, 5.0, 7.0, 4.0, 10.0))
    ts2.abs().toVector should be (Vector())
    ts3.abs().toVector should be (Vector(1.0, 2.0, 5.0))
  }

  // median
  it should "give a median of the series" in {

    val ts1 = new DoubleSeries(Seq(1.0, 5.0, 7.0, 4.0, 10.0))
    val ts2 = new DoubleSeries(Seq())
    val ts3 = new DoubleSeries(Seq(-1.0,2.0,-5.0))

    ts1.median() should be (5.0)
    ts2.median() should be (Seq())
    ts3.median() should be (-1.0)
  }

  // mean
  it should "give a mean number of the series" in {

    val ts1 = new DoubleSeries(Seq(1.0, 5.0, 7.0, 4.0, 10.0))
    val ts2 = new DoubleSeries(Seq())
    val ts3 = new DoubleSeries(Seq(-1.0,2.0,-5.0))

    ts1.mean() should be (5.4)
    ts2.mean() should be (Seq())
    ts3.mean() should be (1.66)
  }


  // max
  it should "give maximum value of series" in {
    val d1 = Seq(1.0, 5.0, 7.0, 4.0, 10.0)
    val d2 = Seq()
    val d3 = Seq(-1.0,2.0,-5.0)
    val d4 = Seq(-10.0, 6.0, 3.0, 12.5, -3.2)

    val ts1 = new DoubleSeries(d1)
    val ts2 = new DoubleSeries(d2)
    val ts3 = new DoubleSeries(d3)
    val ts4 = new DoubleSeries(d4)

    ts1.max() should be (10.0)
    ts2.max() should be (Seq())
    ts3.max() should be (2.0)
    ts4.max() should be (12.5)
  }

  // min
  it should "give minimum value of series" in {
    val d1 = Seq(1.0, 5.0, 7.0, 4.0, 10.0)
    val d2 = Seq()
    val d3 = Seq(-1.0,2.0,-5.0)
    val d4 = Seq(-10.0, 6.0, 3.0, 12.5, -3.2)

    val ts1 = new DoubleSeries(d1)
    val ts2 = new DoubleSeries(d2)
    val ts3 = new DoubleSeries(d3)
    val ts4 = new DoubleSeries(d4)

    ts1.min() should be (1.0)
    ts2.min() should be (Seq())
    ts3.min() should be (-5.0)
    ts4.min() should be (-10.0)
  }

  //mode
  it should "give mode value of series" in {
    val d1 = Seq(1.0, 5.0, 5.0, 4.0, 10.0)
    val d2 = Seq()
    val d3 = Seq(-1.0,2.0,-5.0)

    val ts1 = new DoubleSeries(d1)
    val ts2 = new DoubleSeries(d2)
    val ts3 = new DoubleSeries(d3)

    ts1.mode() should be (5.0)
    ts2.mode() should be (Seq())
    ts3.mode() should be (Seq())
  }

  // sum
  it should "give sim of double in the series" in {
    val d1 = Seq(1.0, 5.0, 7.0, 4.0, 10.0)
    val d2 = Seq()
    val d3 = Seq(-1.0,2.0,-5.0)

    val ts1 = new DoubleSeries(d1)
    val ts2 = new DoubleSeries(d2)
    val ts3 = new DoubleSeries(d3)

    ts1.sum() should be (27.0)
    ts2.sum() should be (Seq())
    ts3.sum() should be (-4.0)
  }

  // plus
  it should "plus two series/double correctly" in {

    val d1 = Seq(1.0, 5.0, 7.0, 4.0, 10.0)
    val d2 = Seq()
    val d3 = Seq(-1.0,2.0,-5.0)
    val d4 = Seq(-10.0, 6.0, 3.0, 12.5, -3.2)
    val d5 = 1.0
    val d6 = -0.5
    val d7 = 3.0

    val ts1 = new DoubleSeries(d1)
    val ts2 = new DoubleSeries(d2)
    val ts3 = new DoubleSeries(d3)
    val ts4 = new DoubleSeries(d4)

    (ts1 + ts2).toVector should be (Vector(1.0, 5.0, 7.0, 4.0, 10.0))
    (ts1 + ts3).toVector should be (Vector(-11.0, 8.0, -2.0, Double.NaN, Double.NaN))
    (ts3 + ts4).toVector should be (Vector(-9.0, 11.0, 10.0, 16.5, 6.8))
    (ts4 + d7).toVector should be (Vector(-7.0, 9.0, 6.0, 15.5, -0.2))
    (ts2 + d7) should be (Seq())
    d5 + d6 should be (0.5)
    d5 + d7 should be (4.0)
  }

  // minus
  it should "minus doubles between series correctly" in {
    val d1 = Seq(1.0, 5.0, 7.0, 4.0, 10.0)
    val d2 = Seq()
    val d3 = Seq(-1.0,2.0,-5.0)
    val d4 = Seq(-10.0, 6.0, 3.0, 12.5, -3.2)
    val d5 = 1.0
    val d6 = -0.5
    val d7 = 3.0

    val ts1 = new DoubleSeries(d1)
    val ts2 = new DoubleSeries(d2)
    val ts3 = new DoubleSeries(d3)
    val ts4 = new DoubleSeries(d4)

    ts1 - ts2 should be (Seq(Double.NaN, Double.NaN, Double.NaN, Double.NaN, Double.NaN))
    ts1 - ts3 should be (Seq(11.0, -1.0, 4.0, -8.5, 13.2))
    ts3 - ts4 should be (Seq(9.0, -4.0, -8.0, Double.NaN, Double.NaN))
    d5 - d6 should be (1.5)
    ts3 - d7 should be (Seq(-4.0, -1.0, -8.0))
    d5 - d7 should be (-2.0)
  }

  // multiply
  it should "multiply double in the series correctly" in {
    val d1 = Seq(1.0, 5.0, 7.0, 4.0, 10.0)
    val d2 = Seq()
    val d3 = Seq(-1.0,2.0,-5.0)
    val d4 = Seq(-10.0, 6.0, 3.0, 12.5, -3.2)
    val d5 = 1.0
    val d6 = -0.5
    val d7 = 3.0

    val ts1 = new DoubleSeries(d1)
    val ts2 = new DoubleSeries(d2)
    val ts3 = new DoubleSeries(d3)
    val ts4 = new DoubleSeries(d4)

    ts1 * ts3 should be (Seq(-1.0, 10.0 -35.0, Double.NaN, Double.NaN))
    ts1 * ts2 should be (Seq(Double.NaN, Double.NaN, Double.NaN, Double.NaN, Double.NaN))
    ts1 * ts4 should be (Seq(-10.0, 30.0, 21.0, 50.0, -32.0))
    ts3 * d7 should be (Seq(-3.0, 6.0, -15.0))
    d5 * d6 should be (-0.5)
    d6 * d7 should be (-1.5)
  }

  // division
  it should "divide two series/double correctly" in {
    val d1 = Seq(1.0, 5.0, 7.0, 4.0, 10.0)
    val d2 = Seq()
    val d3 = Seq(-1.0,2.0,-5.0)
    val d4 = Seq(-10.0, 6.0, 3.0, 12.5, -3.2)
    val d5 = 1.0
    val d6 = -0.5
    val d7 = 3.0

    val ts1 = new DoubleSeries(d1)
    val ts2 = new DoubleSeries(d2)
    val ts3 = new DoubleSeries(d3)
    val ts4 = new DoubleSeries(d4)

    ts1/ts4 should be (Seq(-0.100000, 0.833333, 2.333333, 0.320000, -3.125000))
    ts1/ts2 should be (Seq(Double.NaN, Double.NaN, Double.NaN, Double.NaN, Double.NaN))
    ts1/ts3 should be (Seq(-1.0, 2.5, -1.4, Double.NaN, Double.NaN))
    ts3/d7 should be (Seq(-0.333333, 0.666667, -1.666667))
    d5/d6 should be (-2.0)
    ts2/d5 should be (Seq())
  }

  // less than
  // can only be the series that have the same size
  it should "return true/false for each double when series A < series B" in {
    val d1 = Seq(1.0, 5.0, 7.0, 4.0, 10.0)
    val d4 = Seq(-10.0, 6.0, 3.0, 12.5, -3.2)
    val d5 = 1.0
    val d6 = -0.5
    val d7 = 3.0

    val ts1 = new DoubleSeries(d1)
    val ts4 = new DoubleSeries(d4)

    ts1 < ts4 should be (Seq(false, true, false, true, false))
    ts4 < d7 should be (Seq(true, false, false, false, true))
    d5 < d7 should be (true)
    d5 < d6 should be (false)
    d5 < d5 should be (false)
  }

  // more than
  it should "return true/false for each double when series A > series B" in {
    val d1 = Seq(1.0, 5.0, 7.0, 4.0, 10.0)
    val d4 = Seq(-10.0, 6.0, 3.0, 12.5, -3.2)
    val d5 = 1.0
    val d6 = -0.5
    val d7 = 3.0

    val ts1 = new DoubleSeries(d1)
    val ts4 = new DoubleSeries(d4)

    ts1 > ts4 should be (Seq(true, false, true, false, true))
    ts1 > d7 should be (Seq(false, true, true, true, true))
    d5 > d7 should be (false)
    d5 > d6 should be (true)
    d5 > d5 should be (false)
  }




}
