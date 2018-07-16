package com.bmpl.quizapp

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_quiz.*

class QuizActivity : AppCompatActivity() {

    // lateinit --> lateinitializtion
    lateinit var life : Array<ImageView>
    lateinit var buttons : Array<Button>

    var lifeCount = 2

    lateinit var questionsArray : Array<String>    // global declare --> Instance variable
    lateinit var optionsArray : Array<String>
    lateinit var answersArray : Array<String>
    var counter = 0
    var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        var receivingIntent = intent
        var selected = receivingIntent.getIntExtra("option", 0)

        life = arrayOf(a, b, c)
        buttons = arrayOf(option1, option2, option3, option4)

        when(selected){
            R.id.cButton-> {
                questionsArray = resources.getStringArray(R.array.cQuestions)
                optionsArray = resources.getStringArray(R.array.cOptions)
                answersArray = resources.getStringArray(R.array.cAnswers)

            }
            R.id.cPlusButton->
            {

            }
        }

        timer()

        // questionText view --> question --> questionArray -->
        questionTextView.text = questionsArray[0]
        // options --> btn1, btn2, btn3, btn4 --> optionArray --> 0 - 3
        option1.text = optionsArray[0]
        option2.text = optionsArray[1]
        option3.text = optionsArray[2]
        option4.text = optionsArray[3]
//
        //loadNextQuestion()
    }

    fun loadNextQuestion(view : View){
        // exception --> outofboundexception
        checkScore(view)
        counter++ // 2
        if(counter < questionsArray.size) { // start --> 1 to 5
            questionTextView.text = questionsArray[counter] // 3
            option1.text = optionsArray[4 * counter] // 4 * 3 = 12
            option2.text = optionsArray[4 * counter + 1] // 4 * 2 + 1 = 9
            option3.text = optionsArray[4 * counter + 2] // 1 = 6 = 10
            option4.text = optionsArray[4 * counter + 3] // 7 = 7 = 11
        } else{
            scoreScreen()
        }

    }

    fun checkScore(view : View){
        var button = findViewById<Button>(view.id)
        if(button.text == answersArray[counter]){
            button.setBackgroundColor(Color.GREEN)
            score+=10
        } else{
            button.setBackgroundColor(Color.RED)
            markCorrectAns()
            if(lifeCount >= 0) { // -1 >= 0
                life[lifeCount].visibility = View.INVISIBLE
                lifeCount-- // -1
            }else{
                scoreScreen()
            }
        }
    }

    fun scoreScreen(){
        var intent = Intent(this, ScoreActivity :: class.java)
        intent.putExtra("score", score)
        startActivity(intent)
    }

    fun markCorrectAns(){
        for(i in buttons){  // [0(button), 1(button), 2, 3]
            if(i.text == answersArray[counter]){
                i.setBackgroundColor(Color.GREEN)
            }
        }
    }

    // Timer work
    fun timer(){
        // CountDownTimer class -->
        // abstract class --> when we don't want to create any instance of a class

        var countDownTimer = object : CountDownTimer(20000, 1000){

            override fun onFinish() {

            }

            override fun onTick(p0: Long) {
                timerTextView.text = "Time Left: ${p0/1000}"
            }

        }
        countDownTimer.start()
    }
}
