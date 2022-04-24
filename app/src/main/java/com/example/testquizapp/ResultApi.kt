package com.example.testquizapp

import retrofit2.Call
import retrofit2.http.GET

interface ResultApi {

    @GET("/api.php?amount=10&difficulty=easy")
    fun getInfo(): Call<ResultFeed>
}