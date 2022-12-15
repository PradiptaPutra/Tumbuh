package com.example.tubes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

import androidx.fragment.app.Fragment
import com.example.tubes.databinding.ActivityHomeBinding
import com.example.tubes.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
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
    }
}







