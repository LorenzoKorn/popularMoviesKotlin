package com.example.popular_movies_kotlin.main.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.example.popular_movies_kotlin.R
import com.example.popular_movies_kotlin.main.model.Movie
import kotlinx.android.synthetic.main.activity_movie.*

const val MOVIE = "MOVIE"

class MovieDetail : AppCompatActivity() {

    private lateinit var movie: Movie

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)
        movie = intent.getParcelableExtra(MOVIE)
        supportActionBar?.title = movie.title
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        initView()
    }

    private fun initView() {
        Glide.with(this).load(movie.getBackdropUrl()).into(movie_backdrop)
        Glide.with(this).load(movie.getPosterUrl()).into(movie_poster)
        movie_title.text = movie.title
        movie_date.text = movie.releaseDate
        movie_rating.text = getString(R.string.rating, movie.rating.toString())
        movie_overview.text = movie.overview
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}
