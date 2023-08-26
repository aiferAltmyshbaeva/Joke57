package com.example.joke57

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.joke57.databinding.ActivityMainBinding
import com.example.joke57.model.JokeModel
import com.example.joke57.view.JokeView

class MainActivity : AppCompatActivity(R.layout.activity_main), JokeView {

    private val binding: ActivityMainBinding by viewBinding()
    private val presenter = Presenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initClickers()
    }

    private fun initClickers() {
        with(binding) {
            jokeBtn.setOnClickListener {
                presenter.getJokeAnswer()
            }
        }
    }

    override fun showJokeAnswer(jokeModel: JokeModel?) {
        binding.jokeTv.text = jokeModel?.body?.first()?.setup.toString()
        binding.punchlineTv.text = jokeModel?.body?.first()?.punchline.toString()
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }
}