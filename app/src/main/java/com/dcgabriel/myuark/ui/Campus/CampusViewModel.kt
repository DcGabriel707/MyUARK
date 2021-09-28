package com.dcgabriel.myuark.ui.Campus

import androidx.lifecycle.ViewModel
import com.dcgabriel.myuark.Networking.CallApi
import com.dcgabriel.myuark.model.events.CalendarEvent
import com.dcgabriel.myuark.model.events.RssItem
import com.dcgabriel.myuark.model.tiles.DummyData
import com.dcgabriel.myuark.model.news.NewsArticle
import com.dcgabriel.myuark.model.tiles.TileItem
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

@HiltViewModel
class CampusViewModel @Inject constructor(val api: CallApi) : ViewModel() {
    //wip: find better way
    init {
        api.callNews()
        api.callEvents()
    }

    fun getTiles() : List<TileItem> = DummyData.getCampusTiles()

    fun liveNewsData(): Observable<List<NewsArticle>> = api.newsResult()
    fun liveEventsData(): Observable<List<RssItem>> = api.eventsResult()

    val dummyNewsArticle = mutableListOf<NewsArticle>(
        NewsArticle(0,"","","","","")
    )

}