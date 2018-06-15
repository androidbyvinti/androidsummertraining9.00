import java.util.*

fun main(args: Array<String>) {

    val sc = Scanner(System.`in`) // obj --> default properties

    val minAge = 16

    println("Enter your age")

    val userVal = sc.nextInt() // temp

    if(userVal>= minAge){
        print("You can vote")
    } else{
        println("You cannot vote")
    }

    if(userVal>= minAge){
        print("You can Drive")
    } else{
        println("You cannot Drive")
    }
}