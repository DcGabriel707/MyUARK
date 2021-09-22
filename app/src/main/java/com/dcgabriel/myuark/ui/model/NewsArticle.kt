package com.dcgabriel.myuark.ui.model

import com.google.gson.annotations.SerializedName

data class NewsArticle (

    //todo add rest of necessary data
        @SerializedName("id") var id : Int,
        @SerializedName("brief") var brief : String,
        @SerializedName("headline") var headline : String,
        @SerializedName("content") var content : String,
        @SerializedName("image") var imageUrl : String,
        @SerializedName("publishDate") var publishDate : String,

)