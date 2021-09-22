package com.dcgabriel.myuark.Networking

import com.dcgabriel.myuark.ui.model.NewsArticle
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Clients {
    private lateinit var retrofit: Retrofit

    fun newsApi() : NewsService {

            retrofit = retrofit2.Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://campusdata.uark.edu/")
                .build()
        return retrofit.create(NewsService::class.java)
    }


}