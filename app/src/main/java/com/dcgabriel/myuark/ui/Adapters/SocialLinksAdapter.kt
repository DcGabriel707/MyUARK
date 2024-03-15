package com.dcgabriel.myuark.ui.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dcgabriel.myuark.model.URLInfo
import com.example.myuark.R
import com.example.myuark.databinding.InfoSocialLinksItemBinding
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.PublishSubject
import java.util.concurrent.TimeUnit

class SocialLinksAdapter(context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var items: MutableList<URLInfo> = mutableListOf()
    private val mContext = context
    private val clickLink = PublishSubject.create<URLInfo>()

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

    fun setData(list: ArrayList<URLInfo>?) {
        if (list != null) {
            items = list.toMutableList()
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        (holder as SocialLinksViewHolder).bindData(item)
    }

    fun clickLink(): Observable<URLInfo> = clickLink.debounce(300, TimeUnit.MILLISECONDS)

    inner class SocialLinksViewHolder(var binding: InfoSocialLinksItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(item: URLInfo) {
            binding.cardView.setOnClickListener{ clickLink.onNext(item)}

            when {
                item.title.contains("facebook", ignoreCase = true) -> {
                    binding.socialLinkTextview.text = "Facebook"
                    binding.icon.setImageResource(R.drawable.facebook_f)
                }

                item.title.contains("twitter", ignoreCase = true) -> {
                    binding.socialLinkTextview.text  = "Twitter"
                    binding.icon.setImageResource(R.drawable.x_twitter)
                }

                item.title.contains("instagram", ignoreCase = true) -> {
                    binding.socialLinkTextview.text  = "Instagram"
                    binding.icon.setImageResource(R.drawable.instagram)
                }

                item.title.contains("youtube", ignoreCase = true) -> {
                    binding.socialLinkTextview.text  = "Youtube"
                    binding.icon.setImageResource(R.drawable.youtube)
                }

                item.title.contains("wordpress", ignoreCase = true) -> {
                    binding.socialLinkTextview.text  = item.title
                    binding.icon.setImageResource(R.drawable.wordpress_simple)
                }

                else -> {
                    binding.socialLinkTextview.text = "Open Link"
                    binding.icon.setImageResource(R.drawable.ic_baseline_open_in_browser_24)
                }
            }
        }

    }
}