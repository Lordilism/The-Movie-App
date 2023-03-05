package com.example.themoviesapp.data.vos

import com.google.gson.annotations.SerializedName

class GenreVO(
    @SerializedName("id")
    val id:Int?,

    @SerializedName("name")
    val name:String?
)