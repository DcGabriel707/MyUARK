package com.dcgabriel.myuark.ui.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dcgabriel.myuark.model.URLInfo
import com.example.myuark.databinding.InfoFeaturedLinksItemBottomBinding
import com.example.myuark.databinding.InfoFeaturedLinksItemMiddleBinding
import com.example.myuark.databinding.InfoFeaturedLinksItemTopBinding
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.PublishSubject
import java.util.concurrent.TimeUnit


class FeaturedLinksAdapter(context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var items: MutableList<URLInfo> = mutableListOf()
    private val mContext = context
    private val clickLink = PublishSubject.create<URLInfo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val infoFeaturedLinksItemTopBinding =
            InfoFeaturedLinksItemTopBinding.inflate(inflater, parent, false)
        val infoFeaturedLinksItemMiddleBinding =
            InfoFeaturedLinksItemMiddleBinding.inflate(inflater, parent, false)
        val infoFeaturedLinksItemBottomBinding =
            InfoFeaturedLinksItemBottomBinding.inflate(inflater, parent, false)

        return when (viewType) {
            Type.TOP.ordinal -> FeaturedLinksViewTopHolder(infoFeaturedLinksItemTopBinding)
            Type.MIDDLE.ordinal -> FeaturedLinksViewMiddleHolder(infoFeaturedLinksItemMiddleBinding)
            Type.BOTTOM.ordinal -> FeaturedLinksViewBottomHolder(infoFeaturedLinksItemBottomBinding)
            else -> FeaturedLinksViewMiddleHolder(infoFeaturedLinksItemMiddleBinding)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0 && itemCount > 1)
            Type.TOP.ordinal
        else if (itemCount > 1 && position == itemCount - 1)
            Type.BOTTOM.ordinal
        else
            Type.MIDDLE.ordinal

    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setData(urlList: List<URLInfo>?) {
        if (urlList != null)
            items = urlList.toMutableList()

        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        if (position == 0 && itemCount > 1)
            (holder as FeaturedLinksViewTopHolder).bindData(item, position)
        else if (itemCount > 1 && position == itemCount - 1)
            (holder as FeaturedLinksViewBottomHolder).bindData(item, position)
        else
            (holder as FeaturedLinksViewMiddleHolder).bindData(item, position)
    }

    fun clickLink(): Observable<URLInfo> = clickLink.debounce(300, TimeUnit.MILLISECONDS)

    inner class FeaturedLinksViewTopHolder(var binding: InfoFeaturedLinksItemTopBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(item: URLInfo, position: Int) {
            binding.card.text = item.title
            binding.card.setOnClickListener { clickLink.onNext(item) }
        }
    }

    inner class FeaturedLinksViewMiddleHolder(var binding: InfoFeaturedLinksItemMiddleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(item: URLInfo, position: Int) {
            binding.card.text = item.title
            binding.card.setOnClickListener { clickLink.onNext(item) }
        }
    }

    inner class FeaturedLinksViewBottomHolder(var binding: InfoFeaturedLinksItemBottomBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(item: URLInfo, position: Int) {
            binding.card.text = item.title
            binding.card.setOnClickListener { clickLink.onNext(item) }
        }
    }

    enum class Type {
        TOP,
        MIDDLE,
        BOTTOM,
    }
}