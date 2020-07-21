package com.example.hellokotlin.CircleIndicator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.hellokotlin.R
import com.example.hellokotlin.viewpager.DemoCollectionPagerAdapter
import me.relex.circleindicator.CircleIndicator

class CircleIndicatorActivity : AppCompatActivity() {

    private lateinit var mDemoCollectionPagerAdapter: DemoCollectionPagerAdapter
    private lateinit var mViewPager: ViewPager
    private lateinit var mCircleIndicator: CircleIndicator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_circle_indicator)
        initViewPager()
    }

    private fun initViewPager() {
        mDemoCollectionPagerAdapter = DemoCollectionPagerAdapter(supportFragmentManager)
        mViewPager = findViewById(R.id.vp_ci)
        mViewPager.adapter = mDemoCollectionPagerAdapter
        mCircleIndicator=findViewById(R.id.ci_main)
        mCircleIndicator.setViewPager(mViewPager)
    }
}
