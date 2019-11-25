package com.example.popular_movies_kotlin.main.database

import com.example.popular_movies_kotlin.main.service.MoviesApi
import com.example.popular_movies_kotlin.main.service.MoviesApiService

class MoviesRepository {
    private val moviesApi: MoviesApiService = MoviesApi.createApi()

    fun getMoviesFromYear(year: String) = moviesApi.getMoviesFromYear(year)
}