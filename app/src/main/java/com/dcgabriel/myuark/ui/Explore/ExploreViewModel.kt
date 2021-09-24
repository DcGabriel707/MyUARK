package com.dcgabriel.myuark.ui.Explore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dcgabriel.myuark.ui.model.DummyData
import com.dcgabriel.myuark.ui.model.TileItem

class ExploreViewModel : ViewModel() {

    fun getTiles() : List<TileItem> = DummyData.getExploreTiles()

}