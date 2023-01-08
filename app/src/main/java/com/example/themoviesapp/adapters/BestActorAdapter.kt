package com.example.themoviesapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.themoviesapp.R
import com.example.themoviesapp.viewholders.BestActorViewHolder

class BestActorAdapter: RecyclerView.Adapter<BestActorViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestActorViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.view_holder_best_actor,parent,false)
        return BestActorViewHolder(view)
    }

    override fun onBindViewHolder(holder: BestActorViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return 10
    }
}