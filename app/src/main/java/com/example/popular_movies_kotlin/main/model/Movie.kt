package com.example.popular_movies_kotlin.main.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Movie(
    @SerializedName("title") var title: String,
    @SerializedName("backdrop_path") var backdropPath: String,
    @SerializedName("poster_path") var posterPath: String,
    @SerializedName("release_date") var releaseDate: String,
    @SerializedName("vote_average") var rating: Double,
    @SerializedName("overview") var overview: String
) : Parcelable {
    fun getPosterUrl() = "https://image.tmdb.org/t/p/w500$posterPath"
    fun getBackdropUrl() = "https://image.tmdb.org/t/p/w500$backdropPath"
}