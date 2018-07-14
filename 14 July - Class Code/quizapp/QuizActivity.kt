package com.bmpl.quizapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_quiz.*

class QuizActivity : AppCompatActivity() {

    // lateinit --> lateinitializtion
    var life : Array<ImageView> = arrayOf(a, b, c)

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
        questionTextView.text = questionsArray[counter] // 3
        option1.text = optionsArray[4 * counter] // 4 * 3 = 12
        option2.text = optionsArray[4 * counter + 1] // 4 * 2 + 1 = 9
        option3.text = optionsArray[4 * counter + 2] // 1 = 6 = 10
        option4.text = optionsArray[4 * counter + 3] // 7 = 7 = 11

    }

    fun checkScore(view : View){
        var button = findViewById<Button>(view.id)
        if(button.text == answersArray[counter]){
            score+=10
        } else{
            life[lifeCount].visibility = View.INVISIBLE
            lifeCount--
        }
    }
}
