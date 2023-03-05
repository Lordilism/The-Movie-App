package com.example.themoviesapp.network.responses

import com.example.themoviesapp.data.vos.ActorVO
import com.google.gson.annotations.SerializedName

class GetActorResponse(
    @SerializedName("results")
    val results: List<ActorVO>?
) {
}