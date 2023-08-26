package com.example.joke57

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.joke57.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val binding:ActivityMainBinding by viewBinding()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initClickers()
    }

    private fun initClickers() {
with(binding){
    jokeBtn.setOnClickListener {
        RetrofitService.api.getJoke().enqueue(object : Callback<JokeModel> {
            override fun onResponse(call: Call<JokeModel>, response: Response<JokeModel>) {
            jokeTv.text = response.body()?.body?.first()?.setup.toString()
            punchlineTv.text = response.body()?.body?.first()?.punchline.toString()
            }

            override fun onFailure(call: Call<JokeModel>, t: Throwable) {
                Log.e("ololo", "onFailure: ${t.message}", )
            }
        })
    }
}
    }
}