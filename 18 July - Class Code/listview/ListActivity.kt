package com.bmpl.listview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.Toast
import com.bmpl.listview.R.mipmap.ic_launcher_round
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {

    var profilePic : Array<Int> = arrayOf(ic_launcher_round, ic_launcher_round,
                                            ic_launcher_round, ic_launcher_round,
                                            ic_launcher_round, ic_launcher_round,
                                            ic_launcher_round, ic_launcher_round,
                                            ic_launcher_round, ic_launcher_round,
                                            ic_launcher_round, ic_launcher_round,
                                            ic_launcher_round, ic_launcher_round,
                                            ic_launcher_round, ic_launcher_round,
                                            ic_launcher_round, ic_launcher_round)

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

        getSyst

        // 2nd param --> View reference

        //arrayAdapter = ArrayAdapter(this, R.layout.custom_layout, contactsName, profilePic)

        //listView.adapter = arrayAdapter

        listView.adapter = CustomAdapter(this, profilePic, contactsName)

        listView.setOnItemClickListener { adapterView, view, i, l ->

            Toast.makeText(this, "You clicked on : ${contactsName[i]}", Toast.LENGTH_LONG).show()

        }
        
    }
}
