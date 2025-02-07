package com.example.bottomviews

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.bottomviews.adapter.FragmentAdapter
import com.example.bottomviews.databinding.ActivityMainBinding
import com.example.bottomviews.ui.dashboard.DashboardFragment
import com.example.bottomviews.ui.home.HomeFragment
import com.example.bottomviews.ui.notifications.NotificationsFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Menentukan fragment untuk ditampilkan di viewPager2
        val listOfFragments = listOf(HomeFragment(), DashboardFragment(), NotificationsFragment())
        binding.viewPager.adapter = FragmentAdapter(this, listOfFragments)
        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when (position) {
                    0 -> binding.navView.menu.findItem(R.id.navigation_home).isChecked = true
                    1 -> binding.navView.menu.findItem(R.id.navigation_dashboard).isChecked = true
                    2 -> binding.navView.menu.findItem(R.id.navigation_notifications).isChecked = true

                }
            }
        })

        // event listener untuk perubahan bottomNavigationView
        binding.navView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_home -> {
                    binding.viewPager.setCurrentItem(0, true)
                    return@setOnItemSelectedListener true

                }
                R.id.navigation_dashboard -> {
                    binding.viewPager.setCurrentItem(1, true)
                    return@setOnItemSelectedListener true
                }
                R.id.navigation_notifications -> {
                    binding.viewPager.setCurrentItem(2, true)
                    return@setOnItemSelectedListener true
                }
            }
            return@setOnItemSelectedListener false
        }
    }
}