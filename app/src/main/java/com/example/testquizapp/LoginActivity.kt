package com.example.testquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var name = findViewById<EditText>(R.id.etName)
        var button = findViewById<ImageButton>(R.id.btnToCat)
        var backButton = findViewById<ImageButton>(R.id.btnBackMain)


        button.setOnClickListener {

            val userName : String = name.text.toString()

            Toast.makeText(this, "hello $userName", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, CategoryActivity::class.java)
            intent.putExtra("userName", userName) //skickar vidare namnet till Quiz-sidan
            startActivity(intent)


        }

        backButton.setOnClickListener{

            finish()
        }


    }
}