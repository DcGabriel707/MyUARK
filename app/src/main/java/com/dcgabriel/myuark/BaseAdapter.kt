package com.dcgabriel.myuark

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dcgabriel.myuark.ui.model.TileItem
import com.example.myuark.databinding.TileItemBinding
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.PublishSubject
import java.util.concurrent.TimeUnit

class BaseAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    private var items: MutableList<TileItem> = mutableListOf()
    private val clickEvents = PublishSubject.create<TileItem>()

    fun clickEvents(): Observable<TileItem> {
        return clickEvents.debounce(300, TimeUnit.MILLISECONDS)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}