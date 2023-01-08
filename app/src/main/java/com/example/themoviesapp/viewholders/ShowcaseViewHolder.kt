package com.example.themoviesapp.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.themoviesapp.delegates.ShowcaseeViewHolderDelegate

class ShowcaseViewHolder(itemView: View, private val mDelegate: ShowcaseeViewHolderDelegate) :
    RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener {
                mDelegate.onTapMovieFromShowcase()
            }
        }


}