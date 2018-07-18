package com.bmpl.listview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView


class CustomAdapter(listActivity: ListActivity, profile: Array<Int>, contactsName: Array<String>) : BaseAdapter(){

    var profileImage = profile
    var contacts = contactsName
    var lstActivity = listActivity

    // LayoutInflater --> it is used to inflate a layout file(xml)
    // if you work in any adapter, fragment,
    // then go with layout inflater for displaying your view

    var layoutInflater : LayoutInflater = lstActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        var view = layoutInflater.inflate(R.layout.custom_layout, p2, false)

        // downcasting
        var imageView = lstActivity.findViewById<ImageView>(R.id.imageView)
        var textView = lstActivity.findViewById<TextView>(R.id.textView)

        // data bind
        imageView.setImageResource(profileImage[p0])
        textView.text = contacts[p0]

        return view

    }

    override fun getItem(p0: Int): Any {
        return profileImage[p0]
    }

    override fun getItemId(p0: Int): Long {
        return profileImage[p0].toLong()
    }

    override fun getCount(): Int {
       return profileImage.size // total no. of views to be displayed on the screen
    }
}