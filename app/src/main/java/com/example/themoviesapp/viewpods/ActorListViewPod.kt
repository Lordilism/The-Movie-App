package com.example.themoviesapp.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.themoviesapp.adapters.BestActorAdapter
import kotlinx.android.synthetic.main.view_pod_actor_list.view.*

class ActorListViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : RelativeLayout(context, attrs) {
    lateinit var mActorAdapter: BestActorAdapter

    override fun onFinishInflate() {
        setUpActorRecyclerView()
        super.onFinishInflate()
    }

    private fun setUpActorRecyclerView() {
        mActorAdapter= BestActorAdapter()
        rvBestActors.adapter= mActorAdapter
        rvBestActors.layoutManager= LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
    }
}