package com.dcgabriel.myuark.ui

import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.floatingactionbutton.FloatingActionButton
import io.reactivex.rxjava3.disposables.CompositeDisposable

open class BaseActivity : AppCompatActivity() {
    protected val disposables = CompositeDisposable()
    protected var isFabExtended = false

    override fun onDestroy() {
        super.onDestroy()
        disposables.dispose()
    }

    fun openBrowser(url: String) {
        val webpage: Uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, webpage)
        if (intent.resolveActivity(packageManager!!) != null) {
            startActivity(intent)
        }

        //todo add function to allow opening to app instead of browser, if app is available on device.
    }

    protected fun showView(viewList: ArrayList<View>) {
        for (view in viewList) {
            if (view is ExtendedFloatingActionButton) {
                view.show()
                view.extend()
            } else {
                view.visibility = View.VISIBLE
            }
        }
    }

    protected fun hideView(viewList: ArrayList<View>) {
        for (view in viewList) {
            if (view is ExtendedFloatingActionButton) {
                view.shrink()
                view.hide()
            } else {
                view.visibility = View.GONE
            }
        }
    }

    protected fun showHideFAB(
        optionsFAB: View,
        fabList: ArrayList<View>,
        background: View
    ) {
        if (!isFabExtended) {
            showView(fabList)
            if (optionsFAB is ExtendedFloatingActionButton)
                optionsFAB.extend()
            background.visibility = View.VISIBLE
            isFabExtended = true
        } else {
            hideView(fabList)
            if (optionsFAB is ExtendedFloatingActionButton)
                optionsFAB.shrink()
            background.visibility = View.GONE
            isFabExtended = false
        }
    }

}