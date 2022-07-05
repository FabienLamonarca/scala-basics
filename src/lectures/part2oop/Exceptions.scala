package lectures.part2oop

object Exceptions extends App {

    val x: String = null
    // println(x.length)

    // throwing & catching exceptions

    // 1. Throwing
    // val anException: String  = throw new NullPointerException

    // throwable classes extend the Throwable class.
    // Exception and Error are thr major Throwable subtypes
    val ex: Exception = null

    // 2. Catching
    def getInt(withExceptions: Boolean): Int = {
        if (withExceptions) throw new RuntimeException("No int for you")
        else 42
    }

    val tryVal = try {
        getInt(true)
    } catch {
        case _: RuntimeException =>
            println("caught a runtime Exceptions")
            45
        case e: NullPointerException => println(s"caught another exp ${e.getMessage}")
    } finally {
        // code that will be executed no matter what
        // optional
        // doesn't influence the try catch return
        // use only for side-effect operations
        println("Finally")
    }

    println(s"tryVal : $tryVal")

    // 3. Define your own exceptions
    class MyExp extends Exception

    val myExp = new MyExp
    // throw myExp


    //    1. Crash prog with OoM
    //    val array = Array.ofDim(Int.MaxValue)

    //    2. StackOverflowError
    //    def infinite : Int = 1 + infinite
    //    val noLimit = infinite


    //3. PocketCalc
    class MathCalculationException extends RuntimeException("DivisionByZero")

    class UnderflowException extends Exception

    class OverflowException extends Exception

    object PocketCalculator {
        def add(x: Int, y: Int): Int = {
            val result = x + y
            if (x > 0 && y > 0 && result < 0) throw new OverflowException
            else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
            else result
        }

        def subtract(x: Int, y: Int): Int = {
            val result = x - y
            if (x > 0 && y < 0 && result < 0) throw new OverflowException
            else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
            else result
        }

        def multiply(x: Int, y: Int): Int = {
            val result = x * y
            if (x > 0 && y > 0 && result < 0) throw new OverflowException
            else if (x < 0 && y < 0 && result > 0) throw new OverflowException
            else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
            else if (x > 0 && y < 0 && result > 0) throw new UnderflowException
            else result
        }

        def divide(x: Int, y: Int): Double = {
            if (y == 0) throw new MathCalculationException
            else x / y
        }
    }

}


