package com.dcgabriel.myuark

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings

import com.example.myuark.R
import com.example.myuark.databinding.ActivityTransitBinding

class TransitActivity : AppCompatActivity() {
    lateinit var binding: ActivityTransitBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTransitBinding.inflate(layoutInflater)

        setContentView(binding.root)


        val webSettings = binding.transitWebview.settings
        webSettings.javaScriptEnabled = true

        binding.transitWebview.loadUrl("https://uark.passiogo.com/")
    }
}