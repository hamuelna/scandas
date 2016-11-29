import io.muic.scandas.series.{DoubleSeries}
import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by nattakarnklongyut on 11/28/16.
  */
class DoubleTest extends FlatSpec with Matchers {

  val ts1 = new DoubleSeries(Seq(0.192, 0.622, 0.438, 0.785, 0.78))
  val ts2 = new DoubleSeries(Seq(0.273, 0.276, 0.802, 0.958, 0.876))
  val ts3 = new DoubleSeries(Seq(0.358, 0.501, 0.683, 0.713))
  val ts4 = new DoubleSeries(Seq())


  // plus
  it should "plus two series/double correctly" in {
    (ts1 + ts2).toVector should be (Vector(0.465, 0.898, 1.24, 1.7429999999999999, 1.6560000000000001))
    (ts1 + 5).toVector should be (Vector(5.192, 5.622, 5.438, 5.785, 5.78))
//    (ts1 + ts3).toVector should be (Vector(0.55, 1.123, 1.121, 1.498, Double.NaN))
//    (ts3 + ts4).toVector should be (Vector(Double.NaN, Double.NaN, Double.NaN, Double.NaN))
    (5.0 + 6.0) should be (11.0)

  }

  // minus
  it should "minus two series/double correctly" in {
    (ts1 - ts2).toVector should be (Vector(-0.08100000000000002, 0.346, -0.36400000000000005, -0.17299999999999993, -0.09599999999999997))
    (ts1 - 5).toVector should be (Vector(-4.808, -4.378, -4.562, -4.215, -4.22))
//    (ts1 - ts3).toVector should be (Vector(-0.16599999999999998, 0.121, -0.24500000000000005, 0.07200000000000006, Double.NaN))
//    (ts3 - ts4).toVector should be (Vector(Double.NaN, Double.NaN, Double.NaN, Double.NaN))
    (5.0 - 6.0) should be (-1.0)
  }

  // multiply
  it should "multiply two series/double together" in {
    (ts1 * ts2).toVector should be (Vector(0.052416000000000004, 0.17167200000000002, 0.35127600000000003, 0.75203, 0.68328))
    (ts1 * 5).toVector should be (Vector(0.96, 3.11, 2.19, 3.9250000000000003, 3.9000000000000004))
//    (ts1 * ts3).toVector should be (Vector(0.068736, 0.311622, 0.29915400000000003, 0.559705, Double.NaN))
//    (ts3 * ts4).toVector should be (Vector(Double.NaN, Double.NaN, Double.NaN, Double.NaN))
    (5.0 * 6.0) should be (30.0)
  }

  // division
  it should "divide two series/double together" in {
    (ts1 / ts2).toVector should be (Vector(0.7032967032967032, 2.253623188405797, 0.5461346633416458, 0.8194154488517746, 0.8904109589041096))
    (ts1 / 5).toVector should be (Vector(0.038400000000000004, 0.1244, 0.0876, 0.157, 0.156))
//    (ts1 / ts3).toVector should be (Vector(0.5363128491620112, 1.2415169660678642, 0.6412884333821376, 1.1009817671809257, Double.NaN))
//    (ts3 / ts4).toVector should be (Vector(Double.NaN, Double.NaN, Double.NaN, Double.NaN))
    (0.0 / 6.0) should be (0.0)
  }

  // median
  it should "return median of the series" in {
    ts1.median() should be (0.622)
    ts2.median() should be (0.802)
    ts3.median() should be (0.5920000000000001)
//    ts4.median() should be (Double.NaN)
  }

  // mean
  it should "return mean value of the series" in {
    ts1.mean() should be (0.5634)
    ts2.mean() should be (0.637)
    ts3.mean() should be (0.56375)

  }

  // mode
  it should "return mode value of the series" in {
    val ts = new DoubleSeries(Seq(0.438, -0.622, 0.438, 0.785, -0.78))
    val ts1 = new DoubleSeries(Seq(0.438, -0.622, 0.438, 0.785, 0.785))
    ts.mode() should be (0.438)
//    ts1.mode() should  be (Seq(0.438, 0.785))
  }

  // absolute
  it should "return absolute value of series" in {
    val ts = new DoubleSeries(Seq(0.192, -0.622, 0.438, 0.785, -0.78))
    ts.abs().toVector should be (Vector(0.192, 0.622, 0.438, 0.785, 0.78))
  }

  // max
  it should "return max value of series" in {
    ts1.max() should be (0.785)
    ts3.max() should be (0.713)
  }

  // argMax
  it should "return index of max value" in {
    ts1.argMax() should be (3)
    ts3.argMax() should be (3)
  }

  // min
  it should "return min value of series" in {
    ts1.min() should be (0.192)
    ts3.min() should be (0.358)
  }

  // argMin
  it should "return index of min value" in {
    ts1.argMin() should be (0)
    ts3.argMin() should be (0)
  }

  // sum
  it should "sum all numbers in series" in {
    ts1.sum() should be (2.817)
    ts3.sum() should be (2.255)
  }

  // nonzero
  it should "return number that's not zero in the series" in {
    val ts = new DoubleSeries(Seq(0.0, 1.23, 0.44, 0.0, 0.0))
    ts.nonzero().toVector should be(Vector(1.23, 0.44))
  }

  // more than
  it should "return boolean of A > B" in {
    (ts1 > ts2).toVector should be (Vector(false, true, false, false, false))
    (-0.4 > 5) should be (false)
    (5 > 5) should be (false)
  }

  // more than or equal
  it should "return boolean of A >= B" in {
    (ts1 >= ts2).toVector should be (Vector(false, true, false, false, false))
    (-0.4 >= 5) should be (false)
    (5 >= 5) should be (true)
  }

  // less than
  it should "return boolean of A < B" in {
    (ts1 < ts2).toVector should be (Vector(true, false, true, true, true))
    (-0.4 < 5) should be (true)
    (5 < 5) should be (false)
  }

  // less than or equal
  it should "return boolean of A <= B" in {
    (ts1 <= ts2).toVector should be (Vector(true, false, true, true, true))
    (-0.4 <= 5) should be (true)
    (5 <= 5) should be (true)
  }





}
