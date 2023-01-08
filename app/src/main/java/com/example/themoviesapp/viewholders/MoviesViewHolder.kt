package com.example.themoviesapp.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.themoviesapp.delegates.MovieViewHolderDelegate

class MoviesViewHolder(itemView: View,private val mDelegate:MovieViewHolderDelegate) : RecyclerView.ViewHolder(itemView) {
    init {
        itemView.setOnClickListener {
            mDelegate.onTapMovies()
        }
    }
}