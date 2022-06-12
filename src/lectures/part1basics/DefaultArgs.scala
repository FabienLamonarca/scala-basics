package lectures.part1basics

import scala.annotation.tailrec

object DefaultArgs extends App {

    @tailrec
    def trFact(n: Int, acc: Int = 1): Int = {
        if (n <= 1) acc
        else trFact(n - 1, n * acc)
    }
    val fac10 = trFact(10)

    def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit = println("saving picture")
    savePicture("jpg", 800, 600)
    savePicture("bitmap")
    // savePicture(800) --> don't compile - argument inference error
    savePicture(width = 800)

}