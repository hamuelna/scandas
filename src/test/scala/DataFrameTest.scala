import io.muic.scandas.dataframe.DataFrame
import io.muic.scandas.series.{DoubleSeries, StringSeries}
import org.scalatest.{FlatSpec, Matchers}

class DataFrameTest extends FlatSpec with Matchers{
  val d0 = Seq( Seq("Ham", "Karn", "May", "Ice", "Nuch"),
                Seq(1.1, 1.2, 1.3, 1.4, 1.5))
  val c0 = Seq("Name", "Numbers")
  val df0 = DataFrame.fromSeq(d0, c0)

  "A DataFrame" should "return a series col" in {
    df0.getCol("Name").toVector should be (Vector("Ham", "Karn", "May", "Ice", "Nuch"))
    df0.getCol("Name") shouldBe a [StringSeries]
    df0.getCol("Numbers") shouldBe a [DoubleSeries]
  }

}
