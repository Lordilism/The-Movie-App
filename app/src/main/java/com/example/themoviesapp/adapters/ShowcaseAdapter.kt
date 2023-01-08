package com.example.themoviesapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.themoviesapp.R
import com.example.themoviesapp.delegates.ShowcaseeViewHolderDelegate
import com.example.themoviesapp.viewholders.ShowcaseViewHolder

class ShowcaseAdapter(private val mDelegate:ShowcaseeViewHolderDelegate): RecyclerView.Adapter<ShowcaseViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowcaseViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.view_holder_show_cases,parent,false)
        return ShowcaseViewHolder(view,mDelegate)
    }

    override fun onBindViewHolder(holder: ShowcaseViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return 7
    }
}