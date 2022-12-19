package com.example.tubes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.tubes.databinding.ActivityNotesBinding
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Notes : AppCompatActivity() {
    private lateinit var binding: ActivityNotesBinding
    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes)
        val navHostFragment= supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        navController = navHostFragment.navController

        setupActionBarWithNavController(navController)

        val itemClickListener = findViewById<BottomNavigationItemView>(R.id.home)
        itemClickListener.setOnClickListener{
            val intent = Intent(this,Home::class.java)
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


    }

    override fun onSupportNavigateUp(): Boolean {
        return super.onSupportNavigateUp() || navController.navigateUp()
    }


}