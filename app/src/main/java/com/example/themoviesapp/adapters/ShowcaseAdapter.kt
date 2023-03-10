package com.example.themoviesapp.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.themoviesapp.R
import com.example.themoviesapp.data.vos.MovieVO
import com.example.themoviesapp.delegates.ShowcaseeViewHolderDelegate
import com.example.themoviesapp.viewholders.ShowcaseViewHolder

class ShowcaseAdapter(private val mDelegate:ShowcaseeViewHolderDelegate): RecyclerView.Adapter<ShowcaseViewHolder>() {
    private var mMovieList:List<MovieVO> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowcaseViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.view_holder_show_cases,parent,false)
        return ShowcaseViewHolder(view,mDelegate)
    }

    override fun onBindViewHolder(holder: ShowcaseViewHolder, position: Int) {
        if (mMovieList.isNotEmpty()){
            holder.bindData(mMovieList[position])
        }
    }

    override fun getItemCount(): Int {
        return mMovieList.count()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setNewData(movieList: List<MovieVO>){
        mMovieList = movieList
        notifyDataSetChanged()
    }




}