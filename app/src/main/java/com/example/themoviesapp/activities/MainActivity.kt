package com.example.themoviesapp.activities

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.themoviesapp.R
import com.example.themoviesapp.adapters.BannerAdapter
import com.example.themoviesapp.adapters.ShowcaseAdapter
import com.example.themoviesapp.data.models.MovieModel
import com.example.themoviesapp.data.models.MovieModelImpl
import com.example.themoviesapp.data.vos.GenreVO
import com.example.themoviesapp.delegates.BannerViewHolderDelegate
import com.example.themoviesapp.delegates.MovieViewHolderDelegate
import com.example.themoviesapp.delegates.ShowcaseeViewHolderDelegate
import com.example.themoviesapp.viewpods.ActorListViewPod
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

    lateinit var mActorListViewPod: ActorListViewPod

    private val mMovieModel: MovieModel = MovieModelImpl

    private var mGenres: List<GenreVO>? = null


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

        //Listeners
        setUpListeners()
        //showcase recycler view
        setUpShowCaseRecyclerView()

        requestData()


    }

    private fun requestData() {
        //Now Playing Movies
        mMovieModel.getNowPlayingovies(
            onSuccess = {
                mBannerAdapter.setNewData(it)
            },
            onFailure = {

            }

        )

        //Popular Movies
        mMovieModel.getPopularMovies(
            onSuccess = {
                mBestPopularMoviesListViewPod.setData(it)
            },
            onFailure = {

            }
        )

        //ShowCase Movies
        mMovieModel.getTopRatedMovies(
            onSuccess = {
                mShowcaseAdapter.setNewData(it)
            },
            onFailure = {

            }
        )

        mMovieModel.getGenres(
            onSuccess = {
                mGenres = it
                setUpGenreTabLayout(it)
                /// Get Movies By Genre For First Genre
                it.firstOrNull()?.id?.let { genreId ->
                    getMovieByGenre(genreId)

                }

            },
            onFailure = {
                Snackbar.make(window.decorView, it, Snackbar.LENGTH_SHORT).show()

            }
        )

        mMovieModel.getActors(
            onSuccess = {
                mActorListViewPod.setData(it)

            },
            onFailure = {

            }
        )

    }

    private fun getMovieByGenre(genreId: Int) {
        mMovieModel.getMoviesByGenre(genreId = genreId.toString(),
            onSuccess = {
                mMoviesByGenresViewPod.setData(it)
            },
            onFailure = {
                Snackbar.make(window.decorView, it, Snackbar.LENGTH_SHORT)
                    .show()

            })
    }

    private fun setUpViewPod() {
        mBestPopularMoviesListViewPod = vpBestPopularMovieList as MoviesListViewPod
        mBestPopularMoviesListViewPod.setUpMovieListViewPod(this)
        mMoviesByGenresViewPod = vpMoviesByGenre as MoviesListViewPod
        mMoviesByGenresViewPod.setUpMovieListViewPod(this)

        mActorListViewPod = vpActorsList as ActorListViewPod


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
                mGenres?.get(tab?.position ?: 0)?.id?.let {
                    getMovieByGenre(it)
                }
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

    private fun setUpGenreTabLayout(genreList: List<GenreVO>) {
        genreList.forEach {
            tabLayoutGenre.newTab().apply {
                text = it.name
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

    override fun onTapMovieFromBanner(movieId: Int) {
        startActivity(MovieDetailsActivity.newIntent(this,movieId))
    }

    override fun onTapMovieFromShowcase(movieId: Int) {
        startActivity(MovieDetailsActivity.newIntent(this,movieId))

    }

    override fun onTapMovies(movieId: Int) {
        startActivity(MovieDetailsActivity.newIntent(this, movieId = movieId))
    }
}