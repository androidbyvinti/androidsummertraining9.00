package com.bmpl.sqlitedatabase_nishamohit

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    internal var arrayAdapter: ArrayAdapter<*>? = null
    lateinit var customAdapter: CustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Model --> Custom Class --> database --> sqlite --> add, read, update, delete
        val databaseHandler = DatabaseHandler(this)

        val readButton = findViewById<Button>(R.id.readButton)
        val saveButton = findViewById<Button>(R.id.saveButton)
        val updateButton = findViewById<Button>(R.id.updateButton)
        val deleteButton = findViewById<Button>(R.id.deleteButton)

        val nameEditText = findViewById<EditText>(R.id.nameEditText)
        val phnEditText = findViewById<EditText>(R.id.phnEditText)
        val idEditText = findViewById<EditText>(R.id.idEditText)

        val listView = findViewById<ListView>(R.id.listView)


        saveButton.setOnClickListener {
            val id : Int = Integer.parseInt(idEditText.text.toString())
            val name = nameEditText.text.toString()
            val phn = (phnEditText.text.toString()).toLong()

            // DatabaseHandler class --> Add, Read, Update, Delete
                                    // Details is a custom class -->Details obj (id, phn, name) --> DatabaseHanlder class(Details)

            //Details --> POJO class --> Pure Old Java Object -->
            // var intent = Intent()
            var details = Details(id, name, phn)
            // database --> id, name, phn, etc
            databaseHandler.addDetails(details) // object is created --> Details(id, name, phn)
            //databaseHandler.addDetails(Details(id, name, phn))
        }

        readButton.setOnClickListener {
            val list = databaseHandler.readData() // return arraylist<Details>--> data

            // arrayAdapter = new ArrayAdapter<>(MainActivity.this, R.layout.support_simple_spinner_dropdown_item, list);
            customAdapter = CustomAdapter(this@MainActivity, list)
            //Log.i("MainActivity",list.toString());

            listView.adapter = customAdapter

//            for (details in list) {
//                Log.i("MainActivity", "id = " + details.id + "Name = " + details.name + "Phn = " + details.phn)
//            }
            //                if(arrayAdapter.getCount()!=0){
            //                    list.clear();
            //                    arrayAdapter.notifyDataSetChanged();
            //                }
        }

        updateButton.setOnClickListener {
            val id = Integer.parseInt(idEditText.text.toString())
            val name = nameEditText.text.toString()
            val phn = java.lang.Long.parseLong(phnEditText.text.toString())

            databaseHandler.updateData(Details(id, name, phn))
        }

        deleteButton.setOnClickListener {
            val id = Integer.parseInt(idEditText.text.toString())
            val name = nameEditText.text.toString()
            val phn = java.lang.Long.parseLong(phnEditText.text.toString())

            databaseHandler.deleteData(Details(id, name, phn))
        }
    }
}