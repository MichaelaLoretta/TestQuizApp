package com.example.testquizapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ResultApi {

    @GET("api.php")
    fun getInfo(@Query("amount") amount: Int,
    @Query("category") category: Int, @Query("type") type: String): Call<ResultFeed>
}