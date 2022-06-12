package lectures.part1basics

object ValuesVariablesTypes extends App {

  // Values
  val x = 42
  println(x)

  // VALS ARE IMMUTABLE
  // COMPILER can infer types

  val aString: String = "Hello"
  val anotherString = "goodbye"

  val aBoolean: Boolean = true
  val aChar: Char = 'a'
  val anInt: Int = x
  val aShort: Short = 4555
  val aLong: Long = 4848484848484888888L
  val aFloat: Float = 2.01f
  val aDouble: Double = 3.14

  // Variables
  var aVariable: Int = 4
  aVariable = 3 // side effects

}
