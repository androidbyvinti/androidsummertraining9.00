package com.bmpl.gridview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_grid.*

class GridActivity : AppCompatActivity() {

    var imageArray = arrayOf("https://www.gettyimages.ie/gi-resources/images/Homepage/Hero/UK/CMS_Creative_164657191_Kingfisher.jpg",
            "https://images.pexels.com/photos/257840/pexels-photo-257840.jpeg?auto=compress&cs=tinysrgb&h=350",
            "http://www.uniwallpaper.com/static/images/butterfly-wallpaper.jpeg",
            "http://festivalsdaywallpapers.com/wp-content/uploads/08-august-2011f.jpg",
            "http://banhomehug.org/wp-content/uploads/2018/06/full-hd-wallpaper-4k-digital-full-hd-nature-2544-con-image-wallpaper-full-hd-e-top-hd-full-hd-wallpaper-image-wallpaper-full-hd-1920x1080px.jpg",
            "http://www.messagescollection.com/wp-content/uploads/2017/08/best-good-night-images-for-whatsapp.jpg",
            "http://www.intrawallpaper.com/static/images/HD-Wallpapers-89_0S0GXqU.jpg",
            "https://html5box.com/html5lightbox/images/lakeandballoon.jpg",
            "http://sfwallpaper.com/images/cute-images-12.jpg",
            "https://user-images.githubusercontent.com/883386/35498559-87eb6426-04d7-11e8-825c-2dd2abdfc112.jpg")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid)


        gridView.adapter = CustomAdapter(this, imageArray)

    }
}
