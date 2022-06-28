package exercices

abstract class MyListGeneric[+A] {
    def head: A

    def tail: MyListGeneric[A]

    def isEmpty: Boolean

    def add[B >: A](element: B): MyListGeneric[B] // [B >: A] super.type of A

    def printElements: String

    override def toString: String = s"[${printElements}]"

    def map[B](transformer: MyTransformer[A, B]): MyListGeneric[B]

    def filter(predicate: MyPredicate[A]): MyListGeneric[A]

}

object EmptyGeneric extends MyListGeneric[Nothing] {
    def head: Nothing = throw new NoSuchElementException

    def tail: MyListGeneric[Nothing] = throw new NoSuchElementException

    def isEmpty: Boolean = true

    def add[B >: Nothing](element: B): MyListGeneric[B] = new ConsGeneric(element, EmptyGeneric)

    def printElements: String = ""

    def map[B](transformer: MyTransformer[Nothing, B]): MyListGeneric[B] = EmptyGeneric

    def flatmap[B](transformer: MyTransformer[Nothing, MyListGeneric[B]]): MyListGeneric[B] = EmptyGeneric

    def filter(predicate: MyPredicate[Nothing]): MyListGeneric[Nothing] = EmptyGeneric
}

class ConsGeneric[+A](h: A, t: MyListGeneric[A]) extends MyListGeneric[A] {
    def head: A = h

    def tail: MyListGeneric[A] = t

    def isEmpty: Boolean = false

    def add[B >: A](element: B): MyListGeneric[B] = new ConsGeneric(element, this)

    override def printElements: String = {
        if (t.isEmpty) s"$h"
        else s"$h ${t.printElements}"
    }

    def map[B](transformer: MyTransformer[A, B]): MyListGeneric[B] = {
        new ConsGeneric[B](transformer.transform(h), t.map(transformer))
    }

    def filter(predicate: MyPredicate[A]): MyListGeneric[A] = {
        if (predicate.test(h)) new ConsGeneric(h, t.filter(predicate))
        else t.filter(predicate)
    }
}


trait MyPredicate[-T] {
    def test(item: T): Boolean
}

trait MyTransformer[-A, B] {
    def transform(item: A): B
}

class EvenPredicate extends MyPredicate[Int] {
    override def test(item: Int): Boolean = item % 2 == 0
}

class StringToIntTransformer extends MyTransformer[String, Int] {
    override def transform(item: String): Int = item.toInt
}


object ListTestGeneric extends App {
    val listOfInteger: MyListGeneric[Int] = new ConsGeneric(1, new ConsGeneric(2, new ConsGeneric(3, EmptyGeneric)))
    println(listOfInteger)

    val listOfString: MyListGeneric[String] = new ConsGeneric("1", new ConsGeneric("2", EmptyGeneric))
    println(listOfString)

    val evenList = listOfInteger.filter(new EvenPredicate())
    println(evenList)
}