package com.dcgabriel.myuark.ui

import androidx.fragment.app.Fragment
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

}