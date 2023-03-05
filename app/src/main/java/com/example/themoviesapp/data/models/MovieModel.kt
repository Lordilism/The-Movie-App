package com.example.themoviesapp.data.models

import com.example.themoviesapp.data.vos.ActorVO
import com.example.themoviesapp.data.vos.GenreVO
import com.example.themoviesapp.data.vos.MovieVO

interface MovieModel {
    fun getNowPlayingovies(
        onSuccess:(List<MovieVO>)-> Unit,
        onFailure:(String)->Unit
    )

    fun getPopularMovies(
        onSuccess:(List<MovieVO>)-> Unit,
        onFailure:(String)->Unit
    )

    fun getTopRatedMovies(
        onSuccess:(List<MovieVO>)-> Unit,
        onFailure:(String)->Unit
    )

    fun getGenres(
        onSuccess: (List<GenreVO>) -> Unit,
        onFailure: (String) -> Unit

    )

    fun getMoviesByGenre(
        genreId: String,
        onSuccess: (List<MovieVO>) -> Unit,
        onFailure: (String) -> Unit
    )

    fun getActors(
        onSuccess: (List<ActorVO>) -> Unit,
        onFailure: (String) -> Unit
    )

    fun getMovieDetails(
        movieId:String,
        onSuccess: (MovieVO) -> Unit,
        onFailure: (String) -> Unit
    )

    fun getCreditByMovie(
        movieId: String,
        onSuccess: (Pair<List<ActorVO>,List<ActorVO>>) -> Unit,
        onFailure: (String) -> Unit
    )
}