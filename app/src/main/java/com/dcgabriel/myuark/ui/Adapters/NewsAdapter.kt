package com.dcgabriel.myuark.ui.Adapters

import android.content.Context
import android.content.res.Resources
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView
import com.dcgabriel.myuark.model.news.NewsArticle
import com.example.myuark.R
import com.example.myuark.databinding.NewsItemBinding
import com.squareup.picasso.Picasso
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.PublishSubject
import java.util.concurrent.TimeUnit

class NewsAdapter(context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var items: MutableList<NewsArticle> = mutableListOf()
    private val clickEvents = PublishSubject.create<NewsArticle>()
    private val mContext = context

    fun clickEvents(): Observable<NewsArticle> {
        return clickEvents.debounce(300, TimeUnit.MILLISECONDS)
    }

    //wip
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = NewsItemBinding.inflate(inflater, parent, false)
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        (holder as NewsViewHolder).bindData(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setData(list: List<NewsArticle>) {
        items = list.toMutableList()
        notifyDataSetChanged()
    }

    inner class NewsViewHolder(var binding: NewsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(item: NewsArticle) {
            Log.d("---------9rfrf----", "News=" + item.headline)

            binding.headerTextview.text =
                HtmlCompat.fromHtml(item.headline, HtmlCompat.FROM_HTML_MODE_COMPACT)
            binding.briefTextview.text =
                HtmlCompat.fromHtml(item.brief, HtmlCompat.FROM_HTML_MODE_COMPACT)
            binding.descriptionTextview.text =
                HtmlCompat.fromHtml(item.content, HtmlCompat.FROM_HTML_MODE_COMPACT)

            Picasso.get()
                .load("https://campusdata.uark.edu/resources/images/articles/" + item.imageUrl)
                .into(binding.image)
            binding.root.setOnClickListener { view ->
                clickEvents.onNext(item)
                setVisibility(item)
            }
        }

        fun setVisibility(item: NewsArticle) {
            val desc = binding.descriptionTextview
            val image = binding.image
            if (desc.visibility == View.GONE) {
                desc.visibility = View.VISIBLE
                image.scaleType = ImageView.ScaleType.FIT_START
                image.layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT
            }
            else {
                desc.visibility = View.GONE
                image.layoutParams.height = mContext.resources
                    .getDimensionPixelSize(R.dimen.minimizedImageSize)
                image.scaleType = ImageView.ScaleType.CENTER_CROP
            }
        }

        fun setVisibility() {
        }
    }

}