package com.dcgabriel.myuark.ui.Campus

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dcgabriel.myuark.ui.model.DummyData
import com.dcgabriel.myuark.ui.model.TileItem
import com.example.myuark.R

class CampusViewModel : ViewModel() {

    fun getTiles() : List<TileItem> = DummyData.getCampusTiles()
}