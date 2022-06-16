package lectures.part2oop

object Generics extends App {

    class MyList[+A] {
        // can use type A
        def add[B >: A](element: B): MyList[B] = ???
        /*
        *  A = Cat
        *  B = Animal
        * */
    }

    trait canSendData[A] {
        def sendData(): A
    }

    val listOfInteger = new MyList[Int]
    val listOfString = new MyList[String]

    class MyMap[Key, Value]

    // generic methods

    // MyList companion
//    object MyList {
//        def empty[A]: MyList[A] = ???
//    }
//
//    val emptyListOfIntegers = MyList.empty[Int]

    // variance problem - 3 answers
    class Animal
    class Cat extends Animal
    class Dog extends Animal

    // 1. yes List[Cat] extends List[Animal] = COVARIANCE
    class CovariantList[+A]
    val animal: Animal = new Cat
    val animalList: CovariantList[Animal] = new CovariantList[Cat]
    // animalList.add(new Dog)) ??? Hard question --> We return a list of Animals

    // 2. no - INVARIANCE
    class InvariantList[A]
    // val animalListInvariant: InvariantList[Animal] = new InvariantList[Cat]    // DOESN'T WORK
    val animalListInvariant: InvariantList[Animal] = new InvariantList[Animal]

    // 3 Hell, no ! - CONTRAVARIANCE
    class Trainer[-A]
    val contravarianceList: Trainer[Cat] = new Trainer[Animal]


    // bounded types
    class Cage[A <: Animal](animal: A)
    val cage = new Cage(new Dog)

    class Car
    // val cageCar = new Cage(new Car) // Wrong

    // expand MyList to be generic
}
