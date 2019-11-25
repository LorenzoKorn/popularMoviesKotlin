package com.example.popular_movies_kotlin.main.service

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MoviesApi {
    companion object {
        // baseUrl has to end with '/'
        private const val baseUrl = "https://api.themoviedb.org/3/discover/"

        /**
         * @return [MoviesApiService] The service class off the retrofit client
         */
        fun createApi(): MoviesApiService {
            //
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()

            // Create retrofit instance
            val moviesApi = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            // Return the retrofit MoviesApiService
            return moviesApi.create(MoviesApiService::class.java)
        }
    }
}