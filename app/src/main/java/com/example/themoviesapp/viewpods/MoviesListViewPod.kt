package com.example.themoviesapp.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.themoviesapp.adapters.MoviesAdapter
import kotlinx.android.synthetic.main.view_pod_movies_list.view.*

class MoviesListViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {
    lateinit var mMovieAdapter:MoviesAdapter
    override fun onFinishInflate() {
        setUpMovieRecyclerView()
        super.onFinishInflate()
    }

    private fun setUpMovieRecyclerView() {
        mMovieAdapter= MoviesAdapter()
        rvMoviesList.adapter=mMovieAdapter
        rvMoviesList.layoutManager= LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)

    }
}