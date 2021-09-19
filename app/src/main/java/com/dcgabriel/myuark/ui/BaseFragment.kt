package com.dcgabriel.myuark.ui

import androidx.fragment.app.Fragment
import io.reactivex.rxjava3.disposables.CompositeDisposable

open class BaseFragment : Fragment()  {
    val disposables = CompositeDisposable()
}