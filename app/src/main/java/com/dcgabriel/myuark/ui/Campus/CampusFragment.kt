package com.dcgabriel.myuark.ui.Campus

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myuark.R
import com.example.myuark.databinding.FragmentCampusBinding
import com.dcgabriel.myuark.ui.TileAdapter
import com.dcgabriel.myuark.ui.model.TileItem

class CampusFragment : Fragment() {

    private lateinit var campusViewModel: CampusViewModel
    private lateinit var binding: FragmentCampusBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        campusViewModel = ViewModelProvider(this).get(CampusViewModel::class.java)
        binding = FragmentCampusBinding.inflate(inflater)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleGridLayout()
    }
    fun handleGridLayout(){

        val col = 3
        val gridlayoutManager = GridLayoutManager(context, col)
        val adapter = TileAdapter(requireContext())
        adapter.setData(dummyData())
        binding.campusRecyclerview.layoutManager = gridlayoutManager
        binding.campusRecyclerview.adapter = adapter
        gridlayoutManager.spanSizeLookup = adapter.getColSize


        adapter.setData(dummyData())
    }

    fun dummyData(): List<TileItem>{
        var list = ArrayList<TileItem>()
        list.add(
            TileItem("Bus",2,
            ResourcesCompat.getDrawable(resources, R.drawable.ic_baseline_directions_bus_24, null))
        )
        list.add(
            TileItem("Parking", 1,
            ResourcesCompat.getDrawable(resources, R.drawable.ic_baseline_local_parking_24, null))
        )
        list.add(
            TileItem("Housing", 1,
            ResourcesCompat.getDrawable(resources, R.drawable.ic_baseline_home_work_24, null))
        )
        list.add(
            TileItem("Dining", 2,
            ResourcesCompat.getDrawable(resources, R.drawable.ic_baseline_fastfood_24, null))
        )
        list.add(
            TileItem("Map",2,
            ResourcesCompat.getDrawable(resources, R.drawable.ic_baseline_place_24, null))
        )
        list.add(
            TileItem("Events",1,
            ResourcesCompat.getDrawable(resources, R.drawable.ic_baseline_event_24, null))
        )
        list.add(
            TileItem("UREC", 1,
            ResourcesCompat.getDrawable(resources, R.mipmap.ic_channel, null))
        )
        list.add(
            TileItem("UATV", 1,
            ResourcesCompat.getDrawable(resources, R.mipmap.ic_uatv, null))
        )
        list.add(
            TileItem("ASG", 1,
            ResourcesCompat.getDrawable(resources, R.mipmap.ic_asg, null))
        )

        return list
    }


}