package com.example.testquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast

class CongratsActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_congrats)

        val myScore: TextView = findViewById(R.id.tvScore)
        val score: TextView = findViewById(R.id.tvScoreNr)
        val backBtn: ImageButton = findViewById(R.id.btnBack)


        val isCorrect : Int = intent.getIntExtra("Correct", 0).toInt()


        if(isCorrect <= 5){

            myScore.text = "Bummer, You Lose! Your score is $isCorrect, Lets try again!"

        }else{
            myScore.text = "Congrats, you WIN!! Your score is"
            score.text = "$isCorrect"
        }




        backBtn.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}

