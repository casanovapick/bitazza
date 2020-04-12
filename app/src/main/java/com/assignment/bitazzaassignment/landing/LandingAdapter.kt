package com.assignment.bitazzaassignment.landing

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.assignment.bitazzaassignment.home.HomeFragment

class LandingAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    private val creatorList: List<() -> Fragment> = mutableListOf(
        { HomeFragment() }
    )
    override fun getItemCount(): Int = 4
    override fun createFragment(position: Int): Fragment {
        return creatorList.getOrElse(position) { { DummyFragment() } }()
    }
}