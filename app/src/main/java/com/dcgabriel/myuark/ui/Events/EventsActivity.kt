package com.dcgabriel.myuark.ui.Events

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.dcgabriel.myuark.ui.Adapters.EventsAdapter
import com.dcgabriel.myuark.ui.Adapters.NewsAdapter
import com.dcgabriel.myuark.ui.News.NewsViewModel
import com.example.myuark.R
import com.example.myuark.databinding.ActivityEventsBinding
import com.example.myuark.databinding.ActivityNewsBinding
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.disposables.CompositeDisposable

@AndroidEntryPoint
class EventsActivity : AppCompatActivity() {
    private val viewModel: EventsViewModel by viewModels()
    private lateinit var adapter: EventsAdapter
    private lateinit var binding: ActivityEventsBinding
    private val disposables = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding =  ActivityEventsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initSubscription()
        initRecyclerView()
    }

    private fun initSubscription() {
        disposables.add(viewModel.liveEventsData()
            .subscribe(){
                adapter.setData(it)
                Log.d("EventsActivity---------", "subbed")
                Toast.makeText(this, "size=" + (it.channel?.items?.size ?: "ewr"), Toast.LENGTH_SHORT).show()
            })
    }

    private fun initRecyclerView() {
        val layoutManager = LinearLayoutManager(this)
        adapter = EventsAdapter(this)
        binding.eventsRecyclerview.layoutManager = layoutManager
        binding.eventsRecyclerview.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.dispose()
    }

}