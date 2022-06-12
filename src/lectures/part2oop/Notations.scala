package lectures.part2oop

import scala.language.postfixOps

object Notations extends App {

    class Person(val name:String, val favMovie:String, val age: Int = 0) {

        def likes(movie:String): Boolean = movie == favMovie

        def hangoutWith(p: Person) : String = s"${this.name} is hanging out with ${p.name}"
        def +(p: Person): String = this.hangoutWith(p)
        def +(alias: String): Person = new Person(s"${this.name} (The $alias)", this.favMovie)

        def unary_! : String = s"NOT ${this.name}"
        def unary_+ : Person = new Person(this.name, this.favMovie, this.age + 1)

        def isAlive: Boolean = true
        def apply(): String = s"Hi my name is $name and I like $favMovie"
        def apply(n: Int): String = s"$name has watched $favMovie $n times"

        def learns(what: String) : String = s"${this.name} is learning $what"
        def learnsScala: String = this learns "Scala"
    }

    val mary = new Person("Mary", "Inception")
    println(mary.likes("Inception"))
    println(mary likes "Inception") // equivalent
    // infix notation = operator notation (syntactic sugar)

    // "operators" in Scala
    val tom = new Person("Tom", "Fight club")

    // all those are the same because we can name our method with the char we want
    println(mary.hangoutWith(tom))
    println(mary hangoutWith tom)
    println(mary + tom)
    println(mary.+(tom))

    // ALL OPERATOR ARE METHODS

    // prefix notation
    val x = -1 // equivalent with 1.unary_-
    val y = 1.unary_-

    // unary_ prefix only works with - + ~ !
    println(!mary)

    // postfix
    println(mary.isAlive)
    println(mary isAlive) // equivalent

    // apply
    println(mary.apply())
    println(mary()) // equivalent

    /*
    * 1. Overload the + operator -> return a new person with name "Mary (the rockstar)"
    *
    * 2. Add an age to the Person class
    *   - Add unary + operator => new Person with the age + 1
    *
    * 3. Add a "learns" method in the Person class => Mary learns scala
    *   - Add a learnsScala method, calls the learns method with "scala" as parameter
    *   - Use it in postfix notation
    *
    * 4. Overload the apply method
    *   - mary.apply(2) => "Mary watched favMov 2 times
    *
    * */

    // 1.
    println((mary + "The rockstar").name)

    // 2.
    println(mary.age)
    println((+mary).age)

    // 3.
    println(mary learns "scala")
    println(mary learnsScala)

    // 4.
    println(mary(50))

}
