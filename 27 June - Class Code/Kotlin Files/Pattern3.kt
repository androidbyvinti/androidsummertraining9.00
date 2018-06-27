/*
    54321
    5432
    543
    54
    5
 */

fun main(args: Array<String>) {

    for(row in 1..5) // row = 2<=5
    {
        for(column in 5 downTo row) // column = 5>=2
        {
            print(column) // 54321
        }
        println()
    }
}