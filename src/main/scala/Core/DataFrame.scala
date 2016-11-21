package Core

import Adapter.DataLoader
//take in a hashMap then change it to dataframe
class DataFrame(data: Map)
  extends DataLoader{

  def this(data: Array[Array], index: Option[Array] = None,
           columns: Option[Array] = None) = {
    //convert data to HashMap then change it to a dataFrame using the primary constructor
    this
  }

  //print the dataframe in a beautiful way
  override def toString = ???


}