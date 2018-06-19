import java.util.*


fun main(args: Array<String>) {

    // user 3 input -->

    var first = 0
    var second = 0
    var third = 0
    // Scanner class

    var sc = Scanner(System.`in`) // cons --> default cons is not available

    println("Enter your first value")
    first = sc.nextInt()

    println("Enter your second value")
    second = sc.nextInt()

    println("Enter your third value")
    third = sc.nextInt()

    // first = 150 second = 800 third = 90
        // 150 > 800 --> true && 150 > 90
    if((first > second) && (first>third)){
        println("First is greater")
        // 800 > 90
    } else if(second > third){
        println("Second is greater")
    }else
        println("Third is greater")


}




