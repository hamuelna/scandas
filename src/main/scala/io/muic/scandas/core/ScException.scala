package io.muic.scandas.core

object ScException {
  case class DiffDimException(msg: String = "", cause: Throwable = null)
    extends Exception(msg, cause)

}
