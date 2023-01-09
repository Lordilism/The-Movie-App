package com.example.themoviesapp.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.themoviesapp.R
import com.example.themoviesapp.viewpods.ActorListViewPod
import kotlinx.android.synthetic.main.activity_movie_details.*

class MovieDetailsActivity : AppCompatActivity() {
    companion object {
        fun newIntent(contetxt: Context): Intent {
            return Intent(contetxt, MovieDetailsActivity::class.java)

        }
    }

    //View Pod
    lateinit var mVpActors: ActorListViewPod
    lateinit var mVpCreators: ActorListViewPod

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
        setUpViewPod()
        setUpListener()
    }

    private fun setUpListener() {
        btnBack.setOnClickListener {
            super.onBackPressed()
        }
    }

    private fun setUpViewPod() {
        mVpActors = vpActors as ActorListViewPod
        mVpActors.setUpActorViewPod(R.color.colorPrimary,getString(R.string.lbl_actors),"")

        mVpCreators = vpCreaters as ActorListViewPod
        mVpCreators.setUpActorViewPod(R.color.colorPrimary,getString(R.string.lbl_creators),getString(R.string.lbl_more_actors))


    }
}