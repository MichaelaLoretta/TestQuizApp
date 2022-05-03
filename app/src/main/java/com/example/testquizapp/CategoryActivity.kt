package com.example.testquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast

class CategoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        val backButton = findViewById<ImageButton>(R.id.btnBackLogin)
        val button = findViewById<ImageButton>(R.id.btnToQuiz)

        val userName : String= intent.getStringExtra("userName").toString()

        Toast.makeText(this, "hello $userName", Toast.LENGTH_SHORT).show()

        button.setOnClickListener{
            val intent = Intent(this,QuizActivity::class.java )
            startActivity(intent)
        }

        backButton.setOnClickListener{

            finish()

        }


    }
}