package com.dcgabriel.myuark.ui.Main

import androidx.lifecycle.ViewModel
import com.dcgabriel.myuark.model.tiles.DummyData
import com.dcgabriel.myuark.model.tiles.TileItem

class MainViewModel : ViewModel() {

    fun getAllTiles() = DummyData.getStudentTiles() + DummyData.getCampusTiles() + DummyData.getExploreTiles()
    fun getOtherTiles() = DummyData.getOtherTiles()

    fun queryTile(string: String) : List<TileItem>{
        val allTiles = getAllTiles()
        val results = mutableListOf<TileItem>()

        for (item in allTiles){
             if(item.title.contains(string,true) && string.isNotEmpty())
                results.add(item)
        }

        if (results.isEmpty())
            for (item in getOtherTiles())
                results.add(item)
        return results
    }


}