package com.bmpl.externalstorage

import android.os.Bundle
import android.os.Environment
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.FileWriter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // sd card or phone memory --> public area
                                // access of the internal public area of device
        // for sd card access
        // public --> Internal storage -->
        // getExternalStorageDirectory() --> sd-card
        var pathOfDocument : File = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)

        saveButton.setOnClickListener {

            var name  = nameEditText.text.toString()
            var password = passwordEditText.text.toString()

            var file = File(pathOfDocument, "myfile.txt")

            var fileWriter = FileWriter(file, true) // file data ?

            fileWriter.write(name)
            fileWriter.write(password)

            Toast.makeText(this, "Data written", Toast.LENGTH_LONG).show()

            fileWriter.close()
        }

        readButton.setOnClickListener {

            var file = File(pathOfDocument, "myfile.txt")

            var fileReader = FileReader(file)

            var bufferedReader = BufferedReader(fileReader)

            var data = bufferedReader.use { it.readLine() }

            Toast.makeText(this, data, Toast.LENGTH_LONG).show()

            // var data = ""

//            while(bufferedReader.readText()!=null) { // abc123
//
//                Log.i("MainActivity", bufferedReader.readText())
//
//                //data += fileReader.read().toChar()
//
//                //Log.i("MainActivity", "" + fileReader.read().toChar()) // abc1234 --> ASCII --> Return --> 97
//            }

        }

    }
}
