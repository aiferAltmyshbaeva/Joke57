package com.example.joke57

import com.example.joke57.model.JokeModel
import com.example.joke57.model.RetrofitService
import com.example.joke57.view.JokeView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Presenter(val jokeView: JokeView) {

    var api = RetrofitService.api

    fun getJokeAnswer() {
        api.getJoke().enqueue(object : Callback<JokeModel> {
            override fun onResponse(call: Call<JokeModel>, response: Response<JokeModel>) {
                jokeView.showJokeAnswer(response.body())
            }

            override fun onFailure(call: Call<JokeModel>, t: Throwable) {
                jokeView.showError(t.message.toString())
            }
        })

    }
}