package lectures.part2oop

object CaseClasses extends App {

    class Person(name: String, age: Int)

    case class CasePerson(name: String, age: Int)

    ////////////
    // 1. class parameters are fields
    ////////////

    val jim = new Person("jim", 25)
    // println(jim.name) // INVALID

    val jimmy = new CasePerson("jimmy", 25)
    println(jimmy.name)

    ////////////
    // 2. Sensible toString
    ////////////
    println(jim)
    println(jimmy)

    ////////////
    // 3. Equals & hashCode already implemented out of the box
    ////////////
    val jimmy2 = new CasePerson("jimmy", 25)
    println(jimmy == jimmy2)

    ////////////
    // 4. Case Classes have handy copy methods
    ////////////
    val olderJimmy = jimmy.copy(age = 45)
    println(olderJimmy)

    ////////////
    // 5. Case Classes have companion objects
    ////////////
    val thePerson = CasePerson
    val mary = CasePerson("Mary", 20)
    // due to the fact case classes already have companions apply method (factory)
    // we do not need the keyword "new" to create instances

    ////////////
    // 6. Case classes are Serializable
    ////////////
    // useful to Akka Framework

    ////////////
    // 7. Case classes have extractor patterns = CCs can be used in PATTERN MATCHING
    ////////////


    ////////////
    // Bonus - objects can be case too
    ////////////
    case object UnitedKingdom {
        def name: String = "The UK of GB and NI"
    }



}
