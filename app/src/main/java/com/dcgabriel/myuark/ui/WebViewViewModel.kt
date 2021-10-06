package com.dcgabriel.myuark.ui

import androidx.lifecycle.ViewModel
import com.dcgabriel.myuark.Networking.CallApi
import com.dcgabriel.myuark.model.events.RssFeed
import com.dcgabriel.myuark.model.tiles.DummyData
import com.dcgabriel.myuark.model.tiles.DummyData.getOtherTiles
import com.dcgabriel.myuark.model.tiles.TileItem
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

@HiltViewModel
class WebViewViewModel @Inject constructor(val api: CallApi) : ViewModel(){
    //wip: find better way
    init {
        api.callEvents()

    }

    fun liveEventsData(): Observable<RssFeed> = api.eventsResult()

    fun queryTile(id: Int) : TileItem? = DummyData.getTile(id)

}