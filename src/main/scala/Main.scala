object Main extends App{
  import io.muic.scandas.adapter.DataLoader
  val wtf = DataLoader.readCSV("src/resources/data.csv")
  println(wtf._1)
}
