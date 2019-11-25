package com.example.popular_movies_kotlin.main.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.popular_movies_kotlin.R
import com.example.popular_movies_kotlin.main.model.Movie
import com.example.popular_movies_kotlin.main.model.MovieAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainActivityViewModel
    private var movies = arrayListOf<Movie>()
    private var moviesAdapter = MovieAdapter(movies) { movie -> openMovie(movie) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        initRecyclerView()
        initViewModel()
    }

    private fun openMovie(movie: Movie) {
        var intent = Intent(this, MovieDetail::class.java)
        intent.putExtra(MOVIE, movie)
        startActivity(intent)
    }

    private fun initView() {
        year_submit_btn.setOnClickListener {
            viewModel.getMoviesFromYear(year_input.text.toString())
        }
    }

    private fun initRecyclerView() {
        val columns = 2
        movie_list.layoutManager = StaggeredGridLayoutManager(columns, RecyclerView.VERTICAL)
        movie_list.adapter = moviesAdapter
        movie_list.addItemDecoration(
            DividerItemDecoration(
                this@MainActivity,
                DividerItemDecoration.VERTICAL
            )
        )
    }

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)

        viewModel.movies.observe(this, Observer {
            movies.clear()
            movies.addAll(it)
            moviesAdapter.notifyDataSetChanged()
        })

        viewModel.error.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })
    }
}
