package com.dcgabriel.myuark.ui.News

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.dcgabriel.myuark.ui.Adapters.NewsAdapter
import com.dcgabriel.myuark.ui.BaseActivity
import com.example.myuark.databinding.ActivityNewsBinding
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.disposables.CompositeDisposable

@AndroidEntryPoint
class NewsActivity : BaseActivity() {
    private val viewModel: NewsViewModel by viewModels()
    private lateinit var adapter: NewsAdapter
    private lateinit var binding: ActivityNewsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initSubscription()
        initRecyclerView()
    }

    private fun initSubscription() {
        disposables.add(viewModel.liveNewsData()
            .subscribe() { adapter.setData(it) })
    }

    private fun initRecyclerView() {
        val layoutManager = LinearLayoutManager(this)
        adapter = NewsAdapter(this)
        binding.newsRecyclerview.layoutManager = layoutManager
        binding.newsRecyclerview.adapter = adapter
    }

    fun clickOptions(view: View) {
        showHideFAB(binding.optionsFab, arrayListOf(binding.openBrowserFab, binding.openNewswire,))
    }

    fun clickBrowser(view: android.view.View) = openBrowser("https://news.uark.edu/")
    fun clickNewswire(view: android.view.View) = openBrowser("https://news.uark.edu/email")

}