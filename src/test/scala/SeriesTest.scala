import io.muic.scandas.core.ScException.DiffDimException
import io.muic.scandas.core.Series
import org.scalatest.{FlatSpec, Matchers}

class SeriesTest extends FlatSpec with Matchers{

  "A series" should "do a lot of stuff such as element wise stuff" in {
    val d = Vector(1.0,5.0,7.0,4.0,10.0)
    val d2 = Vector(2.0, 3.0, 5.0, 7.0, 9.0)
    val d3 = Vector(-1.0, 2.0, -3.0, 4.0)
    val ts1 = new Series(d)
    val ts2 = new Series(d2)
    val ts3 = new Series(d3)

    ts1.toVector should be (d)
    ts2.toVector should be (d2)
    (ts1 + ts2).toVector should be (Vector(3.0, 8.0, 12.0, 11, 19))
    (ts1 * ts2).toVector should be (Vector(2.0, 15.0, 35.0, 28.0, 90.0))
    ts3.abs.toVector should be (Vector(1.0, 2.0, 3.0, 4.0 ))
    (ts1 + ts3).toVector shouldBe a [Vector[_]]
  }

  "A series" should "do boolean indexing too" in {
    val d = Array(1.0, 2.0 ,3.0, 4.0, 5.0)
  }

}
