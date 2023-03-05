package com.example.themoviesapp.data.vos

import com.google.gson.annotations.SerializedName

data class MovieVO(
    @SerializedName("adult")
    val adult:Boolean?,

    @SerializedName("backdrop_path")
    val backdropPath:String?,

    @SerializedName("genre_ids")
    val genreIds:List<Int?>,

    @SerializedName("id")
    val id:Int?,

    @SerializedName("original_language")
    val originalLanguage:String?,

    @SerializedName("original_title")
    val originalTitle:String?,

    @SerializedName("overview")
    val overview:String?,

    @SerializedName("popularity")
    val popularity:Double?,

    @SerializedName("poster_path")
    val posterPath:String?,

    @SerializedName("release_date")
    val releaseDate:String?,

    @SerializedName("title")
    val title:String?,

    @SerializedName("video")
    val video:Boolean?,

    @SerializedName("vote_average")
    val voteAverage:Double?,

    @SerializedName("vote_count")
    val voteCount:Int?,

    @SerializedName("production_companies")
    val productionCompanies:List<ProductionComapniesVO>?,

    @SerializedName("budget")
    val budget:Long?,

    @SerializedName("runtime")
    val runTime:Int,

    @SerializedName("spoken_languages")
    val spokenLanguage:List<SpokenLanguageVO>?,

    @SerializedName("status")
    val status:String?,

    @SerializedName("tagline")
    val tagLine:String?,

    @SerializedName("production_countries")
    val produtionCountries: List<ProductionCountriesVO>?,



    @SerializedName("genres")
    val genres:List<GenreVO>?

){
    fun getRatingBasedOnFiveStars():Float{
        return voteAverage?.div(2)?.toFloat() ?:0.0f
    }

    fun getGenresAsCommaSeparatedString():String{
        return genres?.map {it.name }?.joinToString(",")?:""
    }

    fun getProductionCountriesAsCommaSeparatedString():String{
        return produtionCountries?.map { it.name}?.joinToString(",")?:""
    }
}