package com.example.tubes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.QuestionModel
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.collections.ArrayList

class Quiz : AppCompatActivity() {lateinit var questionsList:ArrayList<QuestionModel>
    private var index:Int = 0
    lateinit var questionModel: QuestionModel

    private var correctAnswerCount:Int=0
    private var wrongAnswerCount:Int=0

    lateinit var countDown:TextView
    lateinit var questions: TextView
    lateinit var option1: Button
    lateinit var option2:Button
    lateinit var option3:Button
    lateinit var option4:Button




    private var backPressedTime: Long = 0
    private var backToast: Toast? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        supportActionBar?.hide()

        countDown=findViewById(R.id.countdown)
        questions=findViewById(R.id.questions)
        option1=findViewById(R.id.option1)
        option2=findViewById(R.id.option2)
        option3=findViewById(R.id.option3)
        option4=findViewById(R.id.option4)




        questionsList= ArrayList()
        questionsList.add(QuestionModel("_______________ is the complex of mental characteristics that makes each of us unique from other people.","Heredity","Emotional tone","Personality"," Option 1 & 2 ","Personality"))


        questionsList.add(QuestionModel("Our personalities developed as a result of ______________________ .","Genetic inheritance","Environmental influences","Both of the above","","Both of the above"))
        questionsList.add(QuestionModel("Which of the following things can have an effect on the development of an individual's personality?","Physical and mental capabilities","Health and physical appearance","Skin color, gender, and sexual orientation","All of the above","All of the above"))
        questionsList.add(QuestionModel("Which of the following statements is true?","Ruth Benedict argued that national personality types do not exist.","We often share personality traits with others, especially members of our own family and community.","The term modal personality refers to the personality traits shared by all members of a society.","Option 2 & 3","Option 2 & 3"))
        questionsList.add(QuestionModel("An individual's actions are most likely to be strongly controlled by conscience if they have a(n) __________________ type of personality?","Inner-directed personality","Other-directed personality","Neither of the above","","Inner-directed personality"))


        //questionsList.shuffle()
        questionModel= questionsList[index]

        setAllQuestions()

        countdown()










    }


    fun countdown(){
        var duration:Long=TimeUnit.SECONDS.toMillis(10)


        object : CountDownTimer(duration, 1000) {
            override fun onTick(millisUntilFinished: Long) {

                var sDuration:String= String.format(
                    Locale.ENGLISH,
                    "%02d:%02d",
                    TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished),
                    TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished)-TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)))

                countDown.text = sDuration

            }
            override fun onFinish() {
                index++
                if (index<questionsList.size){
                    questionModel=questionsList[index]
                    setAllQuestions()
                    resetBackground()
                    enableButton()
                    countdown()

                }
                else{

                    gameResult()

                }


            }



        }.start()



    }


    private fun correctAns(option: Button){
        option.background=getDrawable(R.drawable.corectbt)

        correctAnswerCount++



    }
    private fun wrongAns(option:Button){

        option.background=resources.getDrawable(R.drawable.falsebt)

        wrongAnswerCount++


    }

    private fun gameResult(){
        var intent= Intent(this,activity_result::class.java)

        intent.putExtra("correct",correctAnswerCount.toString())
        intent.putExtra("total",questionsList.size.toString())

        startActivity(intent)
    }



    private fun setAllQuestions() {
        questions.text=questionModel.question
        option1.text=questionModel.option1
        option2.text=questionModel.option2
        option3.text=questionModel.option3
        option4.text=questionModel.option4
    }
    private fun enableButton(){
        option1.isClickable=true
        option2.isClickable=true
        option3.isClickable=true
        option4.isClickable=true
    }
    private fun disableButton(){
        option1.isClickable=false
        option2.isClickable=false
        option3.isClickable=false
        option4.isClickable=false
    }
    private fun resetBackground(){
        option1.background=resources.getDrawable(R.drawable.fill)
        option2.background=resources.getDrawable(R.drawable.fill)
        option3.background=resources.getDrawable(R.drawable.fill)
        option4.background=resources.getDrawable(R.drawable.fill)
    }
    fun option1Clicked(view: View){
        disableButton()
        if(questionModel.option1==questionModel.answer){
            option1.background=resources.getDrawable(R.drawable.mainbutton)


            correctAns(option1)

        }
        else{
            wrongAns(option1)
        }
    }

    fun option2Clicked(view:View){
        disableButton()
        if(questionModel.option2==questionModel.answer){
            option2.background=resources.getDrawable(R.drawable.mainbutton)


            correctAns(option2)

        }
        else{
            wrongAns(option2)
        }
    }
    fun option3Clicked(view:View){
        disableButton()
        if(questionModel.option3==questionModel.answer){

            option3.background=resources.getDrawable(R.drawable.mainbutton)


            correctAns(option3)


        }
        else{
            wrongAns(option3)
        }
    }
    fun option4Clicked(view:View){
        disableButton()
        if(questionModel.option4==questionModel.answer){
            option4.background=resources.getDrawable(R.drawable.mainbutton)


            correctAns(option4)

        }
        else{
            wrongAns(option4)
        }
    }

    override fun onBackPressed() {

        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast?.cancel()
            finish()
        }

        else {
            backToast = Toast.makeText(baseContext, "DOUBLE PRESS TO QUIT GAME", Toast.LENGTH_SHORT)
            backToast?.show()
        }
        backPressedTime = System.currentTimeMillis()

    }




}