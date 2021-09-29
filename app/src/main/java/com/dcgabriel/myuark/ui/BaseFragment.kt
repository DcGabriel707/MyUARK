package com.dcgabriel.myuark.ui

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.dcgabriel.myuark.ui.Adapters.TileAdapter
import com.dcgabriel.myuark.ui.Main.MainActivity
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable

open class BaseFragment : Fragment()  {

     val disposables = CompositeDisposable()
    protected lateinit var adapter: TileAdapter


    protected open fun initSubscriptions() {
        disposables.add(adapter.clickEvents()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                (activity as MainActivity?)!!.onClick(it)
            })
    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.dispose()
    }

    protected val itemTouchHelperCallback = object : ItemTouchHelper.Callback() {
        override fun getMovementFlags(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder
        ): Int {
            val drag = ItemTouchHelper.UP or ItemTouchHelper.DOWN
            return makeMovementFlags(drag, 0)
        }

        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            adapter.notifyItemMoved(viewHolder.adapterPosition, target.adapterPosition)
            return true
        }

        override fun isLongPressDragEnabled(): Boolean {
            return true
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            TODO("Not yet implemented")
        }
    }


}