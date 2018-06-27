import java.util.*

/*
A
AB
ABC
ABCD
ABCDE
 */

fun main(args: Array<String>) {

    var sc = Scanner(System.`in`)
    // char name[25] = { 'R'}
    var userChoice = sc.next().elementAt(0) // return String --> "Ram" -->  'R'
    //

    for(row in 'A'..userChoice){ // row(char) 'B' --> 66<=69 --> char
        for(column in 'A'..row){ // 'A'<=row  --> 65<=66
            print(column) // A
        }
        println()
    }
}