package com.dcgabriel.myuark.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import android.view.MotionEvent
import android.view.View
import android.view.ViewTreeObserver
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dcgabriel.myuark.model.Constants
import com.dcgabriel.myuark.model.FeedEntry.FeedEntry
import com.dcgabriel.myuark.model.tiles.TileItem
import com.dcgabriel.myuark.ui.Adapters.FeaturedLinksAdapter
import com.dcgabriel.myuark.ui.Adapters.FeedsAdapter
import com.dcgabriel.myuark.ui.Adapters.SocialLinksAdapter
import com.example.myuark.InfoPageFragment
import com.example.myuark.databinding.ActivityWebviewBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior.*
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers

@AndroidEntryPoint
class WebViewActivity : BaseActivity(), View.OnTouchListener,
    ViewTreeObserver.OnScrollChangedListener {

    private lateinit var binding: ActivityWebviewBinding
    private lateinit var webView: WebView

    private var fabList: ArrayList<View> = arrayListOf()
    private val viewModel: WebViewViewModel by viewModels()
    private lateinit var tileItem: TileItem
    private lateinit var infoPageFragment: InfoPageFragment //todo remove
    private lateinit var infoPageBottomSheet: LinearLayoutCompat
    private lateinit var feedList: List<FeedEntry>
    private lateinit var feedsAdapter: FeedsAdapter
    private lateinit var socialLinksAdapter: SocialLinksAdapter
    private lateinit var featuredLinksAdapter: FeaturedLinksAdapter
    private lateinit var scrollView: NestedScrollView
    private val cardElevation = 6f

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebviewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val tileId = intent.getIntExtra(Constants.EXTRA_TILE_DATA, 0)
        tileItem = viewModel.setCurrentTile(tileId)!!

        initWebView()
        initInfoPage()
        initRecyclerViews()
        initSubscriptions()
        //initFAB()
    }

    private fun initRecyclerViews() {
        feedList = viewModel.getFeeds()
        feedsAdapter = FeedsAdapter(this)
        socialLinksAdapter = SocialLinksAdapter(this)
        featuredLinksAdapter = FeaturedLinksAdapter(this)

        binding.bottomSheet.recyclerView.layoutManager =
            LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        binding.bottomSheet.recyclerView.adapter = feedsAdapter
        binding.bottomSheet.recyclerView2.layoutManager =
            LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        binding.bottomSheet.recyclerView2.adapter = socialLinksAdapter
        binding.bottomSheet.recyclerView3.layoutManager = LinearLayoutManager(this)
        binding.bottomSheet.recyclerView3.adapter = featuredLinksAdapter

        feedsAdapter.setData(feedList)
        socialLinksAdapter.setData(viewModel.getSocialLinks())

        if ((viewModel.getFeaturedLinks() == null) || viewModel.getFeaturedLinks()!!.isEmpty())
            binding.bottomSheet.emptyLayout.emptyTextview.visibility = View.VISIBLE
        else {
            featuredLinksAdapter.setData(viewModel.getFeaturedLinks())
            binding.bottomSheet.emptyLayout.emptyTextview.visibility = View.GONE
        }
    }

    private fun initInfoPage() {
        scrollView = binding.bottomSheet.scrollView
        infoPageBottomSheet = binding.bottomSheet.infoPageBottomsheet
        val sheetBehavior = from(infoPageBottomSheet)
        sheetBehavior.isDraggable = true
        binding.bottomSheet.titleTextView.text = tileItem.title
        binding.bottomSheet.titleTextView.setOnClickListener() {
            if (sheetBehavior.getState() != STATE_EXPANDED) {
                sheetBehavior.setState(STATE_EXPANDED);
            } else {
                sheetBehavior.setState(STATE_COLLAPSED);
            }
        }

        sheetBehavior.addBottomSheetCallback(object : BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when (newState) {
                    STATE_EXPANDED, STATE_HALF_EXPANDED -> {
                        //binding.bottomSheet.handleCardview.cardElevation = cardElevation
                        binding.bottomSheet.handleCardview.radius = 16f

                    }

                    STATE_COLLAPSED, STATE_HIDDEN -> {
                        binding.bottomSheet.handleCardview.cardElevation = 0f
                        binding.bottomSheet.handleCardview.radius = 62f
                    }

                    else -> {
                        // Do nothing, only change callback enabled for "stable" states.
                    }
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {}
        })

        scrollView.setOnTouchListener(this)
        scrollView.viewTreeObserver.addOnScrollChangedListener(this)

        binding.bottomSheet.email.text = tileItem.tileData.email
        binding.bottomSheet.address.text = tileItem.tileData.address
        binding.bottomSheet.phone.text = tileItem.tileData.phone
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
        return false
    }

    override fun onScrollChanged() {
        val view = scrollView.getChildAt(scrollView.childCount - 1)
        val topDetector = scrollView.scrollY
        val offset = 20 // just to give more space
        if (topDetector <= offset) {
            binding.bottomSheet.handleCardview.cardElevation = 0f
        } else
            binding.bottomSheet.handleCardview.cardElevation = cardElevation
    }

    private fun initWebView() {
        webView = binding.webview
        val webSettings = webView.settings
        val url = tileItem.tileData.url!!.url.toString()
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
        disposables.addAll(
            featuredLinksAdapter.clickLink()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    openBrowser(it.url)
                    Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show()
                },
            socialLinksAdapter.clickLink()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    openBrowser(it.url)
                    Toast.makeText(this, "clicked " + it.url, Toast.LENGTH_SHORT).show()
                }
        )
    }

    //todo remove fabs
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

    //todo remove FAB in the future
    fun otherFab1CLick(view: View) = openBrowser(viewModel.getFeaturedLinks()?.get(0)!!.url)
    fun otherFab2CLick(view: View) = openBrowser(viewModel.getFeaturedLinks()?.get(1)!!.url)
    fun otherFab3CLick(view: View) = openBrowser(viewModel.getFeaturedLinks()?.get(2)!!.url)
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