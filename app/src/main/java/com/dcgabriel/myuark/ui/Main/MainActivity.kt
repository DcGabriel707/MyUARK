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
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.dcgabriel.myuark.model.Constants
import com.dcgabriel.myuark.ui.News.NewsActivity
import com.dcgabriel.myuark.ui.WebViewActivity
import com.dcgabriel.myuark.ui.Adapters.TileAdapter
import com.dcgabriel.myuark.model.tiles.TileItem
import com.example.myuark.R
import com.example.myuark.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.jakewharton.rxbinding4.widget.textChanges
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val disposables = CompositeDisposable()
    private lateinit var adapter: TileAdapter
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
                binding.searchBackground.visibility = View.VISIBLE
                binding.backSearchButton.visibility = View.VISIBLE
                binding.searchRecyclerview.visibility = View.VISIBLE
            } else {
                binding.searchBackground.visibility = View.GONE
                binding.backSearchButton.visibility = View.GONE
                binding.searchRecyclerview.visibility = View.GONE
            }
        }


        binding.backSearchButton.setOnClickListener(View.OnClickListener {
            binding.searchEditText.clearFocus()
            binding.searchEditText.text.clear()
            val manager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            manager.hideSoftInputFromWindow(binding.searchEditText.windowToken, 0)
        })
    }

    fun onClick(item: TileItem) {
        when (item.action) {
            TileItem.Action.WEB_LINK -> performWebIntent(item.url)
            TileItem.Action.WEB_VIEW -> openWebView(item.url)
            TileItem.Action.APP_VIEW -> openActivity(item.destination)
        }
    }

    private fun performWebIntent(url: String?) {
        val webpage: Uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, webpage)
        if (intent.resolveActivity(packageManager!!) != null) {
            startActivity(intent)
        }
    }

    private fun openWebView(url: String?) {
        val intent = Intent(this, WebViewActivity::class.java)
            .putExtra(Constants.EXTRA_URL, url)
        startActivity(intent)

    }

    //wip
    private fun openActivity(destination: String?){
        lateinit var intent: Intent
        when (destination) {
            Constants.ACTIVITY_NEWS -> intent = Intent(this, NewsActivity::class.java)
            else -> intent = Intent(this, NewsActivity::class.java)
        }

        startActivity(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.dispose()
    }
}