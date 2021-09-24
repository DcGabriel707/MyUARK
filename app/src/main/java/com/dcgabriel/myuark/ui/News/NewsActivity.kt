package com.dcgabriel.myuark.ui.News

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.dcgabriel.myuark.ui.Adapters.CardAdapter
import com.example.myuark.databinding.ActivityNewsBinding
import io.reactivex.rxjava3.disposables.CompositeDisposable

class NewsActivity : AppCompatActivity() {
    private val viewModel: NewsViewModel by viewModels()
    private lateinit var adapter: CardAdapter
    private lateinit var binding: ActivityNewsBinding
    private val disposables = CompositeDisposable()

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
        adapter = CardAdapter(this)
        binding.newsRecyclerview.layoutManager = layoutManager
        binding.newsRecyclerview.adapter = adapter
    }

}