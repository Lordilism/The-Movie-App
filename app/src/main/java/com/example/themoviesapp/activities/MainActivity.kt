package com.example.themoviesapp.activities

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import com.example.themoviesapp.R
import com.example.themoviesapp.adapters.BannerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var mBannerAdapter: BannerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //App Bar leading icon
        setUpToolBar()
        //Set up Banner View Pager
        setUpBannerViewPager()

    }

    private fun setUpBannerViewPager() {
        mBannerAdapter = BannerAdapter()
        viewPagerBanner.adapter = mBannerAdapter
    }

    private fun setUpToolBar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_discover, menu)
        return true
    }
}