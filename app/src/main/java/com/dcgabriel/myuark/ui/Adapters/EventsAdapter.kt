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
    private val clickOpen = PublishSubject.create<RssItem>()
    private val clickSave = PublishSubject.create<RssItem>()
    private val clickShare = PublishSubject.create<RssItem>()
    private val mContext = context



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
            else -> Type.ITEM.ordinal
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setData(eventItems: MutableList<EventItem>) {
        items = eventItems
        notifyDataSetChanged()
    }

    fun clickOpen(): Observable<RssItem> = clickOpen.debounce(300, TimeUnit.MILLISECONDS)
    fun clickShare(): Observable<RssItem> = clickShare.debounce(300, TimeUnit.MILLISECONDS)
    fun clickSave(): Observable<RssItem> = clickSave.debounce(300, TimeUnit.MILLISECONDS)


    inner class EventsViewHolder(var binding: EventsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(item: RssItem) {
            Log.d("---------9rfrf----", "events=" + item.title)
            binding.headerTextview.text =
                HtmlCompat.fromHtml(
                    item.title.toString().substringAfter(':'),
                    HtmlCompat.FROM_HTML_MODE_LEGACY
                )
            binding.descriptionTextview.text =
                HtmlCompat.fromHtml(item.description.toString().substringBefore("View on site"), HtmlCompat.FROM_HTML_MODE_LEGACY)
            Picasso.get()
                .load(item.imageContent?.url.toString())
                .into(binding.image)
            setOnClicks(item)

        }

        fun setOnClicks(item: RssItem){
            binding.root.setOnClickListener { view ->
                setVisibility()
            }
            binding.openEvent.setOnClickListener{clickOpen.onNext(item)}
            binding.saveEvent.setOnClickListener{clickSave.onNext(item)}
            binding.shareEvent.setOnClickListener{clickShare.onNext(item)}
        }

        fun setVisibility() {
            if (binding.descriptionTextview.visibility == View.GONE) {
                binding.descriptionTextview.visibility = View.VISIBLE
                binding.image.visibility = View.VISIBLE
                binding.openEvent.visibility = View.VISIBLE
                binding.shareEvent.visibility = View.VISIBLE
                binding.saveEvent.visibility = View.VISIBLE
                //image.scaleType = ImageView.ScaleType.FIT_START
                binding.card.layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT

            } else {
                binding.descriptionTextview.visibility = View.GONE
                binding.image.visibility = View.GONE
                binding.openEvent.visibility = View.GONE
                binding.shareEvent.visibility = View.GONE
                binding.saveEvent.visibility = View.GONE
                binding.card.layoutParams.height = mContext.resources
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