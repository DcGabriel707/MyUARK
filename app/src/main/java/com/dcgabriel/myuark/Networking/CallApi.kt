package com.dcgabriel.myuark.Networking

import android.util.Log
import com.dcgabriel.myuark.model.events.CalendarEvent
import com.dcgabriel.myuark.model.events.RssFeed
import com.dcgabriel.myuark.model.events.RssItem
import com.dcgabriel.myuark.model.news.NewsArticle
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.PublishSubject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


class CallApi @Inject constructor(val newsService: NewsService, val eventsService: EventsService)   {
private val newsSubject: PublishSubject<List<NewsArticle>> = PublishSubject.create()
private val eventsSubject: PublishSubject<List<RssItem>> = PublishSubject.create()

    fun newsResult(): Observable<List<NewsArticle>> = newsSubject
    fun eventsResult(): Observable<List<RssItem>> = eventsSubject

    fun callNews(){
        val news = newsService.getRecentNews()
        news.enqueue( object : Callback<List<NewsArticle>> {
            override fun onResponse(call: Call<List<NewsArticle>>?, response: Response<List<NewsArticle>>?) {
                if(response?.body() != null) {
                    newsSubject.onNext(response.body()!!)
                } else {

                }
            }

            override fun onFailure(call: Call<List<NewsArticle>>?, t: Throwable?) {

            }
        })
    }

    fun callEvents(){
        val events = eventsService.getEvents()
        events.enqueue( object : Callback<RssFeed> {
            override fun onResponse(call: Call<RssFeed>?, response: Response<RssFeed>?) {
                if(response?.isSuccessful()!!) {
                    Log.d("-------------", "events=" + response.body()!!)
                    //eventsSubject.onNext(response.body()!!)
                } else {
                    Log.d("-------------error",response.errorBody().toString() )
                }
            }

            override fun onFailure(call: Call<RssFeed>, t: Throwable) {
                Log.d("-------------", "events failed" + t.message)

            }

        })
    }
}