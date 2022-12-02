
object FunctionLiteralsAndPlaceholders_v12 extends App {

  val sayHello = () => println("Hello function literal!")

  val multiplyBy100 = (x: Int) => x * 100

  val addTwoNumbers = (x: Int, y: Int) => x + y

  val addThreeNumbers = (x: Int, y: Int, z:Int) => x + y + z

  sayHello()
  println(multiplyBy100(7))
  println(addTwoNumbers(7, 10))
  println(addThreeNumbers(7, 10, 3))
}
