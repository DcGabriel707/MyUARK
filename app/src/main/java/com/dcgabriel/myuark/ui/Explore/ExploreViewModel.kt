package com.dcgabriel.myuark.ui.Explore

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.dcgabriel.myuark.Networking.CallApi
import com.dcgabriel.myuark.model.DummyData
import com.dcgabriel.myuark.model.NewsArticle
import com.dcgabriel.myuark.model.TileItem
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject


@HiltViewModel
class ExploreViewModel @Inject constructor(val api: CallApi) : ViewModel() {
    //wip: find better way
    init {
        api.callNews()
    }


    fun getTiles() : List<TileItem> = DummyData.getExploreTiles()
    fun liveNewsData(): Observable<List<NewsArticle>> = api.newsResult()
    val dummyNewsArticle = mutableListOf<NewsArticle>(
        NewsArticle(0,"","","","",""))

}