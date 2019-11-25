package com.example.popular_movies_kotlin.main.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.popular_movies_kotlin.R

const val MOVIE = "MOVIE"

class MovieDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)
    }
}
