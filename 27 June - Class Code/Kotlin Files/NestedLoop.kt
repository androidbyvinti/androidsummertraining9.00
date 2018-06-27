

fun main(args: Array<String>) {

    // nested loops --> loop inside loop

    for(i in 1..3) // i = 1<=3
    {
        for(j in 1..3) // j= 1<=3
        {
            if(i==j) // 1 == 1
            {
                // terminate the current loop
                break   // 2 1,  3 1, 3 2

                //continue    // skip the current iteration
            }else {
                println("value of i = $i value of j = $j") // 1 1
            }                                      // 1 2
                                                        // 1 3
        }                                               // 2 1 ... 2 3 , 3 1 .. 3 3
    }
}
