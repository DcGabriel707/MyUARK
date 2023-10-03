package com.dcgabriel.myuark.ui

import androidx.lifecycle.ViewModel
import com.dcgabriel.myuark.Networking.CallApi
import com.dcgabriel.myuark.model.FeedEntry.FeedEntry
import com.dcgabriel.myuark.model.events.RssFeed
import com.dcgabriel.myuark.model.tiles.DummyData
import com.dcgabriel.myuark.model.tiles.DummyData.getOtherTiles
import com.dcgabriel.myuark.model.tiles.TileItem
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

@HiltViewModel
class WebViewViewModel @Inject constructor(val api: CallApi) : ViewModel() {
    //wip: find better way
    init {
        api.callEvents()

    }

    fun liveEventsData(): Observable<RssFeed> = api.eventsResult()

    fun queryTile(id: Int): TileItem? = DummyData.getTile(id)

    fun getFeeds(): List<FeedEntry> {
        return listOf(
            FeedEntry(
                "www.facebook.com",
                "Facebook", "johndoe321",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
            ),
            FeedEntry(
                "www.instagram.com",
                "Instagram", "doeJane234",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
            )
        )
    }

    fun getFeaturedLinks() : List<String> {
        return listOf(
            "www.facebook.com", "www.instagram.com", "www.reddit.com", "www.google.com")
    }

}