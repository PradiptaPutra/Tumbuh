package com.example.tubes

import android.content.ClipData
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

import androidx.fragment.app.Fragment
import com.example.tubes.databinding.ActivityHomeBinding

import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.text.DateFormat;
import java.util.Calendar;

class Home : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val calendar = Calendar.getInstance()
        val currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.time)
        val textViewDate = findViewById<TextView>(R.id.text_view_date)
        textViewDate.text = currentDate

        val buttonClick = findViewById<FloatingActionButton>(R.id.fab)
        buttonClick.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }

        val itemClickListener = findViewById<BottomNavigationItemView>(R.id.notes)
        itemClickListener.setOnClickListener{
            val intent = Intent(this,Notes::class.java)
            startActivity(intent)
        }

        val itemClickListener2 = findViewById<BottomNavigationItemView>(R.id.pomodoro)
        itemClickListener2.setOnClickListener{
            val intent = Intent(this,Pomodoro::class.java)
            startActivity(intent)

        }
        val itemClickListener3 = findViewById<BottomNavigationItemView>(R.id.quiz)
        itemClickListener3.setOnClickListener{
            val intent = Intent(this,activity_start::class.java)
            startActivity(intent)

        }
        val itemClickListener4 = findViewById<BottomNavigationItemView>(R.id.reminder)
        itemClickListener4.setOnClickListener{
            val intent = Intent(this,Reminder::class.java)
            startActivity(intent)
        }
        val itemClickListener5 = findViewById<ImageView>(R.id.profile)
        itemClickListener5.setOnClickListener{
            val intent = Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        }

    }

}






