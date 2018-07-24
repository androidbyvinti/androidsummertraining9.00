package com.bmpl.fetchingsongs

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SimpleAdapter
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var listView: ListView
    var arrayAdapter: ArrayAdapter<*>? = null
    //ArrayList<SongData> arrayList;
    lateinit var arrayList: ArrayList<HashMap<String, String>>
    lateinit var mediaPlayer: MediaPlayer
    //External Storage -->
    // {rollno:1, name:"Ram"}
    // []

    // Array List --> {hashmap, hashmap}
    // HashMap<String, String> --> predefined class --> key and value pair


    // int value[] = {...} --> ArrayList --> ready functions --> add()
    /*lateinit var mainActivity : MainActivity

    var array = arrayOf("")*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //listView = findViewById(R.id.listView)

        arrayList = ArrayList()

        //path to sd card or to internal storage
//        Environment.getExternalStorageDirectory()// set to sd card reference
//        val file = Environment.getExternalStoragePublicDirectory("Music/") // set to internal memory path


        getSongs()

        val listAdapter = SimpleAdapter(this, arrayList, R.layout.custom_layout, arrayOf("title"), intArrayOf(R.id.textView))

        //arrayAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, arrayList);

        listView.adapter = listAdapter

//        listView.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
//            //HashMap hashMap = arrayList.get(i);
//            val uri = Uri.parse(arrayList[i]["path"])
//
//            mediaPlayer = MediaPlayer.create(this@MainActivity, uri)
//
//            mediaPlayer.start()
//        }

        listView.setOnItemClickListener { adapterView, view, i, l ->
            val uri : Uri = Uri.parse(arrayList[i]["path"])


            if(mediaPlayer.isPlaying){
                mediaPlayer.stop()
                mediaPlayer.release()
                mediaPlayer = MediaPlayer.create(this@MainActivity, uri)
                mediaPlayer.start()
            }else{
                mediaPlayer = MediaPlayer.create(this@MainActivity, uri)
                mediaPlayer.start()

            }

        }

    }

    fun getSongs() {

        // common data --> different app can access --> not private
        // Public directory --> ContentResolver -->

        // Read_External_Storage
        // static permission --> till Lollipop
        // runtime permission --> with marshmallow

        // URI --> Device --> path
        val uri : Uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI   // Internal URI(Built-in music) or External URI(User Downloaded data)

        val musicFiles = MediaStore.Audio.Media.IS_MUSIC + " != 0"

        val order = MediaStore.Audio.Media.TITLE + " ASC"

        val contentResolver = contentResolver

        // SELECT COLUMN_NAME, COLUMN_ROLLNO FROM TABLE_NAME WHERE ROLLNO==3

        val cursor = contentResolver.query(uri, null, musicFiles, null, order)

        if (cursor != null) {
            while (cursor.moveToNext()) {

                val title = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE))
                val path = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA))// path of song

                //arrayList.add(new SongData(title, path));

                val hashMap = HashMap<String, String>()
                //
                hashMap.put("title", title)
                hashMap.put("path", path)


                Log.i("MainActivity", "title= $title")
                Log.i("MainActivity", "path= $path")

                arrayList.add(hashMap)

            }
        }
        cursor.close()
    }

}