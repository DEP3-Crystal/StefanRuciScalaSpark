
object MethodsAndFunctions_v9 extends App {

  val data = Array("PS", "MSFT", "GOOG", "AAPL", "TSLA")

  def existsMethod(ticker: String): Boolean = data.contains(ticker)

  val existsFunction = (ticker: String) => data.contains(ticker)

  val exists = existsMethod _

  println("Does PS exist (method): " + existsMethod("PS"))
  println("Does TM exist (function): " + existsFunction("TM"))
  println("Does GOOG exist (function): " + exists("GOOG"))

}
