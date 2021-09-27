package com.dcgabriel.myuark.ui.Explore

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.dcgabriel.myuark.model.TileItem
import com.dcgabriel.myuark.ui.Adapters.TileAdapter
import com.dcgabriel.myuark.ui.BaseFragment
import com.example.myuark.databinding.FragmentExploreBinding
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

@AndroidEntryPoint
class ExploreFragment  : BaseFragment(){

    private lateinit var exploreViewModel: ExploreViewModel
    private lateinit var binding: FragmentExploreBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        exploreViewModel = ViewModelProvider(this).get(ExploreViewModel::class.java)
        binding = FragmentExploreBinding.inflate(inflater)

        handleGridLayout()
        initSubscriptions()
        return binding.root

    }
    
    override fun initSubscriptions(){
        super.initSubscriptions()
        disposables.add(exploreViewModel.liveNewsData()
            .subscribe(){
                adapter.setWidgetData(it)
            })

    }


    private fun handleGridLayout(){

        val col = 6
        val gridlayoutManager = GridLayoutManager(context, col)
        adapter = TileAdapter(requireContext())
        binding.exploreRecyclerview.layoutManager = gridlayoutManager
        binding.exploreRecyclerview.adapter = adapter
        gridlayoutManager.spanSizeLookup = adapter.getColSize
        adapter.setData(exploreViewModel.getTiles())
        adapter.setWidgetData(exploreViewModel.dummyNewsArticle)
    }
}