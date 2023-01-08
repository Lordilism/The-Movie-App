package com.example.themoviesapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.themoviesapp.R
import com.example.themoviesapp.delegates.MovieViewHolderDelegate
import com.example.themoviesapp.viewholders.MoviesViewHolder

class MoviesAdapter(private val mDelegate:MovieViewHolderDelegate) : RecyclerView.Adapter<MoviesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.view_holder_movies, parent, false)
        return MoviesViewHolder(view,mDelegate)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return 10
    }
}