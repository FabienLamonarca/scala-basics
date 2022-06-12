package lectures.part1basics

object StringOps extends App {

    val str: String = "Hello, I am learning Scala"

    println(str.charAt(2))
    println(str.substring(7, 11))
    println(str.split(" ").toList)
    println(str.startsWith("Hello"))
    println(str.replace("Hello", "Good morning"))
    println(str.toLowerCase)
    println(str.toUpperCase)
    println(str.length)

    val aNumberString = "45"
    val aNumber = aNumberString.toInt

    println('a' +: aNumberString :+ 'z')
    println(str.reverse)
    println(str.take(2))

    // scala specific : string interpolation

    // S-interpolator
    val name = "David"
    val age = 45
    val greeting = s"Hello, my name is $name and I am $age y.o and i'll be turning ${age + 1}"
    println(greeting)

    // F-interpolator
    val speed = 1.2f
    val myth = f"$name can eat $speed%2.2f burger per minute"
    println(myth)

    // raw-interpolator
    println(raw"This is not a \n newline")
    val escaped = "This is a \n newline"
    println(raw"$escaped")

}
