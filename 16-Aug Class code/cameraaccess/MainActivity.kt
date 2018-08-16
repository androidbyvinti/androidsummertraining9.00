package com.bmpl.cameraaccess

import android.Manifest
import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val REQUEST_IMAGE_CAPTURE = 1
    private val REQUEST_CAMERA_PERMISSION = 2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            // API 21 --> Lollipop
            // 5 --> lollipop, 6 --> marshmallow, 7 --> nougat
            // 24 >= 22
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                //show dialog box to user
                requestPermissions(arrayOf(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE), REQUEST_CAMERA_PERMISSION)
            } else {
                cameraButton.setOnClickListener {
                    takePictureIntent()
                }
            }
        }
        else {
            cameraButton.setOnClickListener{
                takePictureIntent()
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
            // 2 == 2
        if(requestCode == REQUEST_CAMERA_PERMISSION && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            cameraButton.setOnClickListener {
                takePictureIntent()
            }
        }
        else
            Toast.makeText(this, "Cannot work without permission", Toast.LENGTH_LONG).show()
                //finish()
    }

    private fun takePictureIntent() {

        val pictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)//camera predefined service

                                        // package reference -->
                    startActivityForResult(pictureIntent, REQUEST_IMAGE_CAPTURE)

        try{
            startActivityForResult(pictureIntent, REQUEST_IMAGE_CAPTURE)
        }catch(e : ActivityNotFoundException){
            Toast.makeText(this, "Camera not supported", Toast.LENGTH_LONG).show()
        }

        //ActivityNotFound Exception
        if (pictureIntent.resolveActivity(packageManager) != null) { // check that is there any app to provide camera services
            startActivityForResult(pictureIntent, REQUEST_IMAGE_CAPTURE)
        } else {
            Toast.makeText(this, "Camera not supported", Toast.LENGTH_LONG).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
            // putExtra(key : value), putExtra(key : value)
            // Bundle class --> bundle object
            // putExtras(bundle object {key:value, key:value})

            val extras = data.extras // getExtras() -->
            val imageBitmap : Bitmap = extras.get("data") as Bitmap//"data" predefined key
            clickedImage.setImageBitmap(imageBitmap)
        }
    }
}