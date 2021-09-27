package com.dcgabriel.myuark.Networking

import android.util.Log
import com.dcgabriel.myuark.model.NewsArticle
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.PublishSubject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


class CallApi @Inject constructor(val newsService: NewsService)   {
private val newsSubject: PublishSubject<List<NewsArticle>> = PublishSubject.create()

    fun newsResult(): Observable<List<NewsArticle>> = newsSubject

    fun callNews(){
        val news = newsService.getRecentNews()
        var success = false
        news.enqueue( object : Callback<List<NewsArticle>> {

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