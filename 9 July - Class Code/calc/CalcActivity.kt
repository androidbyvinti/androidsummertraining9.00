package com.bmpl.calc

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_calc.*

class CalcActivity : AppCompatActivity()/*, View.OnClickListener*/ {

    var first = 0
    var second = 0
    var operation = ""
    var requested = false

    var array  = arrayOf(2,5,7,7)
    var value = arrayOf("Ram", "Mohan")
    // String array[]

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
        var button = findViewById<Button>(v.id) //55+     4
        inputTextView.text = inputTextView.text.toString() + button.text.toString()
        // 56/65 --> result

        if(operation.isNotEmpty()){ // operation = +
                // inputTextView --> 55+40 => 59
            //second = second * 10 + button.text.toString().toInt()
                        // 55+40  --> operation --> +
            //second = 5
            second = inputTextView.text.toString().substringAfterLast(operation).toInt()
            // result --> resultTextView
            resultTextView.text = when(operation){
                "+"-> (first+second).toString()
                "-"-> (first-second).toString()
                "X"-> (first*second).toString()
                "/"-> (first/second).toString()
                else-> ""
            }

        }

    }

    fun operationRequested(view : View){
                                        // 50+50+67+45
        var button = findViewById<Button>(view.id) // +
                //55+4+50
        //if(first == 0)
        //first = inputTextView.text.toString().toInt()

        if(!requested)  // first = 55+4
        {
            first = inputTextView.text.toString().toInt()
            requested = true
        }
        else {
            if(resultTextView.text.toString().isNotEmpty()) {
                first = resultTextView.text.toString().toInt()
            }
            second = 0
        }
        operation = button.text.toString()
        inputTextView.text =inputTextView.text.toString() +  button.text.toString()

        // first = 59
        //first = 25
        // operation = +
     }
}




