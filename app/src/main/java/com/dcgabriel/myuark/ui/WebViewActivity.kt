package com.dcgabriel.myuark.ui

import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import com.dcgabriel.myuark.ui.model.Constants
import com.example.myuark.databinding.ActivityWebviewBinding
import io.reactivex.rxjava3.disposables.CompositeDisposable

class WebViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWebviewBinding
    private lateinit var webView: WebView
    private val disposables = CompositeDisposable()
    private var isFabExtended = false;
    private lateinit var url: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebviewBinding.inflate(layoutInflater)

        setContentView(binding.root)

        url = intent.getStringExtra(Constants.EXTRA_URL)!!

        webView = binding.webview
        initSubscriptions()
        initWebView()
        initFAB()
    }

    private fun initSubscriptions() {
//        disposables.add(
//            .map { it.toString() }
//            .distinctUntilChanged()
//            .subscribe {
//            }
    }

    private fun initFAB() {
        binding.optionsFab.shrink()
        binding.socialFab1.shrink()
        binding.appFab.shrink()
        binding.browserFab.shrink()
        binding.socialFab1.visibility = View.GONE
        binding.appFab.visibility = View.GONE
        binding.browserFab.visibility = View.GONE

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
        webView.loadUrl(url.toString())
    }

    fun clickOptions(view: View) {
        if (!isFabExtended) {
            binding.socialFab1.show()
            binding.appFab.show()
            binding.browserFab.show()
            binding.socialFab1.extend()
            binding.appFab.extend()
            binding.browserFab.extend()
            binding.optionsFab.extend()
            isFabExtended = true
        } else {
            binding.socialFab1.shrink()
            binding.appFab.shrink()
            binding.browserFab.shrink()
            binding.socialFab1.hide()
            binding.appFab.hide()
            binding.browserFab.hide()
            binding.optionsFab.shrink()
            isFabExtended = false
        }
    }

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