package com.example.joke57.view

import com.example.joke57.model.JokeModel

interface JokeView {

    fun showJokeAnswer(jokeModel: JokeModel?)
    fun showError(error: String)

}