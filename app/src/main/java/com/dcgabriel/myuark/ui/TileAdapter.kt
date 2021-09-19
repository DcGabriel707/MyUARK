package com.dcgabriel.myuark.ui

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myuark.databinding.TileItemBinding
import com.dcgabriel.myuark.ui.model.TileItem
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.PublishSubject
import java.util.concurrent.TimeUnit

class TileAdapter(context: Context) : RecyclerView.Adapter<TileAdapter.ViewHolder>()   {
    private var items: MutableList<TileItem> = mutableListOf()
    private val clickEvents = PublishSubject.create<TileItem>()
    private val mContext = context

    fun clickEvents(): Observable<TileItem> {
        return clickEvents.debounce(300, TimeUnit.MILLISECONDS)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = TileItemBinding.inflate(inflater, parent, false)

        Log.d("--------------", items.size.toString())
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(items[position])
        Log.d("--------------", items.size.toString())
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].colSize
    }

    override fun getItemCount(): Int {
        Log.d("--------count------", items.size.toString())
        return items.size
    }

    fun setData(list: List<TileItem>){
        items = list.toMutableList()
        Log.d("-------setdata-------", items.size.toString())
        notifyDataSetChanged()
    }

    val getColSize: GridLayoutManager.SpanSizeLookup? by lazy {
        object:  GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return items[position].colSize
            }
        }
    }

    inner class ViewHolder(var binding: TileItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(item: TileItem){
            Log.d("--------------", item.title)
            binding.titleTextview.text = item.title
            binding.tileImage.setImageDrawable(
                ResourcesCompat.getDrawable(mContext.resources, item.image!!, null))
            binding.root.setOnClickListener{
                    view -> clickEvents.onNext(item)
            }
        }
    }

}
