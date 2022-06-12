package lectures.part2oop

object OOBasics extends App {

    val person = new Person("John", 26)
    println(person.age)

    person.greet()
    person.greet("Kaled")


    /* Novel & writer */
    val writer = new Writer("Fabien", "Lamonarca", 1994)
    val writer2 = new Writer("Mathieu", "Thiriet", 1994)
    println(writer.fullName())
    val novel = new Novel("Les 4 fantastiques", 2008, writer)

    println(novel.isWrittenBy(writer))
    println(novel.isWrittenBy(writer2))

    println(novel.authorAge())
    val novel2 = novel.copy(2012)
    println(novel2.authorAge())

    val counter = new Counter()
    counter.inc().print()
    counter.inc(5).print()
    counter.inc(5).dec(3).print()

    // constructor
    // class parameter are NOT fields
    // class parameter => "name: String"
    // class attribute => "val name: String" into constructor
    class Person(name: String, val age: Int) {
        // body
        val x = 2
        println("an expression")

        def greet(name: String): Unit = println(s"${this.name} says : Hi $name")

        // overloading // surcharge
        def greet(): Unit = println(s"Hi, I'm $name")

        // multiple constructors
        def this(name: String) = this(name, 0) // --> can be avoided by using default value into default constructor

        def this() = this("John Doe")
    }

    /*
    * Novel and writer class
    *
    * writer : first name, surname, year
    * - method: fullname
    *
    * Novel: name, year of release, author
    * - method: authorAge  --> age of author at the end of release
    * - isWrittenBy(author)
    * - copy (new year of release) = new instance of novel
    * */

    class Writer(firstName: String, surname: String, val year: Int) {
        def fullName(): String = s"$firstName $surname"
    }

    class Novel(name: String, releaseYear: Int, author: Writer) {
        def authorAge(): Int = releaseYear - author.year

        def isWrittenBy(author: Writer): Boolean = this.author == author

        def copy(newReleaseYear: Int): Novel = new Novel(name, newReleaseYear, author)
    }

    /*
     * Counter class
     * -receive an int value
     * -method current count
     * -method to increment/decrement => new Counter
     * - overload inc/dec to receive an amount
     * */

    class Counter(v: Int = 0) {

        def currentCount: Int = v

        def inc(): Counter = {
            println("incrementing")
            new Counter(v + 1)
        } // immutability

        def dec(): Counter = {
            println("decrementing")
            new Counter(v - 1)
        }

        // tailrec
        def inc(n: Int): Counter = {
            if (n <= 0) this
            else inc().inc(n - 1)
        }

        // tailrec
        def dec(n: Int): Counter = {
            if (n <= 0) this
            else dec().dec(n - 1)
        }

        def print(): Unit = println(this.currentCount)

    }

}


