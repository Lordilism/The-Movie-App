package com.example.themoviesapp.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.themoviesapp.R

class MovieDetailsActivity : AppCompatActivity() {
    companion object{
        fun newIntent(contetxt:Context):Intent{
            return Intent(contetxt,MovieDetailsActivity::class.java)

        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
    }
}