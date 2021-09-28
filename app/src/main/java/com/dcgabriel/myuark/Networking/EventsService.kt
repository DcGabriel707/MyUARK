package com.dcgabriel.myuark.Networking

import com.dcgabriel.myuark.model.events.RssFeed
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface EventsService {

    @GET("calendar.xml")
    fun getEvents(): Call<RssFeed>
}