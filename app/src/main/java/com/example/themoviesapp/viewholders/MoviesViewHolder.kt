package com.example.themoviesapp.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.themoviesapp.data.vos.MovieVO
import com.example.themoviesapp.delegates.MovieViewHolderDelegate
import com.example.themoviesapp.utils.IMAGE_BASE_URL
import kotlinx.android.synthetic.main.view_holder_movies.view.*

class MoviesViewHolder (itemView: View,private val mDelegate:MovieViewHolderDelegate) : RecyclerView.ViewHolder(itemView) {

    private var mMovieVO:MovieVO? = null
    init {

        itemView.setOnClickListener {
            mMovieVO?.let {movie->
                mDelegate.onTapMovies(movie.id?:0)
            }

        }
    }

    fun bindData(movie:MovieVO){
        mMovieVO = movie
        Glide.with(itemView.context)
            .load("$IMAGE_BASE_URL${movie.posterPath}")
            .into(itemView.ivMovieImage)
        itemView.tvMovieName.text = movie.title
        itemView.tvMovieRating.text = movie.voteAverage?.toString()
        itemView.rbMovieRating.rating = movie.getRatingBasedOnFiveStars()
    }
}