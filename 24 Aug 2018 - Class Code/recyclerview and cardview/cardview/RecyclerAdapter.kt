package com.android.cardview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast


class RecyclerAdapter(private val mDataset: Array<String>)
    : RecyclerView.Adapter<RecyclerAdapter.DataObjectHolder>(), View.OnClickListener {

    var pos = 0

    override fun onClick(p0: View?) {
                // Root package reference
            Toast.makeText(p0!!.context, "You clicked on $pos", Toast.LENGTH_LONG).show()
    } //Custom Class ViewHolder

    // View Holder --> downcasting work --> scrolling and data binding efficient
    class DataObjectHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // downcasting
        var textView : TextView = itemView.findViewById(R.id.textView)


//        var label: TextView
//        var dateTime: TextView
//
//        init {
//            label = itemView.findViewById(R.id.textView)
//            dateTime = itemView.findViewById(R.id.textView2)
//        }

    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): DataObjectHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.custom_row, null, false)

        //view.setOnClickListener(this)

        return DataObjectHolder(view)
    }

    override fun onBindViewHolder(holder: DataObjectHolder, position: Int) {
        holder.textView.text = mDataset[position]
        //holder.dateTime.text = mDataset[position].lastName
       // pos = position
    }

    override fun getItemCount(): Int {
        return mDataset.size
    }
}