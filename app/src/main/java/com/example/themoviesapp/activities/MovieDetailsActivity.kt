package com.example.themoviesapp.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.themoviesapp.R
import com.example.themoviesapp.data.models.MovieModel
import com.example.themoviesapp.data.models.MovieModelImpl
import com.example.themoviesapp.data.vos.GenreVO
import com.example.themoviesapp.data.vos.MovieVO
import com.example.themoviesapp.utils.IMAGE_BASE_URL
import com.example.themoviesapp.viewpods.ActorListViewPod
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_movie_details.*

class MovieDetailsActivity : AppCompatActivity() {
    private var mMovieModel: MovieModel = MovieModelImpl

    companion object {
        private const val EXTRA_MOVIE_ID = "EXTRA_MOVIE_ID"
        fun newIntent(contetxt: Context, movieId: Int): Intent {
            val intent = Intent(contetxt, MovieDetailsActivity::class.java)
            intent.putExtra(EXTRA_MOVIE_ID, movieId)
            return intent

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

        val movieId = intent.getIntExtra(EXTRA_MOVIE_ID, 0)

        Snackbar.make(window.decorView, movieId.toString(), Snackbar.LENGTH_SHORT).show()

        movieId?.let {
            requestData(it)
        }


    }

    private fun requestData(movieId: Int) {
        mMovieModel.getMovieDetails(movieId = movieId.toString(),
            onSuccess = {
                bindData(it)
            },
            onFailure = {

            })

        mMovieModel.getCreditByMovie(movieId = movieId.toString(),
            onSuccess = {
                mVpActors.setData(it.first)
                mVpCreators.setData(it.second)


            },
            onFailure = {

            })

    }

    private fun bindData(movie: MovieVO) {
        Glide.with(this)
            .load("$IMAGE_BASE_URL${movie.posterPath}")
            .into(ivMoviesDetails)
        tvMovieNameFromDetails.text = movie.title ?: ""
        tvMoviesReleaseYear.text = movie.releaseDate?.substring(0, 4) ?: ""
        tvRating.text = movie.voteAverage?.toString() ?: ""

        movie.voteCount?.let {
            tvNumbersOfVote.text = "$it VOTES"
        }
        rbRatingFromDetails.rating = movie.getRatingBasedOnFiveStars()

        bindGenres(movie, movie.genres ?: listOf())
        tvOverview.text = movie.overview ?: ""
        tvOriginalTitle.text = movie.title ?: ""
        rbRatingFromDetails.rating = movie.getRatingBasedOnFiveStars()


        tvPremiere.text = movie.releaseDate ?: ""
        tvDescription.text = movie.overview ?: ""

        tvType.text = movie.getGenresAsCommaSeparatedString()
        tvProduction.text = movie.getProductionCountriesAsCommaSeparatedString()


    }

    private fun bindGenres(
        movie: MovieVO,
        genre: List<GenreVO>
    ) {
        movie.genres?.count()?.let {
            tvFirstGenre.text = genre.firstOrNull()?.name ?: ""
            tvSecondGenre.text = genre.getOrNull(1)?.name ?: ""

        }

    }

    private fun setUpListener() {
        btnBack.setOnClickListener {
            super.onBackPressed()
        }
    }

    private fun setUpViewPod() {
        mVpActors = vpActors as ActorListViewPod
        mVpActors.setUpActorViewPod(R.color.colorPrimary, getString(R.string.lbl_actors), "")

        mVpCreators = vpCreaters as ActorListViewPod
        mVpCreators.setUpActorViewPod(
            R.color.colorPrimary,
            getString(R.string.lbl_creators),
            getString(R.string.lbl_more_actors)
        )


    }
}