package com.example.themoviesapp.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.themoviesapp.data.vos.MovieVO
import com.example.themoviesapp.delegates.ShowcaseeViewHolderDelegate
import com.example.themoviesapp.utils.IMAGE_BASE_URL
import kotlinx.android.synthetic.main.view_holder_show_cases.view.*

class ShowcaseViewHolder(itemView: View, private val mDelegate: ShowcaseeViewHolderDelegate) :
    RecyclerView.ViewHolder(itemView) {
    private var mMovie:MovieVO? = null
        init {
            itemView.setOnClickListener {
                mMovie?.let {
                    mDelegate.onTapMovieFromShowcase(it.id?:0)
                }

            }
        }

    fun bindData(movies:MovieVO){
        mMovie= movies
        Glide.with(itemView.context)
            .load("$IMAGE_BASE_URL${movies.posterPath}")
            .into(itemView.ivShowcase)
        itemView.tvShowcaseMovieName.text = movies.title
        itemView.tvShowcaseMoviesDate.text = movies.releaseDate
    }




}