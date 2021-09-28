package com.dcgabriel.myuark.ui.Student

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dcgabriel.myuark.model.tiles.DummyData
import com.dcgabriel.myuark.model.tiles.TileItem

class StudentViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text

    fun getTiles() : List<TileItem> = DummyData.getStudentTiles()

}