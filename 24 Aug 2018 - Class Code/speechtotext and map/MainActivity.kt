package speechtotext.bmpl.com.speechtotext

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import android.support.v7.app.AppCompatActivity
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {

    private var speechToText: TextView? = null
    private var btnSpeak: ImageButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnSpeak = findViewById(R.id.btnSpeak) as ImageButton
        speechToText = findViewById(R.id.speechToText) as TextView
        // hide the action bar
        // getActionBar().hide();

        btnSpeak!!.setOnClickListener { promptSpeechInput() }
    }

    private fun promptSpeechInput()
    {
        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)

        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())

        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                "Say Something")
        try {
            startActivityForResult(intent, 1001)
        } catch (a: Exception) {
            Toast.makeText(applicationContext,
                    getString(R.string.speech_not_supported),
                    Toast.LENGTH_SHORT).show()
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            1001 -> {
                if (resultCode == Activity.RESULT_OK && data != null) {

                    val result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
                    speechToText!!.text = result[0]
                }
            }
        }
    }

    override fun onBackPressed() {
        var dialog = AlertDialog.Builder(this)
        dialog.setTitle("Exit")
        dialog.setMessage("Do you want to Exit?")
        dialog.setPositiveButton("Yes", DialogInterface.OnClickListener { dialogInterface, i ->

            super.onBackPressed()
        })

        dialog.setNegativeButton("No", DialogInterface.OnClickListener { dialogInterface, i ->
            onResume()
        })
        dialog.show()

    }
}