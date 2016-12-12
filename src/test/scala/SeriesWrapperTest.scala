import io.muic.scandas.series.{DoubleSeries, Series, StringSeries}
import org.scalatest.{FlatSpec, Matchers}

class SeriesWrapperTest extends FlatSpec with Matchers{

  val test = Seq(1.0, 2.0 ,3.0 ,4.0, 5.0)
  val t2 = Seq("I", "love", "chicken", "super")
  "Series object" should "cast type correctly" in {
    val test = Series(this.test)
    val test2 = Series(t2)
    test shouldBe a [DoubleSeries]
    test2 shouldBe a [StringSeries]
  }

}
