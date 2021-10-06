package com.dcgabriel.myuark.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.dcgabriel.myuark.model.Constants
import com.dcgabriel.myuark.model.tiles.TileItem
import com.example.myuark.databinding.ActivityWebviewBinding
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.disposables.CompositeDisposable

@AndroidEntryPoint
class WebViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWebviewBinding
    private lateinit var webView: WebView
    private val disposables = CompositeDisposable()
    private var isFabExtended = false;
    private lateinit var otherLinks: ArrayList<String>
    private var fabList: ArrayList<ExtendedFloatingActionButton> = arrayListOf()
    private val viewModel: WebViewViewModel by viewModels()
    private lateinit var tileItem: TileItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tileId = intent.getIntExtra(Constants.EXTRA_TILE_DATA, 0)
        tileItem = viewModel.queryTile(tileId)!!
        otherLinks = tileItem.tileData.otherLinks!!

        webView = binding.webview
        initSubscriptions()
        initWebView()
        initFAB()
    }

    private fun initWebView() {
        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true
        webView.webChromeClient = WebChromeClient()
        webView.clearHistory()
        webSettings.cacheMode = WebSettings.LOAD_NO_CACHE
        webSettings.allowContentAccess = true
        webSettings.domStorageEnabled = true
        webSettings.javaScriptEnabled = true
        webSettings.setSupportZoom(true)
        webSettings.useWideViewPort = true
        webSettings.loadWithOverviewMode = true
        webView.loadUrl(tileItem.tileData.url.toString())
    }

    private fun initSubscriptions() {
    }

    private fun initFAB() {
        fabList.add(binding.appFab)
        fabList.add(binding.browserFab)
        for (i in otherLinks.indices) {
            when (i) {
                0 -> {
                    binding.otherFab1.text = setFABText(otherLinks.get(0))
                    fabList.add(binding.otherFab1)
                }
                1 -> {
                    binding.otherFab2.text = setFABText(otherLinks.get(1))
                    fabList.add(binding.otherFab2)
                }
                2 -> {
                    binding.otherFab3.text = setFABText(otherLinks.get(2))
                    fabList.add(binding.otherFab3)
                }
            }
        }

        for (fab in fabList) {
            fab.visibility = View.GONE
            fab.shrink()
        }
    }

    private fun setFABText(url: String): String {
        return when {
            url.contains("facebook", ignoreCase = true) -> "Facebook"
            url.contains("twitter", ignoreCase = true) -> "Twitter"
            url.contains("instagram", ignoreCase = true) -> "Instagram"
            url.contains("youtube", ignoreCase = true) -> "Youtube"
            else -> "Open Related Link"
        }
    }

    private fun openWebIntent(url: String) {
        val webpage: Uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, webpage)
        if (intent.resolveActivity(packageManager!!) != null) {
            startActivity(intent)
        }
    }


    fun clickOptions(view: View) {
        if (!isFabExtended) {
            for (fab in fabList) {
                fab.show()
                fab.extend()
            }
            binding.optionsFab.extend()
            isFabExtended = true
        } else {
            for (fab in fabList) {
                fab.shrink()
                fab.hide()
            }
            binding.optionsFab.shrink()
            isFabExtended = false
        }
    }

    fun otherFab1CLick(view: View) = openWebIntent(otherLinks[0])
    fun otherFab2CLick(view: View) = openWebIntent(otherLinks[1])
    fun otherFab3CLick(view: View) = openWebIntent(otherLinks[2])
    fun openBrowserClick(view: View) = openWebIntent(webView.url.toString())


    override fun onBackPressed() {
        if (webView.canGoBack())
            webView.goBack()
        else
            super.onBackPressed()
    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.dispose()
    }

}