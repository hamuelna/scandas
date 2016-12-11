import io.muic.scandas.dataframe.{DataFrame, Df}
import io.muic.scandas.series.{DoubleSeries, StringSeries}
import org.scalatest.{FlatSpec, Matchers}

import scala.collection.Map

class DFTest2 extends FlatSpec with Matchers{
  val d0 = Seq(Seq("Ham", "Karn", "May", "Ice", "Nuch"),
    Seq(1.1, 1.2, 1.3, 1.4, 1.5))
  val c0 = Seq("Name", "Numbers")
  val df0 = Df(d0, c0)
  "A DataFrame" should "do boolean index also" in {
    df0.boolIdx(df0.getNumCol("Numbers") < 1.4).getCol("Name").toVector should contain allOf ("Ham", "Karn", "May")
  }

  "A DataFrame" should "parse csv file and do a lot of stuff" in {
    val dfsp = Df("src/resources/data.csv")
    dfsp.datalen should be (30697)
    dfsp.boolIdx(dfsp.getCol("action_type") == "Jump Shot").datalen should be (18880)
    dfsp.getNumCol("minutes_remaining").mean() should be (4.9 +- 0.2)


  }

}
