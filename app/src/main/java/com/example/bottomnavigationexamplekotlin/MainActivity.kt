package com.example.bottomnavigationexamplekotlin

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.bottomnavigationexamplekotlin.fragments.FavoriteFragment
import com.example.bottomnavigationexamplekotlin.fragments.HomeFragment
import com.example.bottomnavigationexamplekotlin.fragments.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val favoriteFragment = FavoriteFragment()
        val settingsFragment = SettingsFragment()


        makeCurrentFragment(homeFragment)
        main_fragLayout.bottomNavigation.setOnNavigationItemSelectedListener {

                when (it.itemId) {
                    R.id.ic_home -> makeCurrentFragment(homeFragment)
                    R.id.ic_favorite -> makeCurrentFragment(favoriteFragment)
                    R.id.ic_settings -> makeCurrentFragment(settingsFragment)
                }
                true
            }
    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.main_fragLayout, fragment)
            commit()
        }
    }
}