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
        var selectedAnswers: ArrayList<String> = ArrayList()
        val allJoined: ArrayList<JoinedFeed> = ArrayList()
        var questionNr: Int = 0
        var isCorrect: Int = 0
        var isIncorrect: Int = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)


        var backButton = findViewById<ImageButton>(R.id.btnBack)
        val questions: ArrayList<String> = ArrayList()
        val allAnswers: ArrayList<ArrayList<String>> = ArrayList()
        val allCorrectAnswers: ArrayList<String> = ArrayList()


        val retrofit = Retrofit.Builder()
            .baseUrl("https://opentdb.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(ResultApi::class.java)
        val call = service.getInfo(10,"easy")

        call.enqueue(object : Callback<ResultFeed> {
            override fun onResponse(call: Call<ResultFeed>, response: Response<ResultFeed>) {

                if(response.isSuccessful){
                    val quiz = response.body()!!
                    val stringBuilder = "${quiz.results}"

                    for((index, value) in quiz.results.withIndex()){
                        val mainFeed = quiz.results
                        val question = mainFeed[index].question
                        questions.add(question)

                        val answers = mainFeed[index].incorrect_answers
                        answers.add((0..3).random(), mainFeed[index].correct_answer)
                        allAnswers.add(answers)

                        val canswers = mainFeed[index].correct_answer
                        allCorrectAnswers.add(canswers)


                    }


                }


                allJoined.add(
                    JoinedFeed(
                        questions = questions,
                        answers = allAnswers,
                        correct_answer = allCorrectAnswers
                    ))

                startQuiz()
            }

            private fun startQuiz(){
                val progress = findViewById<TextView>(R.id.tvProgress)
                var questionView = findViewById<TextView>(R.id.tvQuestion)


                val currentQuestion = allJoined[0].questions[questionNr]

                questionNr++
                progress.text="{${questionNr}/ ${allJoined[0].questions.count()}}"

                questionView.text = currentQuestion






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