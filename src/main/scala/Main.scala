import io.muic.scandas.dataframe.Df
import io.muic.scandas.series.{DoubleSeries, NumericSeries, Series}

object Main extends App{
  val test1 = Df("src/resources/data.csv")
  val temp = Seq(test1.getNumCol("lat"), test1.getNumCol("lon"), test1.getNumCol("period"))
  println(temp.filter(x => x.isInstanceOf[NumericSeries]))
  println(test1.getNumCol("lat").mean())
}
