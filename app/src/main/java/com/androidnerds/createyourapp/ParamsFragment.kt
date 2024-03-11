package com.androidnerds.createyourapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.androidnerds.createyourapp.databinding.FragmentParamsBinding

class ParamsFragment : Fragment() {
    private lateinit var binding: FragmentParamsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentParamsBinding.inflate(inflater, container, false)
        val view = binding.root
        init()
        return view
    }

    private fun init() {
        setOnEventListeners()
    }

    private fun setOnEventListeners() {
        binding.tvAddNew.setOnClickListener {
            addNewQuery()
        }


    }

    private fun addNewQuery() {
        val view = layoutInflater.inflate(R.layout.item_param, null)
        binding.llQueries.addView(view)
    }
}