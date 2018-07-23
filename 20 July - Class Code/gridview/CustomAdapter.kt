package com.bmpl.gridview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView


class CustomAdapter(gridActivity: GridActivity, imageArray: Array<String>) : BaseAdapter(){

    var images = imageArray
    var gridActivity = gridActivity

    // Adapter , Fragments


    override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {

        var layoutInflater : LayoutInflater = gridActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        var view = layoutInflater.inflate(R.layout.custom_view, viewGroup, false)

        var imageView = view.findViewById<ImageView>(R.id.imageView)

        Glide.with(view)
                .load(images[position])
                .into(imageView)

        //imageView.setImageResource(images[position].toInt()) // "https://4343"
        return view
    }

    override fun getItem(p0: Int): Any {
        return images[p0]
    }

    override fun getItemId(p0: Int): Long {
        return images[p0].toLong()
    }

    override fun getCount(): Int {
        return images.size
    }
}