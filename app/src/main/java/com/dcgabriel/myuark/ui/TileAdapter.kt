package com.dcgabriel.myuark.ui

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myuark.databinding.TileItemBinding
import com.dcgabriel.myuark.ui.model.TileItem
import com.dcgabriel.myuark.ui.model.TileItem.*
import com.dcgabriel.myuark.ui.model.TileItem.Type.*
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.PublishSubject
import java.util.concurrent.TimeUnit

class TileAdapter(context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>()   {
    private var items: MutableList<TileItem> = mutableListOf()
    private val clickEvents = PublishSubject.create<TileItem>()
    private val mContext = context

    fun clickEvents(): Observable<TileItem> {
        return clickEvents.debounce(300, TimeUnit.MILLISECONDS)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = TileItemBinding.inflate(inflater, parent, false)

        return when(viewType){
            ICON_TITLE.ordinal -> IconTitleViewHolder(binding)
            TEXT.ordinal -> TextViewHolder(binding)
            LOGO.ordinal -> LogoViewHolder(binding)
            else -> TextViewHolder(binding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        when (item.type){
            ICON_TITLE -> (holder as IconTitleViewHolder).bindData(item)
            TEXT -> (holder as TextViewHolder).bindData(item)
            LOGO -> (holder as LogoViewHolder).bindData(item)
            else -> (holder as TextViewHolder).bindData(item)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when(items[position].type){
            ICON_TITLE -> ICON_TITLE.ordinal
            LOGO -> LOGO.ordinal
            IMAGE -> IMAGE.ordinal
            IMAGE_TEXT -> IMAGE_TEXT.ordinal
            TEXT -> TEXT.ordinal
            else -> TEXT.ordinal
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setData(list: List<TileItem>){
        items = list.toMutableList()
        notifyDataSetChanged()
    }

    val getColSize: GridLayoutManager.SpanSizeLookup? by lazy {
        object:  GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return items[position].colSize
            }
        }
    }

    inner class IconTitleViewHolder(var binding: TileItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(item: TileItem){
            setVisibility()
            binding.titleTextview.text = item.title
            binding.tileImage.setImageDrawable(
                ResourcesCompat.getDrawable(mContext.resources, item.image!!, null))
            binding.root.setOnClickListener{
                    view -> clickEvents.onNext(item)
            }
        }

        fun setVisibility(){
            binding.titleTextview.visibility = View.VISIBLE
            binding.tileImage.visibility = View.VISIBLE
        }
    }

    inner class TextViewHolder(var binding: TileItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(item: TileItem){
            setVisibility()
            binding.headerTextview.text = item.title
            binding.root.setOnClickListener{
                    view -> clickEvents.onNext(item)
            }
        }

        fun setVisibility(){
            binding.headerTextview.visibility = View.VISIBLE
        }
    }

    inner class LogoViewHolder(var binding: TileItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(item: TileItem){
            setVisibility()
            binding.tileImage.setImageDrawable(
                ResourcesCompat.getDrawable(mContext.resources, item.image!!, null))

            binding.tileImage.layoutParams.width = LinearLayout.LayoutParams.MATCH_PARENT
            binding.root.setOnClickListener{
                    view -> clickEvents.onNext(item)
            }
        }

        fun setVisibility(){
            binding.tileImage.visibility = View.VISIBLE
        }
    }


}
