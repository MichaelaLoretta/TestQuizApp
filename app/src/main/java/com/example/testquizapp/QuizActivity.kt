package com.example.testquizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class QuizActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        var nameDisplay = findViewById<TextView>(R.id.tvUserName)
        var backButton = findViewById<ImageButton>(R.id.btnBack)

        var userName : String = intent.getStringExtra("userName").toString()

        nameDisplay.text = "$userName"

        backButton.setOnClickListener{

            finish()
            //val intent = Intent(this, MainActivity::class.java)
            //startActivity(intent)

        }





    }
}