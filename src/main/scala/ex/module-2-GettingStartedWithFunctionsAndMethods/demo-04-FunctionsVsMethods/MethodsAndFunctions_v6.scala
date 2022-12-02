
object MethodsAndFunctions_v6 extends App {

  val data = Array("PS", "MSFT", "GOOG", "AAPL", "TSLA")

  def getNumRowsMethod: Int = data.length

  val getNumRowsFunction = () => data.length

//  println(getNumRowsMethod.isInstanceOf[Function0[_]])
  println(getNumRowsFunction.isInstanceOf[Function0[_]])
}
