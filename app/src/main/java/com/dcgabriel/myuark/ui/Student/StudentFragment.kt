package com.dcgabriel.myuark.ui.Student

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import com.dcgabriel.myuark.ui.BaseFragment
import com.dcgabriel.myuark.ui.Adapters.TileAdapter
import com.example.myuark.databinding.FragmentStudentBinding

class StudentFragment : BaseFragment() {

    private lateinit var studentViewModel: StudentViewModel
    private lateinit var binding: FragmentStudentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        studentViewModel = ViewModelProvider(this).get(StudentViewModel::class.java)
        binding = FragmentStudentBinding.inflate(inflater)

        handleGridLayout()
        initSubscriptions()
        return binding.root
    }

    fun handleGridLayout(){
        val col = 3
        val gridlayoutManager = GridLayoutManager(context, col)
        adapter = TileAdapter(requireContext())
        binding.studentRecyclerview.layoutManager = gridlayoutManager
        binding.studentRecyclerview.adapter = adapter
        gridlayoutManager.spanSizeLookup = adapter.getColSize
        adapter.setData(studentViewModel.getTiles())
        val touchHelper = ItemTouchHelper(itemTouchHelperCallback)
        touchHelper.attachToRecyclerView(binding.studentRecyclerview)
    }

}