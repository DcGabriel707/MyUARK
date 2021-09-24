package com.dcgabriel.myuark.ui.Explore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.dcgabriel.myuark.ui.Adapters.TileAdapter
import com.dcgabriel.myuark.ui.BaseFragment
import com.example.myuark.databinding.FragmentExploreBinding

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
        //initSubscriptions()
        return binding.root

    }

    fun handleGridLayout(){

        val col = 6
        val gridlayoutManager = GridLayoutManager(context, col)
        adapter = TileAdapter(requireContext())
        binding.exploreRecyclerview.layoutManager = gridlayoutManager
        binding.exploreRecyclerview.adapter = adapter
        gridlayoutManager.spanSizeLookup = adapter.getColSize
        adapter.setData(exploreViewModel.getTiles())
    }
}