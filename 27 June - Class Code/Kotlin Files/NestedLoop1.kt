
fun main(args: Array<String>) {

    for(row in 1..3)
    {
        for(column in 1..3)
        {
            if(row == column){
                break
            }else

            println("value of i = $row value of j = $column")
        }
    }
}