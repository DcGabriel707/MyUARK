package com.example.myuark

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class InfoPageFragment : Fragment() {

    // TODO: -----------may not even need this fragment file. Delete Whenever//////--------------
    companion object {
        fun newInstance() = InfoPageFragment()
    }

    private lateinit var viewModel: InfoPageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_info_page, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(InfoPageViewModel::class.java)
        // TODO: Use the ViewModel
    }

}