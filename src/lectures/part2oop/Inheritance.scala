package lectures.part2oop

object Inheritance extends App {

    class Animal {
        // Modifier : Private / Protected / None = public
        def eat(): Unit = println("NomNomNom")
        val creatureType = "wild"
    }

    class Cat extends Animal {
        def crunch(): Unit = {
            eat()
            println("CrunchCrunchCrunch")
        }
    }

    val cat = new Cat
    cat.crunch()

    // constructor
    class Person(name: String, age: Int) {
        def this(name: String) = this(name, 0)
    }

    // class Adult(val name: String, val age:Int, idCard:String) extends Person // Can do this
    class Adult(name: String, age: Int, idCard: String) extends Person(name)

    // overriding

    // override v1 - fields in code bloc
    class Dog(override val creatureType: String) extends Animal {
        override def eat(): Unit = {
            super.eat()
            println("crunch, crunch")
        }
    }

    val dog = new Dog("k9")
    println(dog.creatureType)

    // override v2
    class Rabbit(animalType: String) extends Animal {
        override val creatureType: String = animalType
    }

    val rabbit = new Rabbit("Fluffy")
    println(rabbit.creatureType)

    // type substitution (polymorphism)
    val unknownAnimal: Animal = new Dog("K9")
    unknownAnimal.eat()

    // overRIDING vs overLOADING

    // preventing overrides
    // 1 - use final on method
    // 2 - use final on class
    // 3 - seal the class = can extend classes in THIS FILE but prevent extensions in other files
    sealed class Vehicle
    class Car extends Vehicle

}
