package com.example.popular_movies_kotlin.main.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.popular_movies_kotlin.main.database.MoviesRepository
import com.example.popular_movies_kotlin.main.model.MoviesData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {
    private val moviesRepository: MoviesRepository = MoviesRepository()
    val movies = MutableLiveData<MoviesData>()
    val error = MutableLiveData<String>()

    fun getMoviesFromYear(year: String) {
        moviesRepository.getMoviesFromYear(year).enqueue(object : Callback<MoviesData?> {
            override fun onResponse(call: Call<MoviesData?>, response: Response<MoviesData?>) {
                if (response.isSuccessful) {
                    movies.value = response.body()
                } else {
                    error.value = "An error has occurred: ${response.errorBody().toString()}"
                }
            }

            override fun onFailure(call: Call<MoviesData?>, t: Throwable) {
                error.value = t.message
            }
        })
    }
}
