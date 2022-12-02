
object MethodsAndFunctions_v8 extends App {

  val data = Array("PS", "MSFT", "GOOG", "AAPL", "TSLA")

  def existsMethod(ticker: String): Boolean = data.contains(ticker)

  val existsFunction = (ticker: String) => data.contains(ticker)

  println("Does PS exist (method): " + existsMethod("PS"))
  println("Does TM exist (function): " + existsFunction("TM"))
}
