package com.bmpl.sqlitedatabase_nishamohit

//POJO --> pure old java object --> Java Bean

// Java Bean

class Details {
    // public --> package --> internal
   internal var id: Int = 0
   internal var name: String? = null
   internal var phn: Long = 0

    //Details(){}
    constructor() {}

    constructor(id: Int, name: String, phn: Long) {
        this.id = id
        this.name = name
        this.phn = phn
    }
}
