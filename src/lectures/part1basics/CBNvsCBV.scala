package lectures.part1basics

object CBNvsCBV extends App {

    def callByValue(x: Long): Unit = {
        println(s"by value: $x")
        println(s"by value: $x")
    }

    def callByName(x: => Long): Unit = {
        println(s"by name: $x")
        println(s"by name: $x")
    }

    callByValue(System.nanoTime()) // Computed before the function evaluate
    callByName(System.nanoTime()) // Computed each time it is called

    //    def callByValue(x: Long): Unit = {
    //        println(s"by value: 98550072025500")
    //        println(s"by value: 98550072025500")
    //    }
    //
    //    def callByName(x: => Long): Unit = {
    //        println(s"by name: ${System.nanoTime()}")
    //        println(s"by name: ${System.nanoTime()}")
    //    }

    def infinite(): Int = 1 + infinite()
    def printFirst(x: Int, y: => Int): Unit = println(x)
    printFirst(34, infinite())
    // "by name" delay the evaluation of the variable until it use

}
