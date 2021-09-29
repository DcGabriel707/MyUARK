package com.dcgabriel.myuark.ui.Campus

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.dcgabriel.myuark.model.events.RssFeed
import com.dcgabriel.myuark.model.events.RssItem
import com.dcgabriel.myuark.model.news.NewsArticle
import com.dcgabriel.myuark.ui.BaseFragment
import com.example.myuark.databinding.FragmentCampusBinding
import com.dcgabriel.myuark.ui.Adapters.TileAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CampusFragment : BaseFragment() {

     lateinit var campusViewModel: CampusViewModel
    private lateinit var binding: FragmentCampusBinding
    private var news : List<NewsArticle> = mutableListOf()
    private var events : List<RssItem> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        campusViewModel = ViewModelProvider(this).get(CampusViewModel::class.java)
        binding = FragmentCampusBinding.inflate(inflater)

        handleGridLayout()
        initSubscriptions()
        return binding.root

    }

    override fun initSubscriptions(){
        super.initSubscriptions()
        disposables.add(campusViewModel.liveNewsData()
            .subscribe(){
                news = it
                updateWidget()
            })
        disposables.add(campusViewModel.liveEventsData()
            .subscribe(){
                events = it.channel?.items!!
                updateWidget()
            })
    }

    fun updateWidget(){
        adapter.setWidgetData(news, events)
    }

    private fun handleGridLayout(){
        val col = 6
        val gridlayoutManager = GridLayoutManager(context, col)
        adapter = TileAdapter(requireContext())
        binding.campusRecyclerview.layoutManager = gridlayoutManager
        binding.campusRecyclerview.adapter = adapter
        gridlayoutManager.spanSizeLookup = adapter.getColSize
        adapter.setData(campusViewModel.getTiles())
        adapter.setWidgetData(campusViewModel.dummyNewsArticle, campusViewModel.dummyEvent )
        val touchHelper = ItemTouchHelper(itemTouchHelperCallback)
        touchHelper.attachToRecyclerView(binding.campusRecyclerview)
    }
}