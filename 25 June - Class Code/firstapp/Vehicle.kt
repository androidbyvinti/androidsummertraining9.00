package com.bmpl.firstapp



open class Vehicle {

    open fun printDetails(){

    }

}

class Car : Vehicle(){

    override fun printDetails(){
        printDetails()          // Recursive
    }
}





