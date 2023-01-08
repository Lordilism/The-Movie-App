package com.example.themoviesapp.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.themoviesapp.adapters.MoviesAdapter
import com.example.themoviesapp.delegates.MovieViewHolderDelegate
import kotlinx.android.synthetic.main.view_pod_movies_list.view.*

class MoviesListViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {
    lateinit var mMovieAdapter: MoviesAdapter
    lateinit var mDelegate: MovieViewHolderDelegate
    override fun onFinishInflate() {
//        setUpMovieRecyclerView()
        super.onFinishInflate()
    }

    fun setUpMovieListViewPod(delegate: MovieViewHolderDelegate) {
        setDelegate(delegate)
        setUpMovieRecyclerView()
    }

    private fun setDelegate(delegate: MovieViewHolderDelegate) {
        this.mDelegate = delegate
    }


    private fun setUpMovieRecyclerView() {
        mMovieAdapter = MoviesAdapter(mDelegate)
        rvMoviesList.adapter = mMovieAdapter
        rvMoviesList.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

    }
}