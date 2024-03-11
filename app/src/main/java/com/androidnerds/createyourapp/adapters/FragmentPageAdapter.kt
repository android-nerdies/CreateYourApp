package com.androidnerds.createyourapp.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.androidnerds.createyourapp.RequestFragment
import com.androidnerds.createyourapp.ResponseFragment

class FragmentPageAdapter (
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle){

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return if(position==0) {
            RequestFragment()
        }
        else{
            ResponseFragment()
        }
    }

}