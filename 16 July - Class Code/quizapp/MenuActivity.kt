package com.bmpl.quizapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

    }

    fun optionSelected(view : View){
        var intent = Intent(this, QuizActivity :: class.java)
        intent.putExtra("option", view.id) // R.id.javaButton
        startActivity(intent)
    }
}
