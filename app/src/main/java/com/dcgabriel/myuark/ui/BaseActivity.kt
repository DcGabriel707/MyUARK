package com.dcgabriel.myuark.ui

import android.content.Intent
import android.net.Uri
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import io.reactivex.rxjava3.disposables.CompositeDisposable

open class BaseActivity : AppCompatActivity() {
    protected val disposables = CompositeDisposable()
    protected var isFabExtended = false;

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
        optionsFAB: ExtendedFloatingActionButton,
        fabList: ArrayList<View>
    ) {
        if (!isFabExtended) {
            showView(fabList)
            optionsFAB.extend()
            isFabExtended = true
        } else {
            hideView(fabList)
            optionsFAB.shrink()
            isFabExtended = false
        }
    }

}