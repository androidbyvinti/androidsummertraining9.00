package com.bmpl.sqlitedatabase_nishamohit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class CustomAdapter(mainActivity: MainActivity, list: List<Details>) : BaseAdapter(){

    var details = Details()

    var listDetails = list
    var layoutInflater = mainActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        var view = layoutInflater.inflate(R.layout.custom_layout, null)

        var id = view.findViewById<TextView>(R.id.idTextView)
        var name = view.findViewById<TextView>(R.id.nameTextView)
        var phn = view.findViewById<TextView>(R.id.phnTextView)

        details = listDetails[p0] // 0 --> {}
        id.text = details.id.toString()
        name.text = details.name
        phn.text = details.phn.toString()

        return view

    }

    override fun getItem(p0: Int): Any {
        return listDetails[p0]
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getCount(): Int {
       return listDetails.size
    }

}