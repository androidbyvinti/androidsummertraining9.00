package com.bmpl.volleylib

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity() {

    var imageurl = "http://api.giphy.com/v1/gifs/search?q=tomandjerry&api_key=G05dNkoZboRT3tGa980LD9sN31RyYE46"

    // +searchImg+"&api_key=G05dNkoZboRT3tGa980LD9sN31RyYE46"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val que = Volley.newRequestQueue(this)
        val req = JsonObjectRequest(Request.Method.GET, imageurl, null,
                Response.Listener {
                    response ->  Log.i("Response" , response.toString())
                                    var array = response.getJSONArray("data")
                                    for(i in 0 until array.length()){
                                        var image = array.getJSONObject(i) // 0
                                                .getJSONObject("images")
                                                .getJSONObject("fixed_width")
                                                .get("url")
                                        Log.i("url : " , image.toString())
//                                        var jsonObj = array.getJSONObject(i)
//                                        var imagesObj = jsonObj.getJSONObject("images")
//                                        var width = imagesObj.getJSONObject("fixed_width")
//                                        Log.i("url : ", width.get("url").toString() )
                                    }
                },
                Response.ErrorListener { error->
                    Toast.makeText(this, "Exception ${error.message} ", Toast.LENGTH_LONG).show()
                })

        que.add(req)
    }
}

/*

{
	"data" : [
		{
		"images" :
			{
			  "fixed_width" :
			         {
                                    "url" : "url"
				  }
                        }
                 }
                 ]
}


 */