package exercices

abstract class MyListGeneric[+A] {
    def head: A
    def tail: MyListGeneric[A]
    def isEmpty: Boolean
    def add[B >: A](element: B): MyListGeneric[B]  // [B >: A] super.type of A
    def printElements: String
    override def toString: String = s"[${printElements}]"
}

object EmptyGeneric extends MyListGeneric[Nothing] {
    def head: Nothing = throw new NoSuchElementException
    def tail: MyListGeneric[Nothing] = throw new NoSuchElementException
    def isEmpty: Boolean = true
    def add[B >: Nothing](element: B): MyListGeneric[B] = new ConsGeneric(element, EmptyGeneric)
    def printElements: String = ""
}

class ConsGeneric[+A](h: A, t: MyListGeneric[A]) extends MyListGeneric[A] {
    def head: A = h
    def tail: MyListGeneric[A] = t
    def isEmpty: Boolean = false
    def add[B >: A](element: B): MyListGeneric[B] = new ConsGeneric(element, this)
    override def printElements: String = {
        if(t.isEmpty) s"$h"
        else s"$h ${t.printElements}"
    }
}

object ListTestGeneric extends App {
    val listOfInteger: MyListGeneric[Int] = new ConsGeneric(1, new ConsGeneric(2, new ConsGeneric(3, EmptyGeneric)))
    val listOfString: MyListGeneric[String] = new ConsGeneric("1", new ConsGeneric("2", EmptyGeneric))
}