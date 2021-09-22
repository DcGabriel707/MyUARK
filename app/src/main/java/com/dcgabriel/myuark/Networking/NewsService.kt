package com.dcgabriel.myuark.Networking

import com.dcgabriel.myuark.ui.model.NewsArticle
import retrofit2.Call;
import retrofit2.http.GET;

interface NewsService {

    @GET("apiv2/articles/SearchArticle?\$orderby=publishDate+desc&\$top=30")
    fun getRecentNews() : Call<List<NewsArticle>>


    @GET("apiv2/articles/{image}")
    fun getNewsImage(image: String) : Call<List<NewsArticle>>
}