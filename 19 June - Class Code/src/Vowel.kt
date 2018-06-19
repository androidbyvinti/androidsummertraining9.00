
fun main(args: Array<String>) {

    var value = 'a'


//    when(value){
//        'a'-> println("vowel")
//        'e'-> println("vowel")
//        'i'-> println("vowel")
//        'o'-> println("vowel")
//        'u'-> println("vowel")
//        else-> println("consonant")
//    }

    // better version
    when(value){
        'a','e','i','o','u'-> println("vowel")
        else-> println("consonant")
    }

    var first = 10
    var second = 20
    var third = 30

    when{
        first>second && first>third -> println("First is greater")
        second>third -> println("Second is greater")
        else->println("Third is greater")
    }

    var max = 0

    // first > second --> first --> max
    // second --> max

    // if-else --> as an expression to return something

    max = if(first>second)
        first
    else
        second

    max = when{
        first>second-> first
        else -> second
    }
}