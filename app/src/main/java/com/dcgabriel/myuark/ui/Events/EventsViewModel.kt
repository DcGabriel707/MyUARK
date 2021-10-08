package com.dcgabriel.myuark.ui.Events

import androidx.lifecycle.ViewModel
import com.dcgabriel.myuark.Networking.CallApi
import com.dcgabriel.myuark.model.events.DateHeader
import com.dcgabriel.myuark.model.events.EventItem
import com.dcgabriel.myuark.model.events.RssFeed
import com.dcgabriel.myuark.model.events.RssItem
import com.dcgabriel.myuark.model.news.NewsArticle
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

@HiltViewModel
class EventsViewModel @Inject constructor(val api: CallApi) : ViewModel(){
    //wip: find better way
    init {
        api.callEvents()

    }

    fun liveEventsData(): Observable<RssFeed> = api.eventsResult()
    fun mapDates(events: List<RssItem>?) : MutableList<EventItem>{
        val items = mutableListOf<EventItem>()
        var prevHeaderText = ""
        for(event in events!!){
            val headerText = event.title?.substringBefore(':').toString()
            if (headerText != prevHeaderText) {
                items.add(DateHeader(headerText))
                prevHeaderText = headerText
            }
            items.add(event)
        }
        return items
    }


}