package com.example.popular_movies_kotlin.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.popular_movies_kotlin.BuildConfig
import com.example.popular_movies_kotlin.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    private fun initView() {
        year_submit_btn.setOnClickListener {
            val lol = year_input.text.toString()
            Toast.makeText(this, "Search for movies! $lol", Toast.LENGTH_SHORT).show()
        }
    }
}
