package lectures.part2oop

object AbstractDataType extends App {

    // abstract
    abstract class Animal {
        val creatureType: String = "wild"
        def eat: Unit
    }

    class Dog extends Animal {
        override val creatureType: String = "K9"
        override def eat: Unit = println("crunch crunch")
    }


    // traits
    trait Carnivore {
        def eat(animal: Animal): Unit
    }
    trait ColdBlooded

    class Crocodile extends Animal with Carnivore with ColdBlooded {
        override val creatureType: String = "croc"

        override def eat: Unit = println("nomnomnom")

        override def eat(animal: Animal): Unit = println(s"I'm a $creatureType and I'm eating a ${animal.creatureType}")
    }

    val dog = new Dog
    val crocodile = new Crocodile
    crocodile.eat(dog)

    // traits vs abstract classes
    //
    // abstract class and traits can have both abstract and non-abstract members

    // 1 - traits do not have constructor parameters
    // 2 - you can extends 1 classes but implements multiples traits
    // 3 - Traits = Behavior, abstract class = Type of thing

}
