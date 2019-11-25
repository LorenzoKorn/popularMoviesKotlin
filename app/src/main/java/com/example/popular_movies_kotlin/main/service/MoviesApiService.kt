package com.example.popular_movies_kotlin.main.service

import com.example.popular_movies_kotlin.BuildConfig
import retrofit2.Call
import retrofit2.http.GET
import com.example.popular_movies_kotlin.main.model.MovieData
import retrofit2.http.Query

interface MoviesApiService {

    // Get all the english movies in given year
    @GET("movie?api_key=${BuildConfig.API_KEY}&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1")
    fun getMoviesFromYear(@Query("year") year: String): Call<MovieData>
}