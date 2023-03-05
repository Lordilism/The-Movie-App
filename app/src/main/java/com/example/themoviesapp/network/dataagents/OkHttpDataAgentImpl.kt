package com.example.themoviesapp.network.dataagents

import android.os.AsyncTask
import com.example.themoviesapp.data.vos.ActorVO
import com.example.themoviesapp.data.vos.GenreVO
import com.example.themoviesapp.data.vos.MovieVO
import com.example.themoviesapp.network.responses.MovieListResponse
import com.example.themoviesapp.utils.API_GET_NOW_PLAYING
import com.example.themoviesapp.utils.BASE_URL
import com.example.themoviesapp.utils.MOVIE_API_KEY
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request
import java.lang.Exception
import java.util.concurrent.TimeUnit

object OkHttpDataAgentImpl : MovieDataAgent {

    private val mClient: OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(15, TimeUnit.SECONDS)
        .readTimeout(15, TimeUnit.SECONDS)
        .writeTimeout(15, TimeUnit.SECONDS)
        .build()




    class GetNowPlayingMovieOkHttpTask(
        private val mOkHttpClient: OkHttpClient
    ) : AsyncTask<Void, Void, MovieListResponse>() {
        override fun doInBackground(vararg params: Void?): MovieListResponse? {
            val request = Request.Builder()
                .url("""$BASE_URL$API_GET_NOW_PLAYING?api_key=$MOVIE_API_KEY&language=en-US&page=1""")
                .build()

            try {
                val response = mOkHttpClient.newCall(request).execute()

                if (response.isSuccessful) {
                    response.body?.let {
                        val responseString = it.string()
                        val response = Gson().fromJson<MovieListResponse>(
                            responseString, MovieListResponse::class.java
                        )
                        return response
                    }
                }

            }catch (e:Exception){
                e.printStackTrace()
            }
            return null
        }

        override fun onPostExecute(result: MovieListResponse?) {
            super.onPostExecute(result)
        }

    }

    override fun getNowPlayingMovies(
        onSuccess: (List<MovieVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {

    }

    override fun getPopularMovies(onSuccess: (List<MovieVO>) -> Unit, onFailure: (String) -> Unit) {

    }

    override fun getTopRatedMovies(
        onSuccess: (List<MovieVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {

    }

    override fun getGenres(onSuccess: (List<GenreVO>) -> Unit, onFailure: (String) -> Unit) {

    }

    override fun getMoviesByGenre(
        genreId: String,
        onSuccess: (List<MovieVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {

    }

    override fun getActors(onSuccess: (List<ActorVO>) -> Unit, onFailure: (String) -> Unit) {

    }

    override fun getMoviesDetails(
        movieId: String,
        onSuccess: (MovieVO) -> Unit,
        onFailure: (String) -> Unit
    ) {

    }

    override fun getCreditsByMovie(
        movieId: String,
        onSuccess: (Pair<List<ActorVO>, List<ActorVO>>) -> Unit,
        onFailure: (String) -> Unit
    ) {

    }
}