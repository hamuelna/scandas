package io.muic.scandas.adapter
import scala.io.Source
import scala.collection.mutable.Map
import scala.collection.immutable.Vector
import scala.util.Try
import org.json4s.DefaultFormats
import org.json4s.jackson.JsonMethods._

object DataLoader {
  /// return (Hashmap[columnname,String], Hashmap[columnname,Vector[String]] => data)
  //type => "Double" , "Int", "String"
  def readCSV(path: String): (Map[String,String],Map[String,Vector[_]]) ={
    val lines = Source.fromFile(path).getLines()

    //* doing head *//
    val header:Map[Int,String] = Map()
    val dataframe:Map[String,Vector[_]] = Map()
    val columntype:Map[String,String] = Map()
    var columnsize = 0
    lines.next().split(",").foreach{
      head => {
        header(columnsize) = head
        columntype(head)= "Nil"
        dataframe(head) = Vector()
        columnsize+=1

      }
    }


    //* doing with data *//

    lines.foreach{
      line => {
        val templst = line.split(",")
        (0 to columnsize-1).foreach{
          num => {
            lazy val head = header.get(num).get
            var previousvector = dataframe.get(head).get
            //* do typing *//

              val previoustype = columntype.get(head).get
              val data = changetype(templst(num),previoustype)
              if(data._2 != previoustype){

                // need to get previousvector and change it to the new type
                previousvector = previousvector.map{
                  d => changetype(d,data._2)._1
                }
                // change the columntype to collect the new type
                columntype(head) = data._2

              }

            /////////////////
            dataframe(head) = previousvector:+ data._1 // add new casting data to hashmap
          }
        }
      }
    }

    //////////////////////////
    (columntype,dataframe)


    //* testing *//
      //* header test *//
//      columntype.keySet.foreach{
//        head => println(columntype(head),head)
//      }
      ///////////////////

      //* data test *//
//        dataframe.keySet.foreach{
//          head => println(head,dataframe(head)(0))
//        }
      /////////////////

    ///////////////
  }

  def readJSON(path: String):(Map[String,String],Map[String,Vector[_]]) ={
    val lines = Source.fromFile(path).getLines.mkString
    val JSON = parse(lines)

    //* doing head *//
    val header:Map[Int,String] = Map()
    val dataframe:Map[String,Vector[_]] = Map()
    val columntype:Map[String,String] = Map()
    var columnsize = 0
    val head = JSON(0).foldField(List(): List[String])((l, t) => t._1 :: l).reverse
    head.foreach{
      head => {
        header(columnsize) = head
        columntype(head)= "Nil"
        dataframe(head) = Vector()
        columnsize+=1

      }
    }

    // get all data to store in dataframe
    (0 to columnsize-1).foreach( index => {
      val head = header.get(index).get
      var Jdata = (JSON \\ head).children
      implicit val formats = DefaultFormats
      var vectorstring = Jdata.map(x=> x.extract[String]).toVector
      dataframe(head) = vectorstring
    })

    (0 to columnsize-1).foreach{
      index => {
        val field = header.get(index).get
        val vec = dataframe.get(field).get
        var new_vec:Vector[_] = Vector()
        vec.foreach{
          data => {
            val previoustype = columntype.get(field).get
            val new_data = changetype(data,previoustype)
            if(new_data._2 != previoustype){
              // need to get previousvector and change it to the new type
              new_vec = new_vec.map{
                d => changetype(d,new_data._2)._1
              }
              // change the columntype to collect the new type
              columntype(field) = new_data._2
            }
            new_vec = new_vec:+ new_data._1
          }
        }
        dataframe(field) = new_vec
      }
    }

    //////////////////////////
    (columntype,dataframe)


    //* testing *//
    //* header test *//
    //      columntype.keySet.foreach{
    //        head => println(columntype(head),head)
    //      }
    ///////////////////

    //* data test *//
    //        dataframe.keySet.foreach{
    //          head => println(head,dataframe(head)(1))
    //        }
    /////////////////
    //    val test = Vector("1","2","Ab")
    //    var p = "Nil"
    //    var new_test:Vector[_] = Vector()
    //    test.foreach(data => {
    //      val previoustype = p
    //      val new_data = changetype(data,previoustype)
    //      if(new_data._2 != previoustype){
    //        // need to get previousvector and change it to the new type
    //        new_test = new_test.map{
    //          d => changetype(d,new_data._2)._1
    //        }
    //        // change the columntype to collect the new type
    //        //columntype(head) = new_data._2
    //        p = new_data._2
    //      }
    //
    //      /////////////////
    //      new_test = new_test:+ new_data._1
    //    })
    //    println(new_test)
    //    println(p)
    ///////////////

  }


  def changetype[T](S: T ,Type: String): (_,String) ={
    def isNumeric(S:String): Try[Int] = {
      Try(S.toInt)
    }
    def isDouble(S:String): Try[Double] = {
      Try(S.toDouble)
    }
    // case if it is Int && s == NA , N/A , na , Na => cast to Double

    // case if it is Int / Double & but failed both => change to String

    // case if it is Int but failed to cast to Int but can cast to double => cast to Double

    def change(Type:String): (_,String) = Type match {
      case "Nil" => change("Int")
      case "Int" => {
            val Num = isNumeric(S.asInstanceOf[String])
            if(Num.isSuccess){
              (Num.get,"Int")
            }
            else{
              change("Double")
            }
          }
      case "Double" => S match {
        case _:Int => (S.asInstanceOf[Int].toDouble,"Double")
        case _:String => {

            if (S == "NA"|| S == "N/A" || S == "na" || S ==  "Na"){
              (Double.NaN,"Double")
            }
            else{
              val Doub = isDouble(S.asInstanceOf[String])
              if(Doub.isSuccess){
                (Doub.get,"Double")
              }
              else{
                change("String")
              }
            }
          }
        }

      case "String" => S match {
        case _:String => (S,"String")
        case _ => (S.toString,"String")
      }
    }
    change(Type)
  }
}
