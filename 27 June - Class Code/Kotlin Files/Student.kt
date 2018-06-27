import java.util.Scanner

class Student {

    // lateinit --> late initialization

    // instance variable --> outside the function, outside the constructor, outside any block

    lateinit var name : String    // String
    lateinit var rollno : Number // Int --> int

    // with return type - with arguments
    // int print(int value){}

            fun main(args : Array<String>){

                var stud = Student()
                stud.details()
                stud.print()

            }

            fun details(){
                // user input --> name and rollno

                // object Scanner predefined class --> User Interaction

                var sc = Scanner(System.`in`)

                println("Enter your name")

                name = sc.next() // without spaces
                            // with spaces --> nextLine()
                //name = "Ram kumar"
                println("Enter your rollno")

                rollno = sc.nextInt()
            }

            fun print() : Int
            {
                println("Name is = $name")
                println("Rollno is = $rollno")
              return 0
            }
}