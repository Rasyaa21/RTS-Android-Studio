package com.nanda.rts_cafe

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.nanda.rts_cafe.Fragments.CartFragment
import com.nanda.rts_cafe.Fragments.HomeFragment
import com.nanda.rts_cafe.Fragments.ProfileFragment
import com.nanda.rts_cafe.Fragments.SearchFragment

class MainActivity : AppCompatActivity() {
    private val homeFragment = HomeFragment()
    private val searchFragment = SearchFragment()
    private val profileFragment = ProfileFragment()
    private val cartFragment = CartFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavView)

        // Set default home view
        loadFragment(homeFragment)
        bottomNavigationView.selectedItemId = R.id.home

        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            val selectedFragment: Fragment? = when (menuItem.itemId) {
                R.id.home -> homeFragment
                R.id.search -> searchFragment
                R.id.cart -> cartFragment
                R.id.profile -> profileFragment
                else -> null
            }
            selectedFragment?.let { loadFragment(it) }
            true
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
