package com.nanda.rts_cafe

import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appname.Adapter
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.nanda.rts_cafe.Fragments.CartFragment
import com.nanda.rts_cafe.Fragments.ProfileFragment
import com.nanda.rts_cafe.Fragments.SearchFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val SearchFragment = SearchFragment()
        val ProfileFragment = ProfileFragment()
        val CartFragment = CartFragment()


        val menuItems = listOf(
            Adapter.MenuItem(R.drawable.foto, "Spaghetti Bolognese", "32.000 IDR", "5.2"),
            Adapter.MenuItem(R.drawable.foto, "Lasagna", "45.000 IDR", "4.8"),
            Adapter.MenuItem(R.drawable.foto, "Pizza", "60.000 IDR", "4.9"),
        )

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = Adapter(menuItems)
        recyclerView.layoutManager = GridLayoutManager(this, 2) // 2 items per row

        // Add spacing between items
        val spacing = 2 // 16dp spacing
        recyclerView.addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
                outRect.set(spacing, spacing, spacing, spacing)
            }
        })

        toggleHomeVisibility(true)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavView)
        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home -> {
                    toggleHomeVisibility(true)
                    supportFragmentManager.popBackStack(null, 0) // Clear back stack
                    true
                }
                else -> {
                    toggleHomeVisibility(false)
                    val selectedFragment = when (menuItem.itemId) {
                        R.id.search -> SearchFragment()
                        R.id.cart -> CartFragment()
                        R.id.profile -> ProfileFragment()
                        else -> null
                    }
                    selectedFragment?.let { loadFragment(it) }
                    true
                }
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }

        private fun toggleHomeVisibility(showHome: Boolean) {
            findViewById<View>(R.id.main).visibility = if (showHome) View.VISIBLE else View.GONE
            findViewById<View>(R.id.fragment_container).visibility = if (showHome) View.GONE else View.VISIBLE
        }
    }
