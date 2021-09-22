package com.dcgabriel.myuark

import android.util.Log
import androidx.lifecycle.ViewModel
import com.dcgabriel.myuark.Networking.Clients
import com.dcgabriel.myuark.ui.model.NewsArticle
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsViewModel : ViewModel(){
    private var news = emptyList<NewsArticle>()


    fun getNews(): List<NewsArticle> {
        val api = Clients.newsApi().getRecentNews()
        var success = false
        api.enqueue( object : Callback<List<NewsArticle>> {

            override fun onResponse(call: Call<List<NewsArticle>>?, response: Response<List<NewsArticle>>?) {

                if(response?.body() != null) {

                    Log.d("-------------", "News Success=" + response.body()!!)
                    news = response.body()!!
                    success = true
                } else {
                    Log.d("-------------", "News failed=")
                }

            }

            override fun onFailure(call: Call<List<NewsArticle>>?, t: Throwable?) {
                success = false
            }
        })

        return news
    }

}