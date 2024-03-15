package com.dcgabriel.myuark.ui.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils.*
import android.widget.LinearLayout
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dcgabriel.myuark.model.events.RssItem
import com.dcgabriel.myuark.model.news.NewsArticle
import com.dcgabriel.myuark.model.tiles.TileItem
import com.dcgabriel.myuark.model.tiles.TileItem.Type.*
import com.dcgabriel.myuark.ui.Campus.CampusFragment
import com.example.myuark.databinding.TileIconTitleItemBinding
import com.example.myuark.databinding.TileLogoItemBinding
import com.example.myuark.databinding.TileStudentIdItemBinding
import com.example.myuark.databinding.TileTextItemBinding
import com.example.myuark.databinding.WidgetItemBinding
import com.google.android.material.animation.AnimationUtils
import com.squareup.picasso.Picasso
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.PublishSubject
import java.util.concurrent.TimeUnit
import kotlin.random.Random

class TileAdapter(context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var items: MutableList<TileItem> = mutableListOf()
    private var news: MutableList<NewsArticle> = mutableListOf()
    private var events: MutableList<RssItem> = mutableListOf()
    private val clickEvents = PublishSubject.create<TileItem>()
    private val mContext = context
    private var prevPos = -1

    fun clickEvents(): Observable<TileItem> {
        return clickEvents.debounce(300, TimeUnit.MILLISECONDS)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val tileTextBinding = TileTextItemBinding.inflate(inflater, parent, false)
        val widgetBinding = WidgetItemBinding.inflate(inflater, parent, false)
        val tileIconTitleItemBinding = TileIconTitleItemBinding.inflate(inflater, parent, false)
        val tileLogoItemBinding = TileLogoItemBinding.inflate(inflater, parent, false)
        val studentIdItemBinding = TileStudentIdItemBinding.inflate(inflater, parent, false)

        return when (viewType) {
            ICON_TITLE.ordinal -> IconTitleViewHolder(tileIconTitleItemBinding)
            TEXT.ordinal -> TextViewHolder(tileTextBinding)
            LOGO.ordinal -> LogoViewHolder(tileLogoItemBinding)
            WIDGET.ordinal -> WidgetViewHolder(widgetBinding)
            STUDENT_ID.ordinal -> StudentIdViewHolder(studentIdItemBinding)
            else -> LogoViewHolder(tileLogoItemBinding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        loadItemAnimate(holder.itemView, position)
        when (item.type) {
            ICON_TITLE -> (holder as IconTitleViewHolder).bindData(item)
            TEXT -> (holder as TextViewHolder).bindData(item)
            LOGO -> (holder as LogoViewHolder).bindData(item)
            WIDGET -> (holder as WidgetViewHolder).bindData(item)
            STUDENT_ID -> (holder as StudentIdViewHolder).bindData(item)
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
            STUDENT_ID -> STUDENT_ID.ordinal
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setData(list: List<TileItem>) {
        items = list.toMutableList()
        notifyDataSetChanged()
    }

    fun setWidgetData(newsList: List<NewsArticle>, eventsList: List<RssItem>) {
        news = newsList.toMutableList()
        events = eventsList.toMutableList()
        notifyDataSetChanged()
    }

    val getColSize: GridLayoutManager.SpanSizeLookup? by lazy {
        object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return items[position].colSize
            }
        }
    }

    fun loadItemAnimate(view: View, position: Int) {
        if (position > prevPos) {
            val anim = loadAnimation(mContext, android.R.anim.fade_in)
            view.startAnimation(anim)
            prevPos = position
        }
    }

    inner class IconTitleViewHolder(var binding: TileIconTitleItemBinding) :
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

    inner class TextViewHolder(var binding: TileTextItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(item: TileItem) {
            setVisibility()
            binding.tileText.text = item.title

        }

        fun setVisibility() {
//            binding.headerTextview.visibility = View.VISIBLE
        }
    }

    inner class LogoViewHolder(var binding: TileLogoItemBinding) :
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
        lateinit var currNews: NewsArticle
        lateinit var currEvent: RssItem
        lateinit var tileTitle: String
        fun bindData(item: TileItem) {
            tileTitle = item.title
            setVisibility()

            binding.titleTextview.text = item.title
            binding.root.setOnClickListener { view ->
                clickEvents.onNext(item)
            }


            binding.subtitleTextview.setInAnimation(mContext, android.R.anim.slide_in_left)
            updateWidget()
        }

        fun updateWidget() {
            Observable.interval(0, 7, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
                .take(1)
                .debounce(3, TimeUnit.SECONDS)
                .subscribe {

                    //todo: temporary. must fix
                    if (news.isNotEmpty())
                        currNews = news[Random.nextInt(news.size)]
                    if (events.isNotEmpty())
                        currEvent = events[Random.nextInt(events.size)]
                    if (news.isNotEmpty())
                        Picasso.get()
                            .load("https://campusdata.uark.edu/resources/images/articles/" + currNews.imageUrl)
                            .into(binding.bgImage)

                    if (events.isNotEmpty() && news.isNotEmpty())
                        when (tileTitle) {
                            "News" -> binding.subtitleTextview.setText(currNews.headline)
                            "Events" -> binding.subtitleTextview.setText(currEvent.title)
                        }
                }
        }

        fun setVisibility() {
        }
    }

    inner class StudentIdViewHolder(var binding: TileStudentIdItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
        fun bindData(item: TileItem) {
            binding.root.setOnClickListener { view ->
                clickEvents.onNext(item)
            }
        }
    }

}
