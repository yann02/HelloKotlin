package com.example.hellokotlin.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class DemoCollectionPagerAdapter(fm:FragmentManager):FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return FruitFragment()
    }

    override fun getCount(): Int =3
}