package com.dcgabriel.myuark.model.events

import com.google.gson.annotations.SerializedName

data class CalendarEvent (
    @SerializedName("id") var id : Int,
    @SerializedName("title") var brief : String,
    @SerializedName("description") var headline : String,
    @SerializedName("url") var content : String,
    @SerializedName("image") var imageUrl : String,
)