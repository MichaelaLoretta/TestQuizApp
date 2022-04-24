package com.example.testquizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class QuizActivity : AppCompatActivity() {

    companion object{
        val allJoined: ArrayList<JoinedFeed> = ArrayList()
        var selectedAnswers: ArrayList<String> = ArrayList()
        var questionNr: Int = 0
        var isCorrect: Int = 0
        var isIncorrect: Int = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)


        val questions: ArrayList<String> = ArrayList()
        val allAnswers: ArrayList<ArrayList<String>> = ArrayList()
        val allCorrectAnswers: ArrayList<String> = ArrayList()

        var result = findViewById<TextView>(R.id.tvQuestion)
        var backButton = findViewById<ImageButton>(R.id.btnBack)


        val retrofit = Retrofit.Builder()
            .baseUrl("https://opentdb.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(ResultApi::class.java)
        val call = service.getInfo()

        call.enqueue(object : Callback<ResultFeed> {
            override fun onResponse(call: Call<ResultFeed>, response: Response<ResultFeed>) {

                if(response.isSuccessful){
                    val quiz = response.body()!!
                    val stringBuilder = "Result: category ${quiz.category}  \n difficulty: ${quiz.difficulty}"

                    result.text = stringBuilder


                }

            }

            override fun onFailure(call: Call<ResultFeed>, error: Throwable) {
                println(error)
            }

        })







        backButton.setOnClickListener{

            finish()

        }





    }
}