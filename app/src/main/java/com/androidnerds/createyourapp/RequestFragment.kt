package com.androidnerds.createyourapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.viewpager2.widget.ViewPager2
import com.androidnerds.createyourapp.adapters.FragmentRequestAdapter
import com.androidnerds.createyourapp.databinding.FragmentRequestBinding
import com.google.android.material.tabs.TabLayout

class RequestFragment : Fragment() {

    private lateinit var binding: FragmentRequestBinding
    private lateinit var fragmentRequestAdapter: FragmentRequestAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentRequestBinding.inflate(inflater, container, false)
        val view = binding.root
        init()

        return view
    }
    private fun init() {
        addTabs()

        setAdapter()

        setOnEventListeners()
    }

    private fun addTabs() {
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Params"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Authorization"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Headers"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Body"))
    }
    private fun setOnEventListeners() {
        binding.ivArrow.setOnClickListener {
            updateChipGrpUI()
        }

        binding.chGet.setOnClickListener {
            binding.chSelect.text = resources.getString(R.string.get)
            updateChipGrpUI()
        }

        binding.chPost.setOnClickListener {
            binding.chSelect.text = resources.getString(R.string.post)
            updateChipGrpUI()
        }

        binding.chUpdate.setOnClickListener {
            binding.chSelect.text = resources.getString(R.string.update)
            updateChipGrpUI()
        }

        binding.chDelete.setOnClickListener {
            binding.chSelect.text = resources.getString(R.string.delete)
            updateChipGrpUI()
        }

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    binding.viewPager2.currentItem = tab.position
                }
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) { }
            override fun onTabReselected(tab: TabLayout.Tab?) { }
        })

        binding.viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.tabLayout.selectTab(binding.tabLayout.getTabAt(position))
            }
        })

    }

    private fun setAdapter() {
        fragmentRequestAdapter = FragmentRequestAdapter(childFragmentManager, lifecycle)
        binding.viewPager2.adapter = fragmentRequestAdapter
    }

    private fun updateChipGrpUI() {
        if(binding.cgRequests.isVisible) {
            binding.ivArrow.rotation = 0F
            binding.cgRequests.visibility = View.GONE
        }
        else {
            binding.ivArrow.rotation = 180F
            binding.cgRequests.visibility = View.VISIBLE
        }

        binding.chGet.visibility = View.VISIBLE
        binding.chPost.visibility = View.VISIBLE
        binding.chUpdate.visibility = View.VISIBLE
        binding.chDelete.visibility = View.VISIBLE

        if (binding.chSelect.text.equals(resources.getString(R.string.get))){
            binding.chGet.visibility = View.GONE
        } else if (binding.chSelect.text.equals(resources.getString(R.string.post))){
            binding.chPost.visibility = View.GONE
        } else if (binding.chSelect.text.equals(resources.getString(R.string.update))){
            binding.chUpdate.visibility = View.GONE
        } else if (binding.chSelect.text.equals(resources.getString(R.string.delete))){
            binding.chDelete.visibility = View.GONE
        }
    }
}