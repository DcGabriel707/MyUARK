package com.dcgabriel.myuark.ui.News

import android.util.Log
import androidx.lifecycle.ViewModel
import com.dcgabriel.myuark.Networking.CallApi
import com.dcgabriel.myuark.Networking.Clients
import com.dcgabriel.myuark.ui.model.NewsArticle
import io.reactivex.rxjava3.core.Observable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsViewModel : ViewModel(){
    private lateinit var api: CallApi
    private  val TAG : String = "NewsViewModel"

    //wip: initialize api somewhere else. use Dependency Injection
    init {
        api = CallApi()
        api.callNews()
    }

    fun liveNewsData(): Observable<List<NewsArticle>> = api.newsResult()


}