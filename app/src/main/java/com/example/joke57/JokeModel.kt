package com.example.joke57

data class JokeModel(
    val body: ArrayList<JokeAnswerModel>
)

data class JokeAnswerModel(
    val setup: String,
    val punchline: String
)
