package com.example.bottomviews.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentAdapter (fragment: FragmentActivity, private val fragments: List<Fragment>) :
        FragmentStateAdapter(fragment) {
    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }

    override fun getItemCount(): Int {
        return fragments.size
    }

}
