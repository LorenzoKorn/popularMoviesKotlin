package com.example.popular_movies_kotlin.main.model

class MoviesData {
    var results: List<Movie>? = null

    class Movie {
        var backdrop_path: String? = null
        var poster_path: String? = null
        var title: String? = null
        var release_date: String? = null
        var vote_average: Double? = 0.toDouble()
        var overview: String? = null

        fun getPosterUrl(): String = "https://image.tmdb.org/t/p/w500$poster_path"
        fun getBackdropUrl(): String = "https://image.tmdb.org/t/p/w500$backdrop_path"
    }
}