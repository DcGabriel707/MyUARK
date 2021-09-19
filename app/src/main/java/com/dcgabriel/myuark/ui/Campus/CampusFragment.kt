package com.dcgabriel.myuark.ui.Campus

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.dcgabriel.myuark.ui.BaseFragment
import com.example.myuark.R
import com.example.myuark.databinding.FragmentCampusBinding
import com.dcgabriel.myuark.ui.TileAdapter
import com.dcgabriel.myuark.ui.TransitActivity
import com.dcgabriel.myuark.ui.model.TileItem
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers.io

class CampusFragment : BaseFragment() {

    private lateinit var campusViewModel: CampusViewModel
    private lateinit var binding: FragmentCampusBinding
    private lateinit var adapter: TileAdapter

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

    private fun initSubscriptions() {
        disposables.add(adapter.clickEvents()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                onClick(it)
            })
    }

    private fun onClick(item:TileItem) {
        Toast.makeText(context, "***" + item.title, Toast.LENGTH_SHORT).show()
        if (item.type == TileItem.Type.WEB_LINK){
            performWebIntent(item.url)
        } else if (item.type == TileItem.Type.WEB_VIEW){
            openWebView(item.url)
        }
    }

    private fun performWebIntent(url: String?){
        val webpage: Uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, webpage)
        if (intent.resolveActivity(activity?.packageManager!!) != null) {
            startActivity(intent)
        }

    }

    private fun openWebView(url: String?) {
        val intent = Intent(activity, TransitActivity::class.java)
        startActivity(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.dispose()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
    fun handleGridLayout(){

        val col = 3
        val gridlayoutManager = GridLayoutManager(context, col)
        adapter = TileAdapter(requireContext())
        adapter.setData(dummyData())
        binding.campusRecyclerview.layoutManager = gridlayoutManager
        binding.campusRecyclerview.adapter = adapter
        gridlayoutManager.spanSizeLookup = adapter.getColSize

        adapter.setData(dummyData())
    }

    fun dummyData(): List<TileItem>{
        var list = ArrayList<TileItem>()
        list.add(
            TileItem("Bus",
                2,
                R.drawable.ic_baseline_directions_bus_24,
                TileItem.Type.WEB_VIEW,
                null
            )
        )
        list.add(TileItem(
            "Parking", 1, R.drawable.ic_baseline_local_parking_24, TileItem.Type.WEB_LINK,
            "https://parking.uark.edu/"
            )
        )
        list.add(TileItem(
            "Housing", 1, R.drawable.ic_baseline_home_work_24, TileItem.Type.WEB_LINK,
            "https://housing.uark.edu/"
            )
        )
        list.add(TileItem(
            "Dining", 2, R.drawable.ic_baseline_fastfood_24, TileItem.Type.WEB_LINK,
        "https://dineoncampus.com/razorbacks/"
            )
        )
        list.add(TileItem(
            "Map",2,R.drawable.ic_baseline_place_24, TileItem.Type.WEB_VIEW,""
            )
        )
        list.add(TileItem(
            "Events",1, R.drawable.ic_baseline_event_24, TileItem.Type.APP_VIEW,
        ""
            )
        )
        list.add(TileItem(
            "UREC", 1,R.mipmap.ic_channel, TileItem.Type.WEB_LINK,
            "https://urec.uark.edu/"
            )
        )
        list.add(
            TileItem(
                "UATV", 1, R.mipmap.ic_uatv, TileItem.Type.WEB_LINK,
                "https://uatvonline.net/"
                )
        )
        list.add(TileItem(
            "ASG", 1, R.mipmap.ic_asg, TileItem.Type.WEB_LINK,
                "https://asg.uark.edu/"
            )
        )

        return list
    }


}