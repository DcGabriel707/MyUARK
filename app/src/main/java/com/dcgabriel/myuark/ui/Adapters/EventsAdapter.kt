package com.dcgabriel.myuark.ui.Adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView
import com.dcgabriel.myuark.model.events.*
import com.dcgabriel.myuark.model.news.NewsArticle
import com.dcgabriel.myuark.model.tiles.TileItem
import com.example.myuark.R
import com.example.myuark.databinding.EventsItemBinding
import com.example.myuark.databinding.HeaderItemBinding
import com.example.myuark.databinding.NewsItemBinding
import com.squareup.picasso.Picasso
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.PublishSubject
import java.util.concurrent.TimeUnit

class EventsAdapter(context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var items: MutableList<EventItem> = mutableListOf()
    private val clickEvents = PublishSubject.create<RssItem>()
    private val mContext = context

    fun clickEvents(): Observable<RssItem> {
        return clickEvents.debounce(300, TimeUnit.MILLISECONDS)
    }

    //wip
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            Type.HEADER.ordinal -> HeaderViewHolder(
                HeaderItemBinding.inflate(
                    inflater,
                    parent,
                    false
                )
            )

            else -> EventsViewHolder(
                EventsItemBinding.inflate(
                    inflater,
                    parent,
                    false
                )
            )
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        when (item) {
            is DateHeader -> (holder as HeaderViewHolder).bindData(item as DateHeader)
            is RssItem -> (holder as EventsViewHolder).bindData(item as RssItem)
        }

    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is DateHeader -> Type.HEADER.ordinal
            is RssItem -> Type.ITEM.ordinal
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setData(eventItems: MutableList<EventItem>) {
        items = eventItems
        notifyDataSetChanged()
    }

    inner class EventsViewHolder(var binding: EventsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(item: RssItem) {
            Log.d("---------9rfrf----", "events=" + item.title)
            Picasso.get()
                .load(item.imageContent?.url.toString())
                .into(binding.bgImage)
            binding.headerTextview.text =
                HtmlCompat.fromHtml(
                    item.title.toString().substringAfter(':'),
                    HtmlCompat.FROM_HTML_MODE_LEGACY
                )
            binding.descriptionTextview.text =
                HtmlCompat.fromHtml(item.description.toString(), HtmlCompat.FROM_HTML_MODE_LEGACY)
            Picasso.get()
                .load(item.imageContent?.url.toString())
                .into(binding.image)
            binding.root.setOnClickListener { view ->
                clickEvents.onNext(item)
                setVisibility(item)
            }
        }

        fun setVisibility(item: RssItem) {
            val desc = binding.descriptionTextview
            val image = binding.image
            val card = binding.card
            if (desc.visibility == View.GONE) {
                desc.visibility = View.VISIBLE
                //image.visibility = View.VISIBLE
                //image.scaleType = ImageView.ScaleType.FIT_START
                card.layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT
            } else {
                desc.visibility = View.GONE
                image.visibility = View.GONE
                card.layoutParams.height = mContext.resources
                    .getDimensionPixelSize(R.dimen.minimized_event_card)
            }
        }
    }

    inner class HeaderViewHolder(var binding: HeaderItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(item: DateHeader) {
            binding.headerTextview.text = item.text
        }
    }


}