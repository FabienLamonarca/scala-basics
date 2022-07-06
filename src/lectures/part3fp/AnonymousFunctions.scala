package lectures.part3fp

object AnonymousFunctions extends App {

    val doubler = new Function[Int, Int] {
        override def apply(v1: Int): Int = v1 * 2
    }

    // anonymous function (LAMBDA)
    val doublerClean: Int => Int = (x: Int) => x * 2

    // multiples params
    val adder: (Int, Int) => Int = (a, b) => a + b

    // No parameters at all ?
    val doSomething: () => Int = () => 3
    println(doSomething) // Anon function itself (lambda)
    println(doSomething()) // function call = 3

    // curly brace with lambda
    val stringToInt = { (str: String) =>
        str.toInt
    }

    // MOAR syntactic sugar
    val niceIncrementer: Int => Int = x => x + 1
    val niceIncrementerSugar: Int => Int = _ + 1

    val niceAdder: (Int, Int) => Int = _ + _  // equivalent to (a,b) => a + b
    // it is very contextual, each _ concern a different variable

    /*
    1. MyList : Replace all functionX by lambda
    2. Rewrite the special adder as a anonymous function
     */

    // 2.
    val superAdd: Int => Int => Int = (x:Int) => (y:Int) => x + y
    val superAddShorter: Int => Int => Int = x => y => x + y
}
