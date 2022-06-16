package exercices

abstract class MyList {
    def head: Int
    def tail: MyList
    def isEmpty: Boolean
    def add(element: Int): MyList
    def printElements: String
    override def toString: String = s"[${printElements}]"
}

object Empty extends MyList {
    def head: Int = throw new NoSuchElementException
    def tail: MyList = throw new NoSuchElementException
    def isEmpty: Boolean = true
    def add(element: Int): MyList = new Cons(element, Empty)
    override def printElements: String = ""
}

class Cons(h: Int, t: MyList) extends MyList {
    def head: Int = h
    def tail: MyList = t
    def isEmpty: Boolean = false
    def add(element: Int): MyList = new Cons(element, this)
    override def printElements: String = {
        if(t.isEmpty) s"$h"
        else s"$h ${t.printElements}"
    }
}

object ListTest extends App {
    val list = new Cons(1, Empty)
    println(list.head)
    println(list.add(48).head)
    println(list.tail.isEmpty)
    println(list.add(2).add(3))
}