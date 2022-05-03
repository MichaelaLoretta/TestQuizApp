package com.example.testquizapp
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



class QuizActivity : AppCompatActivity() {

    companion object {

        val allJoined: ArrayList<JoinedFeed> = ArrayList()
        var questionNr: Int = 0
        var isCorrect: Int = 0
        var isIncorrect: Int = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        val answers: ListView = findViewById(R.id.answersList)


        val questions: ArrayList<String> = ArrayList()
        val allAnswers: ArrayList<ArrayList<String>> = ArrayList()
        val allCorrectAnswers: ArrayList<String> = ArrayList()


        val retrofit = Retrofit.Builder()
            .baseUrl("https://opentdb.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(ResultApi::class.java)
        val call = service.getInfo(10, 12, "multiple")

        call.enqueue(object : Callback<ResultFeed> {
            override fun onResponse(call: Call<ResultFeed>, response: Response<ResultFeed>) {

                if (response.isSuccessful) {
                    val quiz = response.body()!!

                    for ((index) in quiz.results.withIndex()) {
                        val mainFeed = quiz.results
                        val question = mainFeed[index].question
                        questions.add(question)

                        val answers = mainFeed[index].incorrect_answers
                        answers.add((0..3).random(), mainFeed[index].correct_answer)
                        allAnswers.add(answers)

                        val cAnswers = mainFeed[index].correct_answer
                        allCorrectAnswers.add(cAnswers)


                        allJoined.add(
                            JoinedFeed(
                                questions = questions,
                                answers = allAnswers,
                                correct_answer = allCorrectAnswers
                            )
                        )

                    }

                    startQuiz()


                }

            }

            override fun onFailure(call: Call<ResultFeed>, error: Throwable) {
                println(error)
            }


            private fun startQuiz() {
                val progress = findViewById<TextView>(R.id.tvProgress)
                val nextButton = findViewById<ImageButton>(R.id.btnNext)
                val questionView = findViewById<TextView>(R.id.tvQuestion)

                var questionNum = questionNr

                //get the current question
                val currentQuestion = allJoined[0].questions[questionNr]

                //increase displayed progressnr by one
                questionNum++
                progress.text = "{${questionNum}/ ${allJoined[0].questions.count()}}"

                //display the current question
                questionView.text = currentQuestion

                //display the answers
                val qAnswers: ArrayList<String> = allJoined[0].answers[questionNr]
                setAnswers(qAnswers)


                answers.setOnItemClickListener { _, _, _, id ->
                    val clickedId = id.toInt()
                    val correctAnswer = allJoined[0].correct_answer[questionNr]
                    val selectedAnswer = allJoined[0].answers[questionNr][clickedId]
                    val answerIsCorrect = selectedAnswer == correctAnswer


                    if (answerIsCorrect) {
                        isCorrect++
                    } else {
                        isIncorrect++
                    }

                    if (selectedAnswer == correctAnswer) {
                        Toast.makeText(
                            this@QuizActivity,
                            "Yay! Correct $correctAnswer",
                            Toast.LENGTH_SHORT
                        ).show()

                    } else {
                        Toast.makeText(
                            this@QuizActivity,
                            "Sorry, Incorrect. Answer was $correctAnswer",
                            Toast.LENGTH_SHORT
                        ).show()
                    }


                    if (questionNum == allJoined[0].questions.count()) {

                        nextButton.setOnClickListener {

                            val intent = Intent(this@QuizActivity, CongratsActivity::class.java)
                            intent.putExtra("Correct", isCorrect)
                            startActivity(intent)

                        }


                    } else {
                        nextButton.setOnClickListener {
                            questionNum++
                            questionNr++

                            progress.text = "${questionNum}/${allJoined[0].questions.count()}"
                            questionView.text = allJoined[0].questions[questionNr]

                            val newAnswers = allJoined[0].answers[questionNr]
                            setAnswers(newAnswers)

                        }


                    }


                }


            }


            fun setAnswers(qAnswers: ArrayList<String>) {
                for (value in qAnswers) {
                    answers.adapter = AnswerAdapter(this@QuizActivity, qAnswers)
                }


            }


        })
    }
}