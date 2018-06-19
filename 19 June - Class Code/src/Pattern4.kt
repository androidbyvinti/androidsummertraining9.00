/*
     *   --> spaces
    ***
   *****
  *******
 *********

  1
  22
  33
  44
  33
  22
  1

 1
 23
 345
 5678
 891011




 */

fun main(args: Array<String>) {
    for(row in 1..5) // row = 4<=5
    {
        for(space in 5 downTo row){ // space = 5>=2
            print(" ") // XXXXX*
                      //  XXXX **
        }

        for(column in 1..(2*row-1))  // column = 1<=(5)
        {
            print("*")
        }
        println()
    }
}