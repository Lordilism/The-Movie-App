package com.example.themoviesapp.network.responses

import com.example.themoviesapp.data.vos.GenreVO
import com.google.gson.annotations.SerializedName

class GetGenreResponse(
    @SerializedName("genres")
    val genres:List<GenreVO>?
) {
}