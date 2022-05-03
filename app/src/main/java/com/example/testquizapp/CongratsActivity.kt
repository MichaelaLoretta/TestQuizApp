package com.example.testquizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class CongratsActivity : AppCompatActivity() {

    var myScore: TextView = findViewById(R.id.tvScore)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_congrats)

        //var isCorrect : String = intent.getStringExtra("Correct").toString()
        //var isIncorrect : String = intent.getStringExtra("Incorrect").toString()

        //myScore.text = "$isCorrect / 10"
    }
}