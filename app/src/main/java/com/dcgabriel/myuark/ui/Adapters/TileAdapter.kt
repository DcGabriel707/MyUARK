package com.dcgabriel.myuark.ui.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dcgabriel.myuark.model.news.NewsArticle
import com.dcgabriel.myuark.model.tiles.TileItem
import com.dcgabriel.myuark.model.tiles.TileItem.Type.*
import com.example.myuark.databinding.TileItemBinding
import com.example.myuark.databinding.WidgetItemBinding
import com.squareup.picasso.Picasso
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.PublishSubject
import java.util.concurrent.TimeUnit
import kotlin.random.Random

class TileAdapter(context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var items: MutableList<TileItem> = mutableListOf()
    private var news: MutableList<NewsArticle> = mutableListOf()
    private val clickEvents = PublishSubject.create<TileItem>()
    private val mContext = context

    fun clickEvents(): Observable<TileItem> {
        return clickEvents.debounce(300, TimeUnit.MILLISECONDS)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val tileBinding = TileItemBinding.inflate(inflater, parent, false)
        val widgetBinding = WidgetItemBinding.inflate(inflater, parent, false)

        return when (viewType) {
            ICON_TITLE.ordinal -> IconTitleViewHolder(tileBinding)
            TEXT.ordinal -> TextViewHolder(tileBinding)
            LOGO.ordinal -> LogoViewHolder(tileBinding)
            WIDGET.ordinal -> WidgetViewHolder(widgetBinding)
            else -> TextViewHolder(tileBinding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        when (item.type) {
            ICON_TITLE -> (holder as IconTitleViewHolder).bindData(item)
            TEXT -> (holder as TextViewHolder).bindData(item)
            LOGO -> (holder as LogoViewHolder).bindData(item)
            WIDGET -> (holder as WidgetViewHolder).bindData(item)
            else -> (holder as TextViewHolder).bindData(item)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position].type) {
            ICON_TITLE -> ICON_TITLE.ordinal
            LOGO -> LOGO.ordinal
            IMAGE -> IMAGE.ordinal
            IMAGE_TEXT -> IMAGE_TEXT.ordinal
            TEXT -> TEXT.ordinal
            WIDGET -> WIDGET.ordinal
            else -> TEXT.ordinal
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setData(list: List<TileItem>) {
        items = list.toMutableList()
        notifyDataSetChanged()
    }

    fun setWidgetData(newsList: List<NewsArticle>) {
        news = newsList.toMutableList()
        notifyDataSetChanged()
    }

    val getColSize: GridLayoutManager.SpanSizeLookup? by lazy {
        object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return items[position].colSize
            }
        }
    }

    inner class IconTitleViewHolder(var binding: TileItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(item: TileItem) {
            setVisibility()
            binding.titleTextview.text = item.title
            binding.tileImage.setImageDrawable(
                ResourcesCompat.getDrawable(mContext.resources, item.image!!, null)
            )
            binding.root.setOnClickListener { view ->
                clickEvents.onNext(item)
            }
        }

        fun setVisibility() {
            binding.titleTextview.visibility = View.VISIBLE
            binding.tileImage.visibility = View.VISIBLE
        }
    }

    inner class TextViewHolder(var binding: TileItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(item: TileItem) {
            setVisibility()
            binding.headerTextview.text = item.title
            binding.root.setOnClickListener { view ->
                clickEvents.onNext(item)
            }
        }

        fun setVisibility() {
            binding.headerTextview.visibility = View.VISIBLE
        }
    }

    inner class LogoViewHolder(var binding: TileItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(item: TileItem) {
            setVisibility()
            binding.tileImage.setImageDrawable(
                ResourcesCompat.getDrawable(mContext.resources, item.image!!, null)
            )

            binding.tileImage.layoutParams.width = LinearLayout.LayoutParams.MATCH_PARENT
            binding.root.setOnClickListener { view ->
                clickEvents.onNext(item)
            }
        }

        fun setVisibility() {
            binding.tileImage.visibility = View.VISIBLE
        }
    }

    inner class WidgetViewHolder(var binding: WidgetItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        lateinit var currNews : NewsArticle
        fun bindData(item: TileItem) {
            currNews = news[Random.nextInt(news.size)]
            setVisibility()
            binding.titleTextview.text = item.title
            //binding.subtitleTextview.setText(newsArticle.headline)
            binding.root.setOnClickListener { view ->
                clickEvents.onNext(item)
            }

            Picasso.get()
                .load("https://campusdata.uark.edu/resources/images/articles/" + currNews.imageUrl)
                .into(binding.bgImage)

            binding.subtitleTextview.setInAnimation(mContext, android.R.anim.slide_in_left)
            updateWidget()
        }

        fun updateWidget() {
            Observable.interval(0, 7, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
                .take(10)
                .buffer(1)
                .subscribe {
                    binding.subtitleTextview.setText(currNews.headline)
                }

        }

        fun setVisibility() {
        }
    }

}
