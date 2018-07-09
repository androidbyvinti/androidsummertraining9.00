package com.bmpl.intent

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_first.*

class FirstActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)


        loginButton.setOnClickListener {

            var name = namedEditText.text.toString()
            var email = emaildEditText.text.toString()
            // step-1: intent class 1 object
            // Explicit Intent
            // ste-2: metion the src and destination
            // Intent --> destination --> pass java class file
            //
            var intent = Intent(this, ThirdActivity :: class.java)
            // startActivity(intent class obj)  --> Activity
            intent.putExtra("username", name)// key : String  and value : String/Int/Float
            intent.putExtra("useremail", email)
            startActivity(intent)


        }

    }
}
