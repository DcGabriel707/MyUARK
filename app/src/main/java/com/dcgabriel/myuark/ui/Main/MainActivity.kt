package com.dcgabriel.myuark.ui.Main

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.View.OnFocusChangeListener
import android.view.inputmethod.InputMethodManager
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.dcgabriel.myuark.model.Constants
import com.dcgabriel.myuark.ui.News.NewsActivity
import com.dcgabriel.myuark.ui.WebViewActivity
import com.dcgabriel.myuark.ui.Adapters.TileAdapter
import com.dcgabriel.myuark.model.tiles.TileItem
import com.dcgabriel.myuark.ui.BaseActivity
import com.dcgabriel.myuark.ui.Events.EventsActivity
import com.dcgabriel.myuark.ui.Student.StudentIdActivity
import com.example.myuark.R
import com.example.myuark.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.jakewharton.rxbinding4.widget.textChanges
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: TileAdapter
    private val viewModel: MainViewModel by viewModels()
    private var isSearchVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        navView.setupWithNavController(navController)
        navView.selectedItemId = R.id.navigation_home

        initRecyclerview()
        initSubscription()
        initListener()
    }

    //<<Contact me at gcarapplications@gmail.com for questions>>


    private fun initSubscription() {
        disposables.add(adapter.clickEvents()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                onClick(it)
            })
        disposables.add(binding.searchEditText.textChanges()
            .map { it.toString() }
            .distinctUntilChanged()
            .subscribe {
                adapter.setData(viewModel.queryTile(it))
            }
        )
    }

    private fun initRecyclerview() {
        val layoutManager = LinearLayoutManager(this)
        adapter = TileAdapter(this)
        binding.searchRecyclerview.layoutManager = layoutManager
        binding.searchRecyclerview.adapter = adapter
    }

    private fun initListener() {
        binding.searchEditText.onFocusChangeListener = OnFocusChangeListener { view, inFocus ->
            if (inFocus) {
                isSearchVisible = true
                showView(arrayListOf(binding.searchBackground,binding.backSearchButton,binding.searchRecyclerview))
            } else {
                isSearchVisible = false
                hideView(arrayListOf(binding.searchBackground,binding.backSearchButton,binding.searchRecyclerview))
            }
        }

        binding.backSearchButton.setOnClickListener{ exitSearch() }
        binding.searchBackground.setOnClickListener{ exitSearch() }
    }

    fun onClick(item: TileItem) {
        when (item.action) {
            TileItem.Action.WEB_LINK -> openBrowser(item.tileData.url.toString())
            TileItem.Action.WEB_VIEW -> openWebView(item)
            TileItem.Action.APP_VIEW -> openActivity(item.destination)
        }
    }

    fun exitSearch(){
        binding.searchEditText.clearFocus()
        binding.searchEditText.text.clear()
        val manager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        manager.hideSoftInputFromWindow(binding.searchEditText.windowToken, 0)
    }

    private fun openWebView(item: TileItem) {
        val intent = Intent(this, WebViewActivity::class.java)
            .putExtra(Constants.EXTRA_TILE_DATA, item.id )
        startActivity(intent)
    }

    //wip
    private fun openActivity(destination: String?){
        lateinit var intent: Intent
        when (destination) {
            Constants.ACTIVITY_NEWS -> intent = Intent(this, NewsActivity::class.java)
            Constants.ACTIVITY_EVENTS -> intent = Intent(this, EventsActivity::class.java)
            Constants.ACTIVITY_STUDENT_ID-> intent = Intent(this, StudentIdActivity::class.java)
            else -> intent = Intent(this, NewsActivity::class.java)
        }

        startActivity(intent)
    }

    override fun onBackPressed() {
        if(isSearchVisible) {
            isSearchVisible = false
            exitSearch()
        } else {
            super.onBackPressed()
        }
    }
}