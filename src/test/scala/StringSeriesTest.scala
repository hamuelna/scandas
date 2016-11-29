import io.muic.scandas.series.StringSeries
import org.scalatest.{FlatSpec, Matchers}

import scala.collection.immutable.Vector

class StringSeriesTest extends FlatSpec with Matchers{
  val d0 = new StringSeries(Seq("asd","dd", "fff", "aa"))
  val d1 = new StringSeries(Seq("fff", "kkk", "ddd", "sss"))

  "A StringSeries" should "concat the two string together" in{
    (d0+d1).toVector should be (Vector("asdfff", "ddkkk", "fffddd", "aasss"))
  }
  "A StringSeries" should "compare the two strings" in {
    (d0 > d1).toVector should be (Vector(false, false, true, false))
    (d0 >= d1).toVector should be (Vector(false, false, true, false))
    (d0 == d1).toVector should be (Vector(false, false, false, false))
    (d0 < d1).toVector should be (Vector(true, true, false, true))
    (d0 <= d1).toVector should be (Vector(true, true, false, true))
  }
  "A StringSeries" should "Multiply the Strings" in {
    (d0*3).toVector should be (Vector("asdasdasd", "dddddd", "fffffffff", "aaaaaa"))
    (d1*4).toVector should be (Vector("ffffffffffff", "kkkkkkkkkkkk", "dddddddddddd", "ssssssssssss"))
  }
  "A StringSeries" should "Sort the String" in {
    d0.sort_value().toVector should be (Vector("aa", "asd", "dd", "fff"))
    d1.sort_value().toVector should be (Vector("ddd", "fff", "kkk", "sss"))
  }
  "A StringSeries" should "do boolean indexing" in {
    val spd0 = new StringSeries(Seq("nok", "nok", "noi", "noi", "nat", "hamuel"))
    spd0.boolIdx(spd0 == "nok").toVector should be (Vector("nok", "nok"))
    spd0.boolIdx(spd0 > "m").toVector should be (Vector("nok", "nok", "noi", "noi", "nat"))
    spd0.boolIdx(spd0 == "noi" && spd0 > "m").toVector should be (Vector("noi", "noi"))
  }


}
