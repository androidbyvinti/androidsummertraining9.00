package com.android.cardview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private var mRecyclerView: RecyclerView? = null
    private var mLayoutManager: RecyclerView.LayoutManager? = null // LinearLayout , GridLayout

    var dataSet  = arrayOf("Data 1", "Data 1", "Data 1",
                            "Data 1", "Data 1", "Data 1",
                            "Data 1", "Data 1", "Data 1",
                            "Data 1",
                            "Data 1", "Data 1", "Data 1",
                            "Data 1", "Data 1", "Data 1",
                            "Data 1", "Data 1", "Data 1", "Data 1")


//    private val dataSet: ArrayList<Data>
//        get() {
//            val results = ArrayList<Data>()
//            for (index in 0..19) {
//                val obj = Data("Ram $index",
//                        "Kumar $index")
//                results.add(index, obj)
//            }
//            return results
//        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        mRecyclerView = findViewById(R.id.recyclerView)

        mLayoutManager = LinearLayoutManager(this) // LinearLayoutManager, GridLayoutManager, StaggeredGridLayoutManager
        mRecyclerView!!.layoutManager = mLayoutManager

        //mAdapter = RecyclerAdapter(dataSet) // RecyclerAdapter --> Adatper

        mRecyclerView!!.adapter = RecyclerAdapter(dataSet)
    }
}
