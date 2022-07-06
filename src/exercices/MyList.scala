package exercices

abstract class MyList[+A] {
    def head: A

    def tail: MyList[A]

    def isEmpty: Boolean

    def add[B >: A](element: B): MyList[B] // [B >: A] super.type of A

    def printElements: String

    override def toString: String = s"[${printElements}]"

    // Higher-order functions -> receive other function as arguments
    def map[B](transformer: A => B): MyList[B]
    def filter(predicate: A => Boolean): MyList[A]

}

object Empty extends MyList[Nothing] {
    def head: Nothing = throw new NoSuchElementException

    def tail: MyList[Nothing] = throw new NoSuchElementException

    def isEmpty: Boolean = true

    def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)

    def printElements: String = ""

    def map[B](transformer: Nothing => B): MyList[B] = Empty

    def flatmap[B](transformer: Nothing => MyList[B]): MyList[B] = Empty

    def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty
}

class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
    def head: A = h

    def tail: MyList[A] = t

    def isEmpty: Boolean = false

    def add[B >: A](element: B): MyList[B] = new Cons(element, this)

    override def printElements: String = {
        if (t.isEmpty) s"$h"
        else s"$h ${t.printElements}"
    }

    def map[B](transformer: A => B): MyList[B] = {
        new Cons[B](transformer(h), t.map(transformer))
    }

    def filter(predicate: A => Boolean): MyList[A] = {
        if (predicate(h)) new Cons(h, t.filter(predicate))
        else t.filter(predicate)
    }
}

//trait MyPredicate[-T] { // T => Boolean
//    def test(item: T): Boolean
//}
//
//trait MyTransformer[-A, B] { // A => B
//    def transform(item: A): B
//}

//class EvenPredicate extends MyPredicate[Int] {
//    override def test(item: Int): Boolean = item % 2 == 0
//}
//
//class StringToIntTransformer extends MyTransformer[String, Int] {
//    override def transform(item: String): Int = item.toInt
//}


object ListTestGeneric extends App {

    def evenPredicate : Int => Boolean = (v1: Int) => v1 % 2 == 0
    def stringToIntTransformer : String => Int = (v1: String) => v1.toInt

    val listOfInteger: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
    println(listOfInteger)

    val listOfString: MyList[String] = new Cons("1", new Cons("2", Empty))
    println(listOfString)

    val evenList = listOfInteger.filter(evenPredicate)
    println(evenList)
}