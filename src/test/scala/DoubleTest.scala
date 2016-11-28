import io.muic.scandas.series.{DoubleSeries, NumericSeries}
import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by nattakarnklongyut on 11/28/16.
  */
class DoubleTest extends FlatSpec with Matchers {
  "A series" should "do a lot of stuff such as element wise stuff" in {
    val d = Vector(1.0, 5.0, 7.0, 4.0, 10.0)
    val d2 = Vector(2.0, 3.0, 5.0, 7.0, 9.0)
    val d3 = Vector()

    val ts1 = new DoubleSeries(d)
    val ts2 = new DoubleSeries(d2)
    val ts3 = new DoubleSeries(d3)

    ts1.toVector should be(d)
    ts2.toVector should be(d2)
    ts3.toVector should be(Vector())
  }

}
