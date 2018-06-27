package com.bmpl.firstapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.login_screen.*

class FirstActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_screen) // R --> id


        // Step-1 Downcasting
        // findViewByID

//        var email = findViewById<EditText>(R.id.emailEditText)
//        var password : EditText = findViewById(R.id.passwordEditText)
//        var loginBtn = findViewById<Button>(R.id.loginButton)

        // Step-2 Attach Listener
        // WE have multiple ways to attach listener
        // Step-3: Attach Handler
        loginButton.setOnClickListener {

            var em = emailEditText.text.toString()  // String data
            var pwd = passwordEditText.text.toString()

            // em --> String --> Predefined class -->

            if(em.isNotBlank() && pwd.isNotBlank()){
                Toast.makeText(this, "Welcome $em", Toast.LENGTH_LONG).show()
            }  else{
                Toast.makeText(this, "Fields cannot be blank", Toast.LENGTH_LONG).show()
            }
// else if(pwd.isEmpty()){
//                Toast.makeText(this, "Password cannot be blank", Toast.LENGTH_LONG).show()
//            }
            // Toast class

            // 1st param --> class reference --> this --> keyword --> current object reference
            // 2nd message --> message
            // 3rd --> Duration --> Short and Long

            // center --> Bottom

        }




        // Start Emulator and Application Run

        // Emulator -->Android Virtual Device(AVD) -->


        // R --> R is a predefined class in Android which is automatically created
        //      with every android project --> R contains required predefiend id's which is
            // required by android studio and by the current project.
        // always in modifying state whenever you start setting some data either in front-end
        // or in back-end

        // layout
        // login_screen
    }
}