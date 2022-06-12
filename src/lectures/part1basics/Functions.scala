package lectures.part1basics

object Functions extends App {

    def aFunction(a: String, b: Int): String = {
        a + " " + b
    }

    println(aFunction("hello", 3))


    def aParameterLessFunction(): Int = 42

    println(aParameterLessFunction())
    println(aParameterLessFunction)


    def aRepeatedFunction(aString: String, n: Int): String = {
        if (n == 1) aString
        else aString + aRepeatedFunction(aString, n - 1)
    }

    println(aRepeatedFunction("hello", 3))
    // WHEN YOU NEED LOOPS, USE RECURSION

    def aFunctionWithSideEffects(aString: String): Unit = println(aString)

    def aBigFunction(n: Int): Int = {
        def aSmallerFunction(a: Int, b: Int): Int = a + b

        aSmallerFunction(n, n - 1)
    }

    /*
    * 1. Greeting function : 2param name/age => "hi my name is xxx and i'm xxx years old"
    * 2. Factorial function : 5! -> 5*4*3*2*1
    * 3. Fibonacci function : F(1)=1 F(2)=1 and f(n) = f(n-1) + f(n-2)
    * 4. Test if a number is prime
    * */

    def greeting(name: String, age: Int): String = s"Hi my name is $name and I'm $age year's old"

    println(greeting("Fabien", 28))

    def factorial(n: Int): Int = {
        if (n <= 1) 1
        else n * factorial(n - 1)
    }

    println(factorial(4))

    def fibonacci(n: Int): Int = {
        if (n <= 2) 1
        else fibonacci(n - 1) + fibonacci(n - 2)
    }

    println(fibonacci(7))

    def isPrime(n: Int): Boolean = {

        def isPrimeUntil(t: Int): Boolean = {
            if (t <= 1) true
            else n % t != 0 && isPrimeUntil(t-1)
        }

        isPrimeUntil(n / 2)
    }
    println(isPrime(37))
    println(isPrime(122))
}
