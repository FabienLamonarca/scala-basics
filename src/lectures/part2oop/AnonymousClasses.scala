package lectures.part2oop

object AnonymousClasses extends App {

    abstract class Animal {
        def eat: Unit
    }

    // Anonymous class
    val funnyAnimal: Animal = new Animal {
        override def eat: Unit = println("ahahah")
    }
    val notFunnyAnimal: Animal = new Animal {
        override def eat: Unit = println("grrrr")
    }

    println(funnyAnimal.getClass)
    println(notFunnyAnimal.getClass)

    class Person(name: String) {
        def sayHi: Unit = println(s"Hi i'm $name")
    }

    val jim = new Person("Jim") {
        override def sayHi: Unit = println(s"Hi i'm Jim")
    }

}
