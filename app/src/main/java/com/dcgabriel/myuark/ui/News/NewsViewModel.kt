package com.dcgabriel.myuark.ui.News

import androidx.lifecycle.ViewModel
import com.dcgabriel.myuark.Networking.CallApi
import com.dcgabriel.myuark.model.NewsArticle
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(val api: CallApi) : ViewModel(){

    private  val TAG : String = "NewsViewModel"

    //wip: find better way
    init {
        api.callNews()
    }

    fun liveNewsData(): Observable<List<NewsArticle>> = api.newsResult()


}