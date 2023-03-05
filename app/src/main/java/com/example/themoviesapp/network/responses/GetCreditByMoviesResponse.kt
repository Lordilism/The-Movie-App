package com.example.themoviesapp.network.responses

import com.example.themoviesapp.data.vos.ActorVO
import com.google.gson.annotations.SerializedName

class GetCreditByMoviesResponse(
    @SerializedName("cast")
    val cast:List<ActorVO>?,

    @SerializedName("crew")
    val crew:List<ActorVO>?
) {
}