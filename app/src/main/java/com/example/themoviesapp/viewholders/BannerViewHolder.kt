package com.example.themoviesapp.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.themoviesapp.delegates.BannerViewHolderDelegate

class BannerViewHolder(itemView: View, private val mDelegate: BannerViewHolderDelegate) :
    RecyclerView.ViewHolder(itemView) {
    init {
        itemView.setOnClickListener {
            mDelegate.onTapMovieFromBanner()
        }
    }
}