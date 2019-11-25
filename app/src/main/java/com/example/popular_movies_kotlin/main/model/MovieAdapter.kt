package com.example.popular_movies_kotlin.main.model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.popular_movies_kotlin.R
import kotlinx.android.synthetic.main.movie_poster.view.*

class MovieAdapter(private val movies: List<Movie>, private val onClick: (Movie) -> Unit): RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        context = parent.context
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.movie_poster, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener {
                onClick(movies[adapterPosition])
            }
        }

        fun bind(movie: Movie) {
            itemView.movie_index.text = (movies.indexOf(movie) + 1).toString()
            Glide.with(context).load(movie.getPosterUrl()).into(itemView.movie_poster)
        }
    }
}