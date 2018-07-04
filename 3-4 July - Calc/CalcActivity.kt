package com.bmpl.calc

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_calc.*

class CalcActivity : AppCompatActivity()/*, View.OnClickListener*/ {



//    override fun onClick(p0: View?) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calc)

        // 3 steps

        // separate listener and separate handler

        // id.setOnClickListener{}

        // --> 2nd way of attaching listener and handler

        // seperate listener but one handler
        // 0-9 --> text --> textview
//        btn1.setOnClickListener(this)   // btn1 --> id
//                                    // setOnClickListener() --> method
//        btn2.setOnClickListener(this)
//        btn3.setOnClickListener(this)
//        btn4.setOnClickListener(this)
//        btn5.setOnClickListener(this)

    }

    // void buttonClicked(View v){}

    fun buttonClicked(v : View){    // btn click -> automatically current function called
        // button text --> textview
        // 78 --> 78
        // 7 --> btn7

        var button = findViewById<Button>(v.id) // 50+

        inputTextView.text = inputTextView.text.toString() + button.text.toString()
    }

    fun operationRequested(){

    }
}




