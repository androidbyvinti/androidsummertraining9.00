package com.bmpl.videoview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.MediaController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pathOfVideo  = "android.resource://$packageName/${R.raw.small}"

        videoView.setVideoPath(pathOfVideo)

        var mediaController = MediaController(this)

        videoView.setMediaController(MediaController(this))

        videoView.start()   // will start playing the video

    }
}