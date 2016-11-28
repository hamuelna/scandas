import io.muic.scandas.series.StringSeries
import org.scalatest.{FlatSpec, Matchers}

import scala.collection.immutable.Vector

class StringSeriesTest extends FlatSpec with Matchers{
  "A StringSeries" should "concat the two string together" in{
    val a = new StringSeries(Seq("asd","dd", "fff", "aa"))
    val b = new StringSeries(Seq("fff", "kkk", "ddd", "sss"))
    a.toVector should be (Vector("asdfff", "ddkkk", "fffddd", "aasss"))
  }
}
