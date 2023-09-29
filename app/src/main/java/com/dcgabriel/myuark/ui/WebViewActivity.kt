package com.dcgabriel.myuark.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.widget.LinearLayout
import androidx.activity.viewModels
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.LinearLayoutCompat
import com.dcgabriel.myuark.model.Constants
import com.dcgabriel.myuark.model.tiles.TileItem
import com.example.myuark.InfoPageFragment
import com.example.myuark.R
import com.example.myuark.databinding.ActivityWebviewBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class WebViewActivity : BaseActivity() {

    private lateinit var binding: ActivityWebviewBinding
    private lateinit var webView: WebView
    private lateinit var otherLinks: ArrayList<String>
    private var fabList: ArrayList<View> = arrayListOf()
    private val viewModel: WebViewViewModel by viewModels()
    private lateinit var tileItem: TileItem
    private lateinit var infoPageFragment: InfoPageFragment
    private lateinit var infoPageBottomSheet: LinearLayoutCompat

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
        initInfoPage()
        //initFAB()
    }

    private fun initInfoPage() {
        infoPageBottomSheet = binding.bottomSheet.infoPageBottomsheet
        val sheetBehavior = BottomSheetBehavior.from(infoPageBottomSheet)
        binding.bottomSheet.textView2.setOnClickListener() {
            if (sheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
                sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            } else {
                sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            }
        }

    }

        private fun initWebView() {
            val webSettings = webView.settings
            val url = tileItem.tileData.url.toString()
            webView.webChromeClient = WebClient()
            webView.clearHistory()
            webSettings.cacheMode = WebSettings.LOAD_NO_CACHE
            webSettings.allowContentAccess = true
            webSettings.domStorageEnabled = true
            webSettings.javaScriptEnabled = true
            webSettings.setSupportZoom(true)
            webSettings.useWideViewPort = true
            webSettings.loadWithOverviewMode = true

            webView.loadUrl(url)
        }

        private fun initSubscriptions() {
        }

//    private fun initFAB() {
//        if (tileItem.tileData.applink != null) {
//            fabList.add(binding.appFab)
//        }
//
//        fabList.add(binding.browserFab)
//        for (i in otherLinks.indices) {
//            when (i) {
//                0 -> {
//                    setTextIcon(binding.otherFab1, otherLinks.get(0))
//                    fabList.add(binding.otherFab1)
//                }
//
//                1 -> {
//                    setTextIcon(binding.otherFab2, otherLinks.get(1))
//                    fabList.add(binding.otherFab2)
//                }
//
//                2 -> {
//                    setTextIcon(binding.otherFab3, otherLinks.get(2))
//                    fabList.add(binding.otherFab3)
//                }
//            }
//        }
//
//        for (fab in fabList) {
//            fab.visibility = View.GONE
//            (fab as ExtendedFloatingActionButton).shrink()
//        }
//    }

        private fun setTextIcon(fab: ExtendedFloatingActionButton, url: String) {
            when {
                url.contains("facebook", ignoreCase = true) -> {
                    fab.text = getString(R.string.facebook)
                    fab.icon = AppCompatResources.getDrawable(this, R.drawable.facebook)
                }

                url.contains("twitter", ignoreCase = true) -> {
                    fab.text = getString(R.string.twitter)
                    fab.icon = AppCompatResources.getDrawable(this, R.drawable.twitter)
                }

                url.contains("instagram", ignoreCase = true) -> {
                    fab.text = getString(R.string.instagram)
                    fab.icon = AppCompatResources.getDrawable(this, R.drawable.instagram)
                }

                url.contains("youtube", ignoreCase = true) -> {
                    fab.text = getString(R.string.youtube)
                    fab.icon = AppCompatResources.getDrawable(this, R.drawable.youtube)
                }

                else -> {
                    fab.text = getString(R.string.open_link)
                }
            }
        }

        private fun openAppIntent(applink: String?) {
            val intent = packageManager.getLaunchIntentForPackage(applink.toString())
            if (intent != null) {
                startActivity(intent);
            } else {
                val intent = Intent(Intent.ACTION_VIEW).apply {
                    data = Uri.parse(
                        "https://play.google.com/store/apps/details?id=$applink"
                    )
                    setPackage("com.android.vending")
                }
                startActivity(intent)
            }
        }

        fun closeWebview(item: MenuItem) = finish()
        fun refreshWebview(item: MenuItem) = webView.reload()

        //fun clickOptions(view: View) = showHideFAB(binding.optionsFab, fabList, binding.fabBackground)
        fun otherFab1CLick(view: View) = openBrowser(otherLinks[0])
        fun otherFab2CLick(view: View) = openBrowser(otherLinks[1])
        fun otherFab3CLick(view: View) = openBrowser(otherLinks[2])
        fun openBrowserClick(view: View) = openBrowser(webView.url.toString())
        fun appFabClick(view: View) = openAppIntent(tileItem.tileData.applink)
        //fun fabBackgroundClick(view: View) = clickOptions(view)

        override fun onBackPressed() {
            if (webView.canGoBack())
                webView.goBack()
            else
                super.onBackPressed()
        }

        inner class WebClient() : WebChromeClient() {
            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                if (newProgress == 100)
                    binding.loadingBar.visibility = View.GONE
                else
                    binding.loadingBar.visibility = View.VISIBLE
                super.onProgressChanged(view, newProgress)
            }
        }
    }