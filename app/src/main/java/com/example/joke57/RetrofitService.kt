package com.example.joke57

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

    var retrofit = Retrofit.Builder().baseUrl("https://dad-jokes.p.rapidapi.com/")
        .addConverterFactory(GsonConverterFactory.create()).build()

    var api = retrofit.create(JokeApi::class.java)
}