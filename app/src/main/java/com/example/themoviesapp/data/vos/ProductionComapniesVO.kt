package com.example.themoviesapp.data.vos

import com.google.gson.annotations.SerializedName

data class ProductionComapniesVO(
    @SerializedName("id")
    val id:Int?,

    @SerializedName("logo_path")
    val logoPath:String?,

    @SerializedName("name")
    val name:String?,

    @SerializedName("origin_country")
    val origin_country:String?
)