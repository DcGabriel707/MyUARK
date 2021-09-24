package com.dcgabriel.myuark.ui.Main

import androidx.lifecycle.ViewModel
import com.dcgabriel.myuark.ui.model.DummyData
import com.dcgabriel.myuark.ui.model.TileItem

class MainViewModel : ViewModel() {

    fun getAllTiles() = DummyData.getStudentTiles() + DummyData.getCampusTiles()

    fun queryTile(string: String) : List<TileItem>{
        val allTiles = getAllTiles()

        val results = mutableListOf<TileItem>()
        for (item in allTiles){

            if(item.title.contains(string,true) && string.isNotEmpty())
                results.add(item)
        }
        return results
    }


}