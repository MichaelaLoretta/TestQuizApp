package com.example.testquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class CategoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        val backButton = findViewById<ImageButton>(R.id.btnBackLogin)
        val button = findViewById<ImageButton>(R.id.btnToQuiz)

        button.setOnClickListener{
            val intent = Intent(this,QuizActivity::class.java )
            startActivity(intent)
        }

        backButton.setOnClickListener{

            finish()

        }


    }
}