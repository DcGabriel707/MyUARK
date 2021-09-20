package com.dcgabriel.myuark

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.myuark.R
import com.example.myuark.databinding.ActivityTransitBinding

class TransitActivity : AppCompatActivity() {
    lateinit var binding: ActivityTransitBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transit)

        binding = ActivityTransitBinding.inflate(layoutInflater)

        binding.transitWebview.loadUrl("https://uark.passiogo.com/")
        binding.sampleText.text = "SAMMMMPLEEE TESSSSTTT TEEEXT"
    }
}