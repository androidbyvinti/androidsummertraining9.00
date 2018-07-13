package com.bmpl.quizapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var delay : Long = 30000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Handler is a predefined class which is used to handle some delay
        // functionalities
        var handler = Handler()

        // 2 thread --> UIThread --> used to manage your front-end work
        //             MainThread --> Complete application is managed by MainThread
        // Exception in Thread main --> Exception information

        // Runnable --> Runnable is a predefined interface
        // which is basically used for doing multithreading work

        // a new will be created which will manage loading of your next screen

        // 1 way to use Runnable
        var runData = Runnable {
            var intent = Intent(this, MenuActivity :: class.java)
            startActivity(intent)
            finish() // Activity class
        }

        handler.postDelayed(runData, delay)
        // 2nd way of using postDelayed
//        handler.postDelayed(Runnable {
//
//            // 1st way
//
//        }, 30000) // Wait for milliseconds to complete


        // 2nd way
        //startActivity(Intent(this, MenuActivity :: class.java))
    }
}