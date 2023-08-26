package com.example.joke57

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header


interface JokeApi {

    @GET("random/joke/")
    fun getJoke(
        @Header("X-RapidAPI-Key") key: String = "b6409bed9dmsh48a1cfe4123e353p100701jsn52a59220eee8",
        @Header("X-RapidAPI-Host") host: String = "dad-jokes.p.rapidapi.com"
    ): Call<JokeModel>

}