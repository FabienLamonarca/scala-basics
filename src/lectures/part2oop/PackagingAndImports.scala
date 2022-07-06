package lectures.part2oop

import playground.{Cinderella => Princess, PrinceCharming}

import java.util.Date

object PackagingAndImports extends App {

    // Can import class from the same package as is
    val writer = new Writer("Daniel", "Rock the jvm", 2018)

    // Have to import because it is not under the same package
    val cinderella = new Princess

    // fully qualified name (no need to import)
    val cinderella2 = new playground.Cinderella2

    // package are in hierarchy
    // matching folder structure


    // "package object" => scala feature
    // sometime we want to write some code outside from any package
    println(SPEED_OF_LIGHT)
    sayHello()

    // import
    val prince = new PrinceCharming


    // Collision
    val date = new Date
    val sqlDate = new java.sql.Date(2022) // Use fully qualified name

    // Alias the import
    import java.sql.{Date => SqlDate}
    val sqlDate2 = new SqlDate(2022)

    // Default import
    // java.Lang - String, Object, Exception
    // scala - Int, Nothing, Function
    // scalaPredef - println etc...

}
