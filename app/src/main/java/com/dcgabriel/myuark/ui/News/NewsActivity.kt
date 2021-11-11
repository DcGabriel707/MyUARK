package com.dcgabriel.myuark.ui.News

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.dcgabriel.myuark.ui.Adapters.NewsAdapter
import com.example.myuark.databinding.ActivityNewsBinding
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.disposables.CompositeDisposable

@AndroidEntryPoint
class NewsActivity : AppCompatActivity() {
    private val viewModel: NewsViewModel by viewModels()
    private lateinit var adapter: NewsAdapter
    private lateinit var binding: ActivityNewsBinding
    private val disposables = CompositeDisposable()
    private var isFabExtended = false;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding =  ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initSubscription()
        initRecyclerView()
    }

    private fun initSubscription() {
        disposables.add(viewModel.liveNewsData()
            .subscribe(){
                adapter.setData(it)
            })
    }

    private fun initRecyclerView() {
        val layoutManager = LinearLayoutManager(this)
        adapter = NewsAdapter(this)
        binding.newsRecyclerview.layoutManager = layoutManager
        binding.newsRecyclerview.adapter = adapter
    }

    fun clickOptions(view: View) {
        if (!isFabExtended) {
            binding.openBrowserFab.show()
            binding.openNewswire.show()
            binding.openBrowserFab.extend()
            binding.openNewswire.extend()
            binding.optionsFab.extend()
            isFabExtended = true
        } else {
            binding.openBrowserFab.shrink()
            binding.openNewswire.shrink()
            binding.openNewswire.hide()
            binding.openBrowserFab.hide()
            binding.optionsFab.shrink()
            isFabExtended = false
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.dispose()
    }

    private fun openWebIntent(url: String) {
        val webpage: Uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, webpage)
        if (intent.resolveActivity(packageManager!!) != null) {
            startActivity(intent)
        }
    }

    fun openBrowser(view: android.view.View) {openWebIntent("https://news.uark.edu/")}
    fun openNewswire(view: android.view.View) {openWebIntent("https://news.uark.edu/email")}


}