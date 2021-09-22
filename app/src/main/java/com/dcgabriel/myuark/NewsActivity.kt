package com.dcgabriel.myuark

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.dcgabriel.myuark.ui.TileAdapter
import com.example.myuark.R
import com.example.myuark.databinding.ActivityMainBinding
import com.example.myuark.databinding.ActivityNewsBinding

class NewsActivity : AppCompatActivity() {
    private val viewModel: NewsViewModel by viewModels()
    private lateinit var adapter: CardAdapter
    private lateinit var binding: ActivityNewsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding =  ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        initRecyclerView()

    }

    private fun initRecyclerView() {
        val layoutManager = LinearLayoutManager(this)
        adapter = CardAdapter(this)
        binding.newsRecyclerview.layoutManager = layoutManager
        binding.newsRecyclerview.adapter = adapter
        adapter.setData(viewModel.getNews())
    }

    fun yessir(view: View) {
        Toast.makeText(this, "sdasdsdasd", Toast.LENGTH_SHORT).show()

        adapter.setData(viewModel.getNews())

    }
}