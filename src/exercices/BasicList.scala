package exercices

abstract class BasicList {
    def head: Int
    def tail: BasicList
    def isEmpty: Boolean
    def add(element: Int): BasicList
    def printElements: String
    override def toString: String = s"[${printElements}]"
}

object BasicEmpty extends BasicList {
    def head: Int = throw new NoSuchElementException
    def tail: BasicList = throw new NoSuchElementException
    def isEmpty: Boolean = true
    def add(element: Int): BasicList = new BasicCons(element, BasicEmpty)
    override def printElements: String = ""
}

class BasicCons(h: Int, t: BasicList) extends BasicList {
    def head: Int = h
    def tail: BasicList = t
    def isEmpty: Boolean = false
    def add(element: Int): BasicList = new BasicCons(element, this)
    override def printElements: String = {
        if(t.isEmpty) s"$h"
        else s"$h ${t.printElements}"
    }
}

object ListTest extends App {
    val list = new BasicCons(1, BasicEmpty)
    println(list.head)
    println(list.add(48).head)
    println(list.tail.isEmpty)
    println(list.add(2).add(3))
}