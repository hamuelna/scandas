import io.muic.scandas.dataframe.DataFrame
import io.muic.scandas.series.{DoubleSeries, StringSeries}
import org.scalatest.{FlatSpec, Matchers}

import scala.collection.Map

class DFTest2 extends FlatSpec with Matchers{
  val d0 = Seq(Seq("Ham", "Karn", "May", "Ice", "Nuch"),
    Seq(1.1, 1.2, 1.3, 1.4, 1.5))
  val c0 = Seq("Name", "Numbers")
  val df0 = DataFrame.fromSeq(d0, c0)

  "A DataFrame" should "do boolean index also" in {
    df0.boolIdx(df0.getNumCol("Numbers") < 1.4).getCol("Name").toVector should contain allOf ("Ham", "Karn", "May")
  }

}
