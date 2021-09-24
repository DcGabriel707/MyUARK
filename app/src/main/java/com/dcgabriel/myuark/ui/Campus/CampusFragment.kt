package com.dcgabriel.myuark.ui.Campus

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.dcgabriel.myuark.ui.BaseFragment
import com.example.myuark.databinding.FragmentCampusBinding
import com.dcgabriel.myuark.ui.Adapters.TileAdapter

class CampusFragment : BaseFragment() {

    private lateinit var campusViewModel: CampusViewModel
    private lateinit var binding: FragmentCampusBinding

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

    fun handleGridLayout(){

        val col = 3
        val gridlayoutManager = GridLayoutManager(context, col)
        adapter = TileAdapter(requireContext())
        binding.campusRecyclerview.layoutManager = gridlayoutManager
        binding.campusRecyclerview.adapter = adapter
        gridlayoutManager.spanSizeLookup = adapter.getColSize
        adapter.setData(campusViewModel.getTiles())
    }




}