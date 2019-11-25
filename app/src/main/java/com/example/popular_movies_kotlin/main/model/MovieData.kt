package com.example.popular_movies_kotlin.main.model

import com.google.gson.annotations.SerializedName

class MovieData {
    @SerializedName("results")
    var results: List<Movie>? = null
}