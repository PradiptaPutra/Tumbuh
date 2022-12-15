package com.example.tubes


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.tubes.databinding.ActivityPomodoroBinding


class Pomodoro : AppCompatActivity() {
    private lateinit var binding: ActivityPomodoroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPomodoroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvStart.setOnClickListener() {
            val studyTime = binding.etStudy.text.toString()
            val breakTime = binding.etBreak.text.toString()
            val roundCount = binding.etRound.text.toString()

            if (studyTime.isNotEmpty() && breakTime.isNotEmpty() && roundCount.isNotEmpty()){

                intent.putExtra("study",studyTime.toInt())
                intent.putExtra("break",breakTime.toInt())
                intent.putExtra("round",roundCount.toInt())
                val intent = Intent(this,FeedActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this,"Fill fields above",Toast.LENGTH_SHORT).show()
            }

        }
    }
}