package com.androidnerds.createyourapp

import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.androidnerds.createyourapp.adapters.FragmentPageAdapter
import com.androidnerds.createyourapp.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var fragmentAdapter: FragmentPageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //getResponse()
        init()
    }

    private fun init() {
        addTabs()
        setAdapter()
        setOnEventListeners()
    }

    private fun addTabs() {
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Request"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Response"))
    }

    private fun setAdapter() {
        fragmentAdapter = FragmentPageAdapter(supportFragmentManager, lifecycle)
        binding.viewPager.adapter = fragmentAdapter
    }

    private fun setOnEventListeners() {
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    if (tab.position==0) binding.bottomLl.visibility = View.VISIBLE
                    else binding.bottomLl.visibility = View.GONE
                    binding.viewPager.currentItem = tab.position
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position==0) binding.bottomLl.visibility = View.VISIBLE
                else binding.bottomLl.visibility = View.GONE
                binding.tabLayout.selectTab(binding.tabLayout.getTabAt(position))
            }

            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
                binding.viewPager.isUserInputEnabled = state == ViewPager2.SCROLL_STATE_IDLE
            }
        })

        binding.btnGetResponse.setOnClickListener {
            binding.bottomLl.visibility = View.GONE
            binding.tabLayout.selectTab(binding.tabLayout.getTabAt(1))
        }
    }
}