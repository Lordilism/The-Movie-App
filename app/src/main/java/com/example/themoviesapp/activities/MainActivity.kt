package com.example.themoviesapp.activities

import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.themoviesapp.R
import com.example.themoviesapp.adapters.BannerAdapter
import com.example.themoviesapp.adapters.ShowcaseAdapter
import com.example.themoviesapp.delegates.BannerViewHolderDelegate
import com.example.themoviesapp.delegates.MovieViewHolderDelegate
import com.example.themoviesapp.delegates.ShowcaseeViewHolderDelegate
import com.example.themoviesapp.dummy.dummyGenreList
import com.example.themoviesapp.viewpods.MoviesListViewPod
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BannerViewHolderDelegate, ShowcaseeViewHolderDelegate,
    MovieViewHolderDelegate {

    lateinit var mBannerAdapter: BannerAdapter
    lateinit var mShowcaseAdapter: ShowcaseAdapter

    lateinit var mBestPopularMoviesListViewPod: MoviesListViewPod  // View pod reference
    lateinit var mMoviesByGenresViewPod: MoviesListViewPod


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //App Bar leading icon
        setUpToolBar()
        //View pod
        setUpViewPod()
        //Set up Banner View Pager
        setUpBannerViewPager()
        //SET UP TAB
        setUpGenreTabLayout()
        //Listeners
        setUpListeners()
        //showcase recycler view
        setUpShowCaseRecyclerView()


    }

    private fun setUpViewPod() {
        mBestPopularMoviesListViewPod = vpBestPopularMovieList as MoviesListViewPod
        mBestPopularMoviesListViewPod.setUpMovieListViewPod(this)
        mMoviesByGenresViewPod = vpMoviesByGenre as MoviesListViewPod
        mMoviesByGenresViewPod.setUpMovieListViewPod(this)
    }

    private fun setUpShowCaseRecyclerView() {
        mShowcaseAdapter = ShowcaseAdapter(this)
        rvShowCases.adapter = mShowcaseAdapter
        rvShowCases.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    }

    private fun setUpListeners() {
        //Genre Tab Layout
        tabLayoutGenre.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                Snackbar.make(window.decorView, tab?.text ?: "", Snackbar.LENGTH_SHORT).show()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })

    }


    private fun setUpBannerViewPager() {
        mBannerAdapter = BannerAdapter(this)
        viewPagerBanner.adapter = mBannerAdapter

        //Dots Indicator Banner
        dotsIndicatorBanner.attachTo(viewPagerBanner)
    }

    private fun setUpGenreTabLayout() {
        dummyGenreList.forEach {
            tabLayoutGenre.newTab().apply {
                text = it
                tabLayoutGenre.addTab(this)
            }
        }

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

    override fun onTapMovieFromBanner() {
        startActivity(MovieDetailsActivity.newIntent(this))
    }

    override fun onTapMovieFromShowcase() {
        startActivity(MovieDetailsActivity.newIntent(this))

    }

    override fun onTapMovies() {
        startActivity(MovieDetailsActivity.newIntent(this))
    }
}