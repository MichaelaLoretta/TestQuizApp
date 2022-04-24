package com.example.testquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<ImageButton>(R.id.btnWelcome)


        button.setOnClickListener {

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)


        }



    }
}