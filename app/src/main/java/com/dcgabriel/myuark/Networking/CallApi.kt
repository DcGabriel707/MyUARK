package com.dcgabriel.myuark.Networking

import android.util.Log
import com.dcgabriel.myuark.ui.model.NewsArticle
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.PublishSubject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CallApi {
    private val newsSubject: PublishSubject<List<NewsArticle>> = PublishSubject.create()

    fun newsResult(): Observable<List<NewsArticle>> = newsSubject

    fun callNews(){
        val api = Clients.newsApi().getRecentNews()
        var success = false
        api.enqueue( object : Callback<List<NewsArticle>> {

            override fun onResponse(call: Call<List<NewsArticle>>?, response: Response<List<NewsArticle>>?) {

                if(response?.body() != null) {

                    Log.d("-------------", "News Success=" + response.body()!!)
                    newsSubject.onNext(response.body()!!)
                    success = true
                } else {
                    Log.d("-------------", "News failed=")
                }

            }

            override fun onFailure(call: Call<List<NewsArticle>>?, t: Throwable?) {
                success = false
            }
        })

    }
}