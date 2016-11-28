import io.muic.scandas.core.ScException.DiffDimException
import io.muic.scandas.series.NumericSeries
import org.scalatest.{FlatSpec, Matchers}

import scala.collection.mutable

class NumericSeriesTest extends FlatSpec with Matchers {


  "A series" should "do a lot of stuff such as element wise stuff" in {
    val d = Vector(1.0, 5.0, 7.0, 4.0, 10.0)
    val d2 = Vector(2.0, 3.0, 5.0, 7.0, 9.0)

    val ts1 = new NumericSeries(d)
    val ts2 = new NumericSeries(d2)
//
//    val d3 = Vector()
//    val ts1 = new Series(d)
//    val ts2 = new Series(d2)
//    val ts3 = new Series(d3)

    ts1.toVector should be(d)
    ts2.toVector should be(d2)
    ts3.toVector should be(Vector())
  }

  /// checked!
  it should "become absolute number" in {
    val d = Vector(-1.0, 2.0, -3.0, 4.0, -5.0)

    val ts1 = new NumericSeries(d)
//    val d2 = Vector(1, 3, Double.NaN)
//    val d3 = Vector()
//
//    val ts1 = new Series(d)
//    val ts2 = new Series(d2)
//    val ts3 = new Series(d3)

    ts1.abs.toVector should be(Vector(1.0, 2.0, 3.0, 4.0, 5.0))
    ts2.abs.toVector should be(Vector(1, 3, Double.NaN))
    ts3.abs.toVector should be(Vector())
  }


  /// checked!
  it should "plus each series together" in {
    val d = Vector(1.0, 5.0, 7.0, 4.0, 10.0)
    val d2 = Vector(-1.0, 2.0, -3.0, 4.0, -5.0)
    val d3 = Vector(1, 2, 3, 4)
    val d4 = Vector(3, 2, 5, 6)
    val d5 = Vector(3, 2, 1)

    val ts1 = new NumericSeries(d)
    val ts2 = new NumericSeries(d2)
    val ts3 = new NumericSeries(d3)
    val ts4 = new NumericSeries(d4)
    val ts5 = new NumericSeries(d5)
    (ts1 + ts2).toVector should be(Vector(0.0, 7.0, 4.0, 8.0, 5.0))
    (ts3 + ts4).toVector should be(Vector(4, 4, 8, 10))
    (ts3 + ts5).toVector should contain (4.0, Double.NaN)

//    val d6 = Vector(1, 2, Double.NaN)
//    val d7 = Vector(1, 2, Double.NaN)
//    val d8 = Vector()
//    val d9 = Vector("A", "B", "C")
//    val d10 = Vector("D", "D")
//
//    val ts1 = new Series(d)
//    val ts2 = new Series(d2)
//    val ts3 = new Series(d3)
//    val ts4 = new Series(d4)
//    val ts5 = new Series(d5)
//    val ts6 = new Series(d6)
//    val ts7 = new Series(d7)
//    val ts8 = new Series(d8)
//    val ts9 = new Series(d9)
//    val ts10 = new Series(d10)
//
//    (ts1 + ts2).toVector should be(Vector(0.0, 7.0, 4.0, 8.0, 5.0))
//    (ts3 + ts4).toVector should be(Vector(4, 4, 8, 10))
//    (ts3 + ts5).toVector should be(Vector(4.0, 4.0, 4.0, Double.NaN))
//    (ts6 + ts7).toVector should be(Vector(2.0, 4.0, Double.NaN))
//    (ts6 + ts5).toVector should be(Vector(4.0, 4.0, Double.NaN))
//    (ts6 + ts8).toVector should be(Vector(Double.NaN, Double.NaN, Double.NaN))
//    // only can add String and String together
//    (ts9 + ts10).toVector should be(Vector("AD", "BD", Double.NaN))

  }

