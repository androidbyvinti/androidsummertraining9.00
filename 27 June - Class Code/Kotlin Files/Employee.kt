import java.util.*

// Single Repository Work -->

class Employee {    // Obj

    // data members --> instance variables --> outside any function, any constructor or any block
    // member functions --> functions

    // lateinit --> late initialization
    // declaration
    // class inside --> but outside the method, constructor, block
    // instance variable
    lateinit var name : String
    lateinit var id : Number  // Parent class --> Int, Byte, Short,
    lateinit var companyName : String
    lateinit var salary : Number
    lateinit var bonus : Number
    lateinit var email : String
    lateinit var deptName : String
    lateinit var managerName : String // Secondary Fields


    // 15-20 variables  -->  --> object creation

    // default type

    // 2 types of cons --> parameterized and default
    // default  -->  common data among all the objects needs to be stored in the default cons
    // companyName, companyAddress, companyPhn, etc --> default cons

    // parameterized : uncommon values of object
    // Primary fields without which we cannot create an object
    // name, id, salary
    constructor(nm : String, id : Number, salary : Number){

        // this is a keyword which is always going to hold current object reference

        // when name of local variable and instance variable is same then we need to use this keyword

        // variable, methods, constructor

        this.name = nm
        this.id = id
        this.salary = salary

    }

    // constructor never return anything


    // constructor --> by default --> default constructor
    // constructor --> variable --> initialize
    fun input(){
//        name = "Ram Kumar"
//        id = 1001
//        var sc = Scanner(System.`in`)
//        println("Enter your name")
//        name = sc.next()
//        println("Enter your id")
//        id = sc.nextInt()
    }

    fun displayDetails(){
        println("Name is = $name")
        println("Id is = $id")
        println("Salary is = $salary")
    }

}