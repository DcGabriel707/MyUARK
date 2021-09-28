package com.dcgabriel.myuark.ui.Events

import android.util.Log
import androidx.lifecycle.ViewModel
import com.dcgabriel.myuark.Networking.CallApi
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

    fun liveEventsData(): Observable<List<RssItem>> = api.eventsResult()


}