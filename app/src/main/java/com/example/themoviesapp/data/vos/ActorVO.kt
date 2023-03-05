package com.example.themoviesapp.data.vos

import com.google.gson.annotations.SerializedName

class ActorVO(
    @SerializedName("adult")
    val adult:Boolean?,

    @SerializedName("gender")
    val gender:Int?,

    @SerializedName("id")
    val id:Int?,

    @SerializedName("known_for")
    val known_for:List<MovieVO>?,

    @SerializedName("Acting")
    val acting:String?,

    @SerializedName("name")
    val name:String?,

    @SerializedName("popularity")
    val popularity:Double?,

    @SerializedName("profile_path")
    val profilePath:String?,

    @SerializedName("known_for_department")
    val knownForApartment:String?,

    @SerializedName("original_name")
    val originalName:String?,

    @SerializedName("cast_id")
    val castId:Int?,

    @SerializedName("character")
    val character:String?,

    @SerializedName("credit_id")
    val creditId:String?,

    @SerializedName("order")
    val order:Int?







)