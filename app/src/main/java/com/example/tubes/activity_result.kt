package com.example.tubes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView

class activity_result : AppCompatActivity() {
    lateinit var correctAns: TextView
    lateinit var totalAns:TextView
    lateinit var performance:TextView
    lateinit var output: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        supportActionBar?.hide()

        correctAns=findViewById(R.id.correctAns)
        totalAns=findViewById(R.id.totalAns)
        performance=findViewById(R.id.performance)
        output=findViewById(R.id.output)

        val intent = intent
        val correctAnsNo=intent.getStringExtra("correct")
        val totalAnsNo=intent.getStringExtra("total")
        correctAns.text=correctAnsNo
        totalAns.text=totalAnsNo

        val percentage= (correctAnsNo?.toFloat()?.div(totalAnsNo?.toFloat()!!))?.times(100)

        if (percentage != null) {
            when {
                50 <= percentage && percentage <= 99 -> {

                    performance.text="YOU HAVE GOOD PERSONALITY DEVELOPMENT"
                    output.background=resources.getDrawable(R.drawable.fill)


                }
                percentage>=100 -> {
                    performance.text="YOU HAVE EXCELLENT PERSONALITY DEVELOPMENT"
                    output.background=resources.getDrawable(R.drawable.corectbt)
                }
                percentage<50 -> {
                    performance.text="YOU HAVE TO IMPROVE MORE YOUR PERSONALITY DEVELOPMENT"
                    output.background=resources.getDrawable(R.drawable.falsebt)
                }
            }


        }
    }

    override fun onBackPressed() {
        var intent= Intent(this,activity_start::class.java)
        startActivity(intent)
    }
}