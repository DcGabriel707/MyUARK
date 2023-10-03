package com.dcgabriel.myuark.ui.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.dcgabriel.myuark.model.FeedEntry.FeedEntry
import com.dcgabriel.myuark.model.tiles.TileItem
import com.example.myuark.R
import com.example.myuark.databinding.InfoSocialLinksItemBinding
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton

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

    fun setData(list: List<String>) {
        items = list.toMutableList()
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        (holder as SocialLinksViewHolder).bindData(item)
    }



    inner class SocialLinksViewHolder(var binding: InfoSocialLinksItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(url: String) {
            when {
                url.contains("facebook", ignoreCase = true) -> {
                    binding.socialLinkTextview.text = "Facebook"
                    binding.icon.setImageResource(R.drawable.facebook_f)
                }

                url.contains("twitter", ignoreCase = true) -> {
                    binding.socialLinkTextview.text  = "Twitter"
                    binding.icon.setImageResource(R.drawable.x_twitter)
                }

                url.contains("instagram", ignoreCase = true) -> {
                    binding.socialLinkTextview.text  = "Instagram"
                    binding.icon.setImageResource(R.drawable.instagram)
                }

                url.contains("youtube", ignoreCase = true) -> {
                    binding.socialLinkTextview.text  = "Youtube"
                    binding.icon.setImageResource(R.drawable.youtube)
                }

                else -> {
                    binding.socialLinkTextview.text = "Open Link"
                }
            }
        }

    }
}