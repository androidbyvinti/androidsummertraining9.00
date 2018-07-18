package com.bmpl.listview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {

    var contactsName = arrayOf("Ram", "Rohan", "Reena",
                                "Karan", "Anil", "Amit",
                                "Ram", "Rohan", "Reena",
                                "Karan", "Anil", "Amit",
                                "Ram", "Rohan", "Reena",
                                "Karan", "Anil", "Amit")

    lateinit var arrayAdapter : ArrayAdapter<String> // instance variable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        // 2nd param --> View reference
        arrayAdapter = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item,contactsName)

        listView.adapter = arrayAdapter

    }
}
