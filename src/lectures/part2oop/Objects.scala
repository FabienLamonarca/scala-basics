package lectures.part2oop

object Objects extends App {

    // SCALA DOESN'T HAVE CLASS-LEVEL FUNCTIONALITY -> "static"

    // Object do the job
    object Person { // type + its only instance
        // static / class level functionality
        val N_EYES = 2
        def canFly: Boolean = false

        // factory method -> convention is to use Apply name for factory method
        def apply(mother: Person, father: Person): Person = new Person("Bobby")
    }

    class Person(val name: String) {
        // instance level functionality
    }
    // COMPANIONS : object Person + class Person

    println(Person.N_EYES)
    println(Person.canFly)

    // Scala object = SINGLETON INSTANCE
    val mary = new Person("mary")
    val john = new Person("john")
    println(mary == john)

    val person1 = Person
    val person2 = Person
    println(person1 == person2)

    // same statement for apply factory here
    val _bobby = Person.apply(mary, john)
    val bobby = Person(mary, john)

    // Scala Applications
    // Scala app is only a scala object with:
    // def main(args: Array[String]): Unit

    // extends App or :
    //    def main(args: Array[String]): Unit = {
    //
    //    }

}
