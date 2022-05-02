package com.example.testquizapp

data class Result(
    val category: String,
    val correct_answer: String,
    val difficulty: String,
    val incorrect_answers: ArrayList<String>,
    val question: String,
    val type: String
)

class JoinedFeed(
    val questions: ArrayList<String>,
    val answers: ArrayList<ArrayList<String>>,
    val correct_answer: ArrayList<String>
)

class DoneFeed(
    val qCorrectAnswers: String,
    val qNegative: String
)
