package com.dcgabriel.myuark.ui

import androidx.lifecycle.ViewModel
import com.dcgabriel.myuark.Networking.CallApi
import com.dcgabriel.myuark.model.FeedEntry.FeedEntry
import com.dcgabriel.myuark.model.URLInfo
import com.dcgabriel.myuark.model.events.RssFeed
import com.dcgabriel.myuark.model.tiles.DummyData
import com.dcgabriel.myuark.model.tiles.TileItem
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

@HiltViewModel
class WebViewViewModel @Inject constructor(val api: CallApi) : ViewModel() {
    var currentTileItem: TileItem? = null

    //wip: find better way
    init {
        api.callEvents()

    }

    fun liveEventsData(): Observable<RssFeed> = api.eventsResult()

    fun setCurrentTile(id: Int): TileItem? {
        currentTileItem = DummyData.getTile(id)
        return currentTileItem
    }

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
            ),
            FeedEntry(
                "www.twitter.com",
                "Twitter", "doeJane234",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
            )
        )
    }

    fun getSocialLinks() : ArrayList<URLInfo>? = currentTileItem?.tileData?.socialLinks
    fun getFeaturedLinks() : List<URLInfo>? {
        return currentTileItem?.tileData?.featuredLinks
    }

}