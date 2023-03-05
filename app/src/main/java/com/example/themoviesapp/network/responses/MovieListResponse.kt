package com.example.themoviesapp.network.responses

import com.example.themoviesapp.data.vos.DateVO
import com.example.themoviesapp.data.vos.MovieVO
import com.google.gson.annotations.SerializedName

data class MovieListResponse(
    @SerializedName("dates")
    val dates: DateVO?,

    @SerializedName("page")
    val page: Int?,

    @SerializedName("results")
    val results: List<MovieVO>?
)