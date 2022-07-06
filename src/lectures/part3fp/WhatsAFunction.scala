package lectures.part3fp

object WhatsAFunction extends App {

    // DREAM: use function as first class elements
    // problem : object oriented programming

    val doubler = new MyFunction[Int, Int] {
        override def apply(element: Int): Int = element * 2
    }
    println(doubler(2))


    // function types = Function1[A, B]
    val StringToIntConverter = new Function1[String, Int] {
        override def apply(v1: String): Int = v1.toInt
    }
    println(StringToIntConverter("3") + 4)


    val adder = new Function2[Int, Int, Int] {
        override def apply(v1: Int, v2: Int): Int = v1 + v2
    }
    val adderSyntactic = new ((Int, Int) => Int) {
        override def apply(v1: Int, v2: Int): Int = v1 + v2
    }
    println(adder(4, 8))

    // Function types Function2[A, B, R] === (A, B) => R

    // ALL SCALA FUNCTIONS ARE OBJECTS

    /*
    * 1. Define a function which take 2 string and concatenates them
    * 2. MyList -> transform : MyPredicate & MyTransformer into function types
    * 3. Define a function which take an int and return another function which takes an int and return an int
    *   - What's the type of this function ?
    *   - how to do it ?
    * */

    def concatenator : (String, String) => String = (v1: String, v2: String) => v1.concat(v2)

    val concatenate = new ((String, String) => String)  {
        override def apply(v1: String, v2: String): String = v1.concat(v2)
    }
    println(concatenate("A", "B"))


    // Ex 3.
    // Function1[Int, Function1[Int, Int]]
    val superAdder: Function1[Int, Function1[Int, Int]] = new Function[Int, Function1[Int, Int]] {
        override def apply(x: Int): Function1[Int, Int] = new Function[Int, Int] {
            override def apply(v1: Int): Int = x + v1
        }
    }

    val superAdderSugar: Int => Int => Int = (x: Int) => (v1: Int) => x + v1

    val adder3 = superAdder(3)
    println(adder3(4))
    println(superAdder(3)(4)) // Curried function

}

trait MyFunction[A, B] {
    def apply(element: A): B
}
