package com.bmpl.quizapp

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_score.*

class ScoreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)


        var recevingIntent = intent
        var score = recevingIntent.getIntExtra("score", 0)
        var totalQuestions = recevingIntent.getIntExtra("counter", 0) + 1

        scoreTextView.text = "Score : $score/$totalQuestions"

        // reading data from shared preference
        var readPreferences = getSharedPreferences("scoredetails.txt", Context.MODE_PRIVATE)
        var highestScore = readPreferences.getInt("highestscore", 0)

        if(score>highestScore){

            // Saving data into shared preference
            var sharedPreferences : SharedPreferences.Editor = getSharedPreferences("score", Context.MODE_PRIVATE).edit()
            sharedPreferences.putInt("highestscore", score)
            sharedPreferences.apply()   // save into the file
            highScoreTextView.text = score.toString()
        } else{
            highScoreTextView.text = highestScore.toString()
        }


    }

}



