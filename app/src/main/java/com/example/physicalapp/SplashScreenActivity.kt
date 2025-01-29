package com.example.physicalapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.physicalapp.R.layout.activity_splash_screen

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_splash_screen)
        val startButton: Button = findViewById(R.id.startButton)
        val exitButton: Button = findViewById(R.id.exitButton)

        startButton.setOnClickListener {
            val intent = Intent(this,  MainScreenActivity::class.java)
            startActivity(intent)
            finish()
        }

        exitButton.setOnClickListener {
            finish()
        }
    }
}




