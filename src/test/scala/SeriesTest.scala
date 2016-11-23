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
    val d3 = Vector(1, 2, 3, 4)
    val d4 = Vector(3, 2, 5, 6)
    val d5 = Vector(3, 2, 1)
    val ts1 = new Series(d)
    val ts2 = new Series(d2)
    val ts3 = new Series(d3)
    val ts4 = new Series(d4)
    val ts5 = new Series(d5)
    (ts1 + ts2).toVector should be(Vector(0.0, 7.0, 4.0, 8.0, 5.0))
    (ts3 + ts4).toVector should be(Vector(4, 4, 8, 10))
    (ts3 + ts5).toVector should be(Vector(6.0, 4.0, 6.0, Double.NaN))

<<<<<<< HEAD
=======
    ts1.toVector should be (d)
    ts2.toVector should be (d2)
    (ts1 + ts2).toVector should be (Vector(3.0, 8.0, 12.0, 11, 19))
    (ts1 * ts2).toVector should be (Vector(2.0, 15.0, 35.0, 28.0, 90.0))
    ts3.abs.toVector should be (Vector(1.0, 2.0, 3.0, 4.0 ))
    (ts1 + ts3).toVector shouldBe a [Vector[_]]
>>>>>>> master
  }

  it should "minus each other" in {
    val d = Vector(1.0, 5.0, 7.0, 4.0, 10.0)
    val d2 = Vector(-1.0, 2.0, -3.0, 4.0, -5.0)
    val d3 = Vector(3, 6, 5)
    val ts1 = new Series(d)
    val ts2 = new Series(d2)
    val ts3 = new Series(d3)
    (ts1 - ts2).toVector should be(Vector(-2.0, 3.0, 10.0, 0.0, 15.0))
    (ts2 - ts3).toVector should be(Vector(-4.0, -4.0, -8.0, Double.NaN, Double.NaN))
  }

  it should "multiply each other" in {
    val d = Vector(1.0, 5.0, 7.0, 4.0, 10.0)
    val d2 = Vector(-1.0, 2.0, -3.0, 4.0, -5.0)
    val d3 = Vector(3, 6, 5)
    val ts1 = new Series(d)
    val ts2 = new Series(d2)
    val ts3 = new Series(d3)
    (ts1 * ts2).toVector should be(Vector(-1.0, 10.0, -21.0, 16.0, -50.0))
    (ts2 * ts3).toVector should be(Vector(-3.0, 12.0, -15.0, Double.NaN, Double.NaN))
  }

  it should "divide series A by series B" in {
    val d = Vector(1.0, 10.0, 7.0, 4.0, 0.0)
    val d2 = Vector(-1.0, 2.0, -2.0, 0.0, -5.0)
    val d3 = Vector(3, 6, 7)
    val ts1 = new Series(d)
    val ts2 = new Series(d2)
    val ts3 = new Series(d3)
    (ts1 / ts2).toVector should be(Vector(-1.0, 5.0, -3.5, Double.NaN, 0.0))
    (ts3 / ts1).toVector should be(Vector(3.0, 0.6, 1.0, Double.NaN, Double.NaN))
  }



}




