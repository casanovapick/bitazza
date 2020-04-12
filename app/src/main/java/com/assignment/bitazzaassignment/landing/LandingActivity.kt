package com.assignment.bitazzaassignment.landing

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.assignment.bitazzaassignment.R
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_landing.tabLayout
import kotlinx.android.synthetic.main.activity_landing.viewPager

class LandingActivity : AppCompatActivity() {

    private val landingAdapter by lazy { LandingAdapter(this) }
    private val tabTexts = listOf("Home")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)
        viewPager.adapter = landingAdapter
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabTexts.getOrElse(position){"Dummy"}
        }.attach()
    }

    companion object {
        fun getStartIntent(context: Context): Intent = Intent(context, LandingActivity::class.java)
    }
}