  /// checked!
  it should "minus each other" in {
    val d = Vector(1.0, 5.0, 7.0, 4.0, 10.0)
    val d2 = Vector(-1.0, 2.0, -3.0, 4.0, -5.0)
    val d3 = Vector(3, 6, 5)

    val ts1 = new NumericSeries(d)
    val ts2 = new NumericSeries(d2)
    val ts3 = new NumericSeries(d3)

//    val d4 = Vector(1, 2, Double.NaN)
//    val d5 = Vector(1, 2, Double.NaN)
//    val d6 = Vector()
//
//    val ts1 = new Series(d)
//    val ts2 = new Series(d2)
//    val ts3 = new Series(d3)
//    val ts4 = new Series(d4)
//    val ts5 = new Series(d5)
//    val ts6 = new Series(d6)


    (ts1 - ts2).toVector should be(Vector(2.0, 3.0, 10.0, 0.0, 15.0))
    (ts2 - ts3).toVector should be(Vector(-4.0, -4.0, -8.0, Double.NaN, Double.NaN))
    (ts4 - ts5).toVector should be(Vector(0.0, 0.0, Double.NaN))
    (ts4 - ts3).toVector should be(Vector(-2.0, -4.0, Double.NaN))
    (ts3 - ts6).toVector should be(Vector(Double.NaN, Double.NaN, Double.NaN))
  }

  //// checked!
  it should "multiply each other" in {
    val d = Vector(1.0, 5.0, 7.0, 4.0, 10.0)
    val d2 = Vector(-1.0, 2.0, -3.0, 4.0, -5.0)
    val d3 = Vector(3, 6, 5)

    val ts1 = new NumericSeries(d)
    val ts2 = new NumericSeries(d2)
    val ts3 = new NumericSeries(d3)
    (ts1 * ts2).toVector should be(Vector(-1.0, 10.0, -21.0, 16.0, -50.0))
    (ts2 * ts3).toVector should contain (-3.0, 12.0, -15.0)
//
//    val d4 = Vector(1, 2, Double.NaN)
//    val d5 = Vector(1, 2, Double.NaN)
//    val d6 = Vector()
//    val d7 = Vector("A", "B", "C")
//    val d8 = Vector(-1, 2, 3)
//    val d9 = Vector(1, 2, 3, 4)
//
//    val ts1 = new Series(d)
//    val ts2 = new Series(d2)
//    val ts3 = new Series(d3)
//    val ts4 = new Series(d4)
//    val ts5 = new Series(d5)
//    val ts6 = new Series(d6)
//    val ts7 = new Series(d7)
//    val ts8 = new Series(d8)
//    val ts9 = new Series(d9)
//
//    (ts1 * ts2).toVector should be(Vector(-1.0, 10.0, -21.0, 16.0, -50.0))
//    (ts2 * ts3).toVector should be(Vector(-3.0, 12.0, -15.0, Double.NaN, Double.NaN))
//    (ts4 * ts5).toVector should be(Vector(1.0, 4.0, Double.NaN))
//    (ts4 * ts3).toVector should be(Vector(3.0, 12.0, Double.NaN))
//    (ts6 * ts4).toVector should be(Vector(Double.NaN, Double.NaN, Double.NaN))
//    /// only can be multiplied by Int
//    (ts8 * ts7).toVector should be(Vector(" ", "BB", "CCC"))
//    (ts9 * ts7).toVector should be(Vector("A", "BB", "CCC", Double.NaN))
  }


  //checked!!!!
  it should "divide series A by series B" in {
    val d = Vector(1.0, 10.0, 7.0, 4.0, 0.0)
    val d2 = Vector(-1.0, 2.0, -2.0, 0.0, -5.0)
    val d3 = Vector(3, 6, 7)

    val ts1 = new NumericSeries(d)
    val ts2 = new NumericSeries(d2)
    val ts3 = new NumericSeries(d3)
    (ts1 / ts2).toVector should contain (-1.0, 5.0, -3.5, Double.NaN, 0.0)
//
//    val d4 = Vector(1, 2, Double.NaN)
//    val d5 = Vector(1, 2, Double.NaN)
//    val d6 = Vector(6, 6, Double.NaN)
//    val d7 = Vector()
//
//    val ts1 = new Series(d)
//    val ts2 = new Series(d2)
//    val ts3 = new Series(d3)
//    val ts4 = new Series(d4)
//    val ts5 = new Series(d5)
//    val ts6 = new Series(d6)
//    val ts7 = new Series(d7)
//
//    (ts1 / ts2).toVector should be(Vector(-1.0, 5.0, -3.5, Double.NaN, -0.0))

    (ts3 / ts1).toVector should be(Vector(3.0, 0.6, 1.0, Double.NaN, Double.NaN))
    (ts4 / ts5).toVector should be(Vector(1.0, 1.0, Double.NaN))
    (ts3 / ts5).toVector should be(Vector(3.0, 3.0, Double.NaN))
    (ts6 / ts3).toVector should be(Vector(2.0, 1.0, Double.NaN))
    (ts6 / ts7).toVector should be(Vector(Double.NaN, Double.NaN, Double.NaN))
  }



}




