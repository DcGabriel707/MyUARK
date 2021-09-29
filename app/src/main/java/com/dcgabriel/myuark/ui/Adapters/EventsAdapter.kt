package com.dcgabriel.myuark.ui.Adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView
import com.dcgabriel.myuark.model.events.RssFeed
import com.dcgabriel.myuark.model.events.RssItem
import com.dcgabriel.myuark.model.news.NewsArticle
import com.example.myuark.databinding.EventsItemBinding
import com.example.myuark.databinding.NewsItemBinding
import com.squareup.picasso.Picasso
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.PublishSubject
import java.util.concurrent.TimeUnit

class EventsAdapter(context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var items: MutableList<RssItem> = mutableListOf()
    private val clickEvents = PublishSubject.create<RssItem>()
    private val mContext = context

    fun clickEvents(): Observable<RssItem> {
        return clickEvents.debounce(300, TimeUnit.MILLISECONDS)
    }

    //wip
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = EventsItemBinding.inflate(inflater, parent, false)
        return EventsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        (holder as EventsViewHolder).bindData(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setData(feed: RssFeed) {
        items = feed.channel!!.items!!.toMutableList()
        notifyDataSetChanged()
    }

    inner class EventsViewHolder(var binding: EventsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(item: RssItem) {
            Log.d("---------9rfrf----", "events=" + item.title)

            binding.headerTextview.text =
                HtmlCompat.fromHtml(item.title.toString(), HtmlCompat.FROM_HTML_MODE_COMPACT)
            binding.descriptionTextview.text =
                HtmlCompat.fromHtml(item.description.toString(), HtmlCompat.FROM_HTML_MODE_COMPACT)

            binding.root.setOnClickListener { view ->
                clickEvents.onNext(item)
                setVisibility(item)
            }
        }

        fun setVisibility(item: RssItem) {
            val desc = binding.descriptionTextview
            if (desc.visibility == View.GONE)
                desc.visibility = View.VISIBLE
            else
                desc.visibility = View.GONE
        }
    }

}