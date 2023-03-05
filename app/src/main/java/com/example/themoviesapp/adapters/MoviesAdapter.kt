package com.example.themoviesapp.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.themoviesapp.R
import com.example.themoviesapp.data.vos.MovieVO
import com.example.themoviesapp.delegates.MovieViewHolderDelegate
import com.example.themoviesapp.viewholders.MoviesViewHolder

class MoviesAdapter(private val mDelegate:MovieViewHolderDelegate) : RecyclerView.Adapter<MoviesViewHolder>() {
    private var mMovieList: List<MovieVO> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.view_holder_movies, parent, false)
        return MoviesViewHolder(view,mDelegate)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        if (mMovieList.isNotEmpty()){
            holder.bindData(mMovieList[position])
        }
    }

    override fun getItemCount(): Int {
        return mMovieList.count()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setNewData(movieList :List<MovieVO>){
        mMovieList = movieList
        notifyDataSetChanged()
    }
}