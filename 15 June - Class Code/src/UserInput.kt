import java.util.Scanner  // #include<stdio.h>

// import java.lang.*

// package --> java.util.*
// folder

fun main(args: Array<String>) {

    // addition
    // Scanner class --> Predefined class used for various purposes --> input, output, error, etc

    // For Input --> Scanner

    //Step-1: Create an object of Scanner class
    // UserInput obj;

    // obj --> Scanner class properties --> cons

    // in predefined keyword

    var sc  = Scanner(System.`in`) // whenever an object is created, a constructor is called
                            // Scanner no default cons --> Scanner()
                            // Scanner parameterized cons --> Scanner(int value)

    // output --> direction --> System
    // System --> is a predefined class
    // 'in' --> is an object  --> input work

    // System.out.print();

    //val n = 50

    //n++

    // Any --> Datatype

//    var value : Any = 10    // Int
//
//    value = "ram"


    println("Enter your first number")
    var firstNo = sc.nextInt() // console --> 56

    println("Enter your second number")
    var secondNo = sc.nextInt() // console --> 56

    var result = firstNo + secondNo

    println("Result is = $result")

    // constants --> var keyword --> variable declaration
    // val --> constants

    //var b : Byte = 128

    // Datatypes --> primitive datatypes --> int, char, float, long
    // boolean --> 1 bit --> true or false
    // byte --> 1 byte --> 8 bits --> -128 to +127 --> 2(0,1) power 8 bits --> 7 bits are utilised for the range and remaining bit is utilized for sign
                // 2 power 7 --> 128(-128 to +127) --> 1 bit --> +/-
    // short --> 2 byte -->
    // char --> 2 byte
    // int --> 4 byte
    // float --> 4 byte
    // long --> 8 bytes
    // double --> 8 bytes

}
