package com.example.themoviesapp.viewpods

import android.content.Context
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.RelativeLayout
import androidx.core.content.ContextCompat
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
    fun setUpActorViewPod(backgroundColorRef: Int,titleText:String, moreTitleText:String){
        setBackgroundColor(ContextCompat.getColor(context,backgroundColorRef))
        tvBestActors.text= titleText
        tvMoreActors.text= moreTitleText
        tvMoreActors.paintFlags= Paint.UNDERLINE_TEXT_FLAG

    }

    private fun setUpActorRecyclerView() {
        mActorAdapter= BestActorAdapter()
        rvBestActors.adapter= mActorAdapter
        rvBestActors.layoutManager= LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
    }
}