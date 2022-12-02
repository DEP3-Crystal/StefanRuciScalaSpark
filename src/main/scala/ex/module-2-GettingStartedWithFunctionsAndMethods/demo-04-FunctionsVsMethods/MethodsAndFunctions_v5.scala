
object MethodsAndFunctions_v5 extends App {

  val data = Array("PS", "MSFT", "GOOG", "AAPL", "TSLA")

  def getNumRowsMethod: Int = data.length

  val getNumRowsFunction = () => data.length

//  println(getNumRowsMethod.apply())
  println(getNumRowsFunction.apply())
}
