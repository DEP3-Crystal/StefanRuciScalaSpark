
object FunctionLiteralsAndPlaceholders_v3 extends App {

  var multiplyBy = (x: Int) => x * 100

  println(multiplyBy(3))

//  multiplyBy = (x: String) => x.toUpperCase() //--type mismatch

}
