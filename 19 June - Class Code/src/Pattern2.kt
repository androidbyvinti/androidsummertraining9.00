
/*
    1       // line --> line column
    12      // --> row
    123
    1234
    12345


    A // ASCII --> A --> 65 , E--> 69
    AB
    ABC
    ABCD
    ABCDE

 */
fun main(args: Array<String>) {
    for(i in 5 downTo 1){}
    for(row in 'A'..'E') // row (char)-->  = A<=E --> 65 <= 69  --> 65++ --> 66<=69
    {
        for(column in 'A'..row) // column A<=A   --> 65<=66 --> 65++ --> 66<=65
        {
            print(column) // A
                        //   AB
        }
        println()
    }
}





