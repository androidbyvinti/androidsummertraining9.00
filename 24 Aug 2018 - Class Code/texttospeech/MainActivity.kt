package texttospeech.bmpl.com.texttospeech

import android.os.Build
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener {

    private var textToSpeech: TextToSpeech? = null
    private var editText: EditText? = null
    private var button: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textToSpeech = TextToSpeech(this, this) // attach texttospeech app

        button = findViewById(R.id.button) as Button
        editText = findViewById(R.id.editText) as EditText

        button!!.setOnClickListener { speakOut() }
    }

    public override fun onDestroy() {

        if (textToSpeech != null) {
            textToSpeech!!.stop()
            textToSpeech!!.shutdown()
        }
        super.onDestroy()
    }

    override fun onInit(status: Int) {

        if (status == TextToSpeech.SUCCESS) {
            val result = textToSpeech!!.setLanguage(Locale.getDefault())

            /*textToSpeech.setPitch(0.5f);
            textToSpeech.setSpeechRate(10.2f); */

            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TextToSpeech", "Language not supported")
                Toast.makeText(this, "Language not supported.. Please choose other language", Toast.LENGTH_LONG)
            } else {
                button!!.isEnabled = true
                speakOut()
            }
        } else {
            Log.e("TextToSpeech", "Initialization Failed")
        }
    }

    private fun speakOut() {
        val text = editText!!.text.toString()
        //
        //textToSpeech!!.speak(text, TextToSpeech.QUEUE_FLUSH, null)


        var id = this.hashCode().toString() // hexadecimal
        //app target nougat



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            textToSpeech!!.speak(text,TextToSpeech.QUEUE_FLUSH, null, id)
        }
    }
}
