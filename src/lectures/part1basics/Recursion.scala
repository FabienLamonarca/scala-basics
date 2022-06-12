package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

    def factorial(n: Int): Int = {
        if (n <= 1) 1
        else {
            println(s"Computing factorial of $n - I first need factorial of ${n - 1}")
            val result = n * factorial(n - 1)
            println(s"Computed factorial of $n")

            result
        }
    }

    factorial(10) // ok
    // factorial(10000) // recursion error

    def anotherFactorial(n: Int): BigInt = {

        @tailrec
        def factHelper(x: Int, accumulator: BigInt): BigInt = {
            if (x <= 1) accumulator
            else factHelper(x - 1, x * accumulator) // TAIL RECURSION = use recursive call as the LAST expression
        }

        factHelper(n, 1)
    }

    // anotherFactorial(6)
    // factHelper(6, 1)
    // --> factHelper(5, 6 * 1)
    // --> factHelper(4, 5 * 6 * 1)
    // --> factHelper(3, 4 * 5 * 6 * 1)
    // --> factHelper(2, 3 * 4 * 5 * 6 * 1)
    // --> factHelper(1, 2 * 3 * 4 *5 * 6 * 1)
    // --> 1 * 2 * 3 * 4 * 5 * 6

    println(anotherFactorial(1000))

    // WHEN YOU NEED LOOPS, USE _TAIL_ RECURSION
    /*
    1. Concatenate a string n times
    2. IsPrime function tail recursive
    3. Fibonacci function tail recursive
     */

    @tailrec
    def concatString(text: String, n: Int, accumulator: String): String = {
        if (n <= 0) accumulator
        else concatString(text, n - 1, accumulator + text)
    }

    println(concatString("Coucou ", 5, ""))

    def isPrime(n: Int): Boolean = {
        @tailrec
        def isPrimeTailrec(t: Int, isStillPrime: Boolean): Boolean = {
            if (!isStillPrime) false
            else if (t <= 1) true
            else isPrimeTailrec(t - 1, n % t != 0 && isStillPrime)

        }

        isPrimeTailrec(n / 2, isStillPrime = true)
    }

    println(isPrime(2003))
    println(isPrime(777))


    def fibonacci(n: Int): Int = {

        def fibHelper(i: Int, last: Int, nextToLast: Int): Int = {
            if (i >= n) last
            else fibHelper(i + 1, last + nextToLast, last)
        }

        if (n <= 2) 1
        else fibHelper(2, 1, 1)

    }

    println(fibonacci(8))

}
