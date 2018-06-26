package com.bmpl.imageswitch

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_image.*

class ImageActivity : AppCompatActivity() {

    var clicked : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)

        // step-1: Downcasting Kotlin Kotlin
        // step-2: Attach listener
        // step-3: Attach Handler


//        button1.setOnClickListener {
//
//            imageView.setImageResource(R.drawable.image2)
//        }
//
//        button2.setOnClickListener {
//            imageView.setImageResource(R.drawable.image3)
//        }

        button1.setOnClickListener{

            if(clicked){
                button1.text = "Show Image"
                imageView.visibility = View.GONE

                //imageView.setVisibility(View.Visible)
                //imageView.setImageResource(R.drawable.image2)
            } else{
                button1.text = "Hide Image"
                imageView.setImageResource(R.drawable.image3)
            }

            clicked = !clicked
        }


    }
}
