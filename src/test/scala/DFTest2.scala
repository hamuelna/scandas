import io.muic.scandas.dataframe.{DataFrame, Df}
import io.muic.scandas.series.{DoubleSeries, StringSeries}
import org.scalatest.{FlatSpec, Matchers}

import scala.collection.Map

class DFTest2 extends FlatSpec with Matchers{
  val d0 = Seq(Seq("Ham", "Karn", "May", "Ice", "Nuch"),
    Seq(1.1, 1.2, 1.3, 1.4, 1.5))
  val c0 = Seq("Name", "Numbers")
  val df0 = Df(d0, c0)
  val dfsp = Df("src/resources/data.csv")
  "A DataFrame" should "do boolean index also" in {
    df0.boolIdx(df0.getNumCol("Numbers") < 1.4).getCol("Name").toVector should contain only ("Ham", "Karn", "May")
  }

  "A DataFrame" should "parse csv file and do a lot of stuff" in {
    dfsp.datalen should be (30697)
    dfsp.boolIdx(dfsp.getCol("action_type") == "Jump Shot").datalen should be (18880)
    dfsp.getNumCol("minutes_remaining").mean() should be (4.9 +- 0.2)
  }

  "A DataFrame" should "find the max value of all columns" in {
    val dfspMax = dfsp.max
    dfspMax("minutes_remaining") should be (11)
    dfspMax("seconds_remaining") should be (59)
//    dfspMax("combined_shot_type") should be ("Jump Shot")
  }

  "A DataFrame" should "find the min value of all columns" in {
    val dfspMin = dfsp.min
    dfspMin("minutes_remaining") should be (0)
    dfspMin("seconds_remaining") should be (0)
//    dfspMin("combined_shot_type") should be ("Bank Shot")
  }

  "A DataFrame" should "find the mean value of all Numeric Columns" in {
    val df = Df("src/resources/data.csv")
    val dfspMean = df.mean
    dfspMean("minutes_remaining") should be (4.88 +- 0.1)
    dfspMean("seconds_remaining") should be (28.36 +- 0.2)
    dfspMean("shot_distance") should be (13.43 +- 0.1)
  }

  "A DataFrame" should "find the standard deviation of all Numeric Columns" in {
    val df = Df("src/resources/data.csv")
    val dfspStd = df.std
    dfspStd("minutes_remaining") should be (3.44 +- 0.1)
    dfspStd("seconds_remaining") should be (17.47 +- 0.1)
    dfspStd("shot_distance") should be (9.37 +- 0.1)
  }

}
