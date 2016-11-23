import io.muic.scandas.core.ScException.DiffDimException
import io.muic.scandas.core.Series
import org.scalatest.{FlatSpec, Matchers}

import scala.collection.mutable

class SeriesTest extends FlatSpec with Matchers {

  "A series" should "do a lot of stuff such as element wise stuff" in {
    val d = Vector(1.0, 5.0, 7.0, 4.0, 10.0)
    val d2 = Vector(2.0, 3.0, 5.0, 7.0, 9.0)
    val ts1 = new Series(d)
    val ts2 = new Series(d2)
    ts1.toVector should be(d)
    ts2.toVector should be(d2)
  }

  it should "become absolute number" in {
    val d = Vector(-1.0, 2.0, -3.0, 4.0, -5.0)
    val ts1 = new Series(d)
    ts1.abs.toVector should be(Vector(1.0, 2.0, 3.0, 4.0, 5.0))
  }

  it should "plus each series together" in {
    val d = Vector(1.0, 5.0, 7.0, 4.0, 10.0)
    val d2 = Vector(-1.0, 2.0, -3.0, 4.0, -5.0)
    val ts1 = new Series(d)
    val ts2 = new Series(d2)
    (ts1 + ts2).toVector should be(Vector(0.0, 7.0, 4.0, 8.0, 5.0))
  }

  it should "minus each other" in {
    val d = Vector(1.0, 5.0, 7.0, 4.0, 10.0)
    val d2 = Vector(-1.0, 2.0, -3.0, 4.0, -5.0)
    val ts1 = new Series(d)
    val ts2 = new Series(d2)
    (ts1 - ts2).toVector should be(Vector(-2.0, 3.0, 10.0, 0.0, 15.0))
  }

  it should "multiply each other" in {
    val d = Vector(1.0, 5.0, 7.0, 4.0, 10.0)
    val d2 = Vector(-1.0, 2.0, -3.0, 4.0, -5.0)
    val ts1 = new Series(d)
    val ts2 = new Series(d2)
    (ts1 * ts2).toVector should be(Vector(-1.0, 10.0, -21.0, 16.0, -50.0))
  }

  it should "divide series A by series B" in {
    val d = Vector(1.0, 10.0, 7.0, 4.0, 0.0)
    val d2 = Vector(-1.0, 2.0, -2.0, 0.0, -5.0)
    val ts1 = new Series(d)
    val ts2 = new Series(d2)
    (ts1 / ts2).toVector should be(Vector(-1.0, 5.0, -3.5, Double.NaN, 0.0))
  }



}




