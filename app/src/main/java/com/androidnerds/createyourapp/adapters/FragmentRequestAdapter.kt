package com.androidnerds.createyourapp.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.androidnerds.createyourapp.AuthorizationFragment
import com.androidnerds.createyourapp.BodyFragment
import com.androidnerds.createyourapp.HeadersFragment
import com.androidnerds.createyourapp.ParamsFragment

class FragmentRequestAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ParamsFragment()
            1 -> AuthorizationFragment()
            2 -> HeadersFragment()
            else -> BodyFragment()
        }
    }
}