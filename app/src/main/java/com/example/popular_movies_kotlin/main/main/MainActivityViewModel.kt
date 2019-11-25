package com.example.popular_movies_kotlin.main.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.popular_movies_kotlin.main.database.MoviesRepository
import com.example.popular_movies_kotlin.main.model.Movie
import com.example.popular_movies_kotlin.main.model.MovieData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {
    private val moviesRepository: MoviesRepository = MoviesRepository()
    val movies = MutableLiveData<List<Movie>>()
    val error = MutableLiveData<String>()

    fun getMoviesFromYear(year: String) {
        moviesRepository.getMoviesFromYear(year).enqueue(object : Callback<MovieData?> {
            override fun onResponse(call: Call<MovieData?>, response: Response<MovieData?>) {
                if (response.isSuccessful) {
                    movies.value = response.body()!!.results
                } else {
                    error.value = "An error has occurred: ${response.errorBody().toString()}"
                }
            }

            override fun onFailure(call: Call<MovieData?>, t: Throwable) {
                error.value = t.message
            }
        })
    }
}
