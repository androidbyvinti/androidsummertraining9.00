package com.bmpl.intent

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.SpannableStringBuilder
import kotlinx.android.synthetic.main.activity_first.*

class FirstActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        var selectedGender = 0

        // Implicit Intent --> service --> broadcasting --> app outside

        sendButton.setOnClickListener{
            // intent object
            // Android OS --> Preference
            var intent = Intent()
            intent.action = Intent.ACTION_SEND  // data --> send --> app
            intent.type = "text/plain"       //type of your data which you are going to send MIME Types --> predefined

            intent.`package` = "com.whatsapp"
                // arrayOf("a", "b", "fdfdf")  --> Array<String>
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("abc@gmail.com", "xyz@gmail.com")) // To
            intent.putExtra(Intent.EXTRA_SUBJECT, "SUBJECT")// Subject
            intent.putExtra(Intent.EXTRA_TEXT, "This is my app data") // Body
            // Remember choice
            //startActivity(Intent.createChooser(intent, "Select Anyone"))
            startActivity(intent)
        }

        loginButton.setOnClickListener {

            var name = namedEditText.text.toString()
            var email = emaildEditText.text.toString()
            var gender = genderData.selectedItem.toString()

            // 1st way
            // position -> 0 or 1
            selectedGender = genderData.selectedItemPosition

            genderData.setSelection(selectedGender)

            // Editable is a predefined interface

            // 1st way to set edittext data
            var editableName : Editable = SpannableStringBuilder(name)

            namedEditText.text = editableName

            // 2nd way  to set edittext data
            namedEditText.setText(name) // id

            // step-1: intent class 1 object
            // Explicit Intent
            // ste-2: metion the src and destination
            // Intent --> destination --> pass java class file
            //


            var intent = Intent(this, ThirdActivity :: class.java)
            // startActivity(intent class obj)  --> Activity
            intent.putExtra("username", name)// key : String  and value : String/Int/Float
            intent.putExtra("useremail", email)
            intent.putExtra("gender", gender)
            startActivity(intent)

        }
    }
}