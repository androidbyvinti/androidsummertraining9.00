package com.bmpl.intent

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

class ThirdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)


        // Intent obj

        var receivingObj : Intent = intent  // receive and return
        var name = receivingObj.getStringExtra("username")

        var email = receivingObj.getStringExtra("useremail")

        Toast.makeText(this, "Welcome name : $name \n email : $email", Toast.LENGTH_LONG).show()

    }
}
