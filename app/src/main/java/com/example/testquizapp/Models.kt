package com.example.testquizapp

import com.google.gson.annotations.SerializedName

class StatFeed(val name: String, val image: Int)

class AllResults(
    val results: List<ResultFeed>,
    val response_code: Int
)

class QuizResults(
    val results: String
)

class ResultFeed(
    @SerializedName("category")
    var category : String = "",
    @SerializedName("difficulty")
var difficulty: String = ""

)

class JoinedFeed(
    val questions: ArrayList<String>,
    val answers: ArrayList<ArrayList<String>>,
    val correct_answer: ArrayList<String>
)