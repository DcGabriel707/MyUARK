package com.dcgabriel.myuark.ui.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dcgabriel.myuark.model.tiles.TileItem
import com.example.myuark.databinding.InfoFeaturedLinksItemBinding
import com.example.myuark.databinding.InfoFeedItemBinding
import com.example.myuark.databinding.InfoSocialLinksItemBinding

class FeaturedLinksAdapter (context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var items: MutableList<String> = mutableListOf()
    private val mContext = context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return FeaturedLinksViewHolder(
            InfoFeaturedLinksItemBinding.inflate(
                inflater, parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setData(list: List<String>) {
        items = list.toMutableList()
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        (holder as FeaturedLinksViewHolder).bindData(item)
    }

    inner class FeaturedLinksViewHolder(var binding: InfoFeaturedLinksItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(item: String) {
            binding.linkTextview.text = item
        }
    }
}