package com.dcgabriel.myuark.ui.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myuark.databinding.InfoSocialLinksItemBinding

class SocialLinksAdapter(context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var items: MutableList<String> = mutableListOf()
    private val mContext = context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return SocialLinksViewHolder(
            InfoSocialLinksItemBinding.inflate(
                inflater, parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        (holder as SocialLinksViewHolder).bindData(item)
    }

    inner class SocialLinksViewHolder(var binding: InfoSocialLinksItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(item: String) {
            binding.socialLinkTextview.text = item
        }
    }
}