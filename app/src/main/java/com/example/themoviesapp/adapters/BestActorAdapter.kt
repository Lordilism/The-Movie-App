package com.example.themoviesapp.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.themoviesapp.R
import com.example.themoviesapp.data.vos.ActorVO
import com.example.themoviesapp.viewholders.BestActorViewHolder

class BestActorAdapter: RecyclerView.Adapter<BestActorViewHolder>() {

    private var mActorList: List<ActorVO> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestActorViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.view_holder_best_actor,parent,false)
        return BestActorViewHolder(view)
    }

    override fun onBindViewHolder(holder: BestActorViewHolder, position: Int) {
        if (mActorList.isNotEmpty()){
            holder.bindData(mActorList[position])

        }
    }

    override fun getItemCount(): Int {
        return mActorList.count()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setNewData(actor:List<ActorVO>){
        mActorList=  actor
        notifyDataSetChanged()

    }

}