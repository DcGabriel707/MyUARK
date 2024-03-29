package com.dcgabriel.myuark.ui.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dcgabriel.myuark.model.FeedEntry.FeedEntry
import com.dcgabriel.myuark.model.tiles.TileItem
import com.example.myuark.databinding.InfoFeedItemBinding
import com.example.myuark.databinding.InfoSocialLinksItemBinding

class FeedsAdapter(context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var items: MutableList<FeedEntry> = mutableListOf()
    private val mContext = context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return FeedsViewHolder(
            InfoFeedItemBinding.inflate(
                inflater, parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setData(list: List<FeedEntry>) {
        items = list.toMutableList()
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        (holder as FeedsViewHolder).bindData(item)
    }

    inner class FeedsViewHolder(var binding: InfoFeedItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(item: FeedEntry) {
            binding.feedMessageTextview.text = item.bodyText
        }
    }
}