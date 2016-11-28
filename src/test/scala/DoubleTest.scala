import io.muic.scandas.series.{DoubleSeries, NumericSeries}
import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by nattakarnklongyut on 11/28/16.
  */
class DoubleTest extends FlatSpec with Matchers {

  "A series" should "do a lot of stuff such as element wise stuff" in {
    val d = Seq(1.0, 5.0, 7.0, 4.0, 10.0)
    val d2 = Seq(2.0, 3.0, 5.0, 7.0, 9.0)
    val d3 = Seq()

    val ts1 = new DoubleSeries(d)
    val ts2 = new DoubleSeries(d2)
    val ts3 = new DoubleSeries(d3)

    ts1.toVector should be(d)
    ts2.toVector should be(d2)
    ts3.toVector should be(Seq())
  }

  it should "make series absolute" in {

    val d = Seq(1.0, 5.0, 7.0, 4.0, 10.0)
    val d2 = Seq()
    val d3 = Seq(-1.0,2.0,-5.0)

    val ts1 = new DoubleSeries(d)
    val ts2 = new DoubleSeries(d2)
    val ts3 = new DoubleSeries(d3)

    ts1.abs should be (Seq(1.0, 5.0, 7.0, 4.0, 10.0))
    ts2.abs should be (Seq())
    ts3.abs should be (Seq(1.0, 2.0, 5.0))
  }

  it should "plus two series/double correctly" in {

    val d = Seq(1.0, 5.0, 7.0, 4.0, 10.0)
    val d2 = Seq()
    val d3 = Seq(-1.0,2.0,-5.0)
    val d4 = Seq(-10.0, 6.0, 3.0, 12.5, -3.2)
    val d5 = 1.0
    val d6 = -0.5
    val d7 = 3.0

    val ts1 = new DoubleSeries(d)
    val ts2 = new DoubleSeries(d2)
    val ts3 = new DoubleSeries(d3)
    val ts4 = new DoubleSeries(d4)

    ts1+ts2 should be (Seq(1.0, 5.0, 7.0, 4.0, 10.0))
    ts1+ts3 should be (Seq(-11.0, 8.0, -2.0, Double.NaN, Double.NaN))
    ts3+ts4 should be (Seq(-9.0, 11.0, 10.0, 16.5, 6.8))
    ts4+d7 should be (Seq(-7.0, 9.0, 6.0, 15.5, -0.2))
    ts2+d7 should be (Seq())
    d5+d6 should be (0.5)
    d5+d7 should be (4.0)
  }

  it should "divide two series/double correctly" in {
    val d = Seq(1.0, 5.0, 7.0, 4.0, 10.0)
    val d2 = Seq()
    val d3 = Seq(-1.0,2.0,-5.0)
    val d4 = Seq(-10.0, 6.0, 3.0, 12.5, -3.2)
    val d5 = 1.0
    val d6 = -0.5
    val d7 = 3.0


    val ts1 = new DoubleSeries(d)
    val ts2 = new DoubleSeries(d2)
    val ts3 = new DoubleSeries(d3)

  }



}
