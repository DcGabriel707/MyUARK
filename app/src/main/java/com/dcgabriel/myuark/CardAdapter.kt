package com.dcgabriel.myuark

import android.content.Context
import android.text.Html
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView
import com.dcgabriel.myuark.ui.TileAdapter
import com.dcgabriel.myuark.ui.model.NewsArticle
import com.dcgabriel.myuark.ui.model.TileItem
import com.example.myuark.databinding.NewsItemBinding
import com.example.myuark.databinding.TileItemBinding
import com.squareup.picasso.Picasso
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.PublishSubject
import java.util.concurrent.TimeUnit

class CardAdapter(context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    private var items: MutableList<NewsArticle> = mutableListOf()
    private val mContext = context


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = NewsItemBinding.inflate(inflater, parent, false)

        return NewsViewHolder(binding)
//        return when(viewType){
//        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]

        (holder as NewsViewHolder).bindData(item)
//        when (item.type){
//        }
    }


    override fun getItemCount(): Int {
        return items.size
    }

    fun setData(list: List<NewsArticle>){
        items = list.toMutableList()
        notifyDataSetChanged()
    }

    inner class NewsViewHolder(var binding: NewsItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(item: NewsArticle){
            Log.d("---------9rfrf----", "News=" + item.headline)
            setVisibility()
            binding.headerTextview.text = HtmlCompat.fromHtml(item.headline,HtmlCompat.FROM_HTML_MODE_COMPACT)
            binding.briefTextview.text = HtmlCompat.fromHtml(item.brief,HtmlCompat.FROM_HTML_MODE_COMPACT)
            Picasso.get()
                .load("https://campusdata.uark.edu/resources/images/articles/" + item.imageUrl)
                .into(binding.image)

        }


        fun setVisibility(){
        }
    }
}