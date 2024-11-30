package com.nanda.rts_cafe.Fragments

import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appname.Adapter
import com.nanda.rts_cafe.R

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        setupRecyclerView(view)
        return view
    }

    private fun setupRecyclerView(view: View) {
        val menuItems = listOf(
            Adapter.MenuItem(R.drawable.foto, "Spaghetti Bolognese", "32.000 IDR", "5.2"),
            Adapter.MenuItem(R.drawable.foto, "Lasagna", "45.000 IDR", "4.8"),
            Adapter.MenuItem(R.drawable.foto, "Pizza", "60.000 IDR", "4.9")
        )

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = Adapter(menuItems)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)

        val spacing = 2 // Adjust spacing as needed
        recyclerView.addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(
                outRect: Rect,
                view: View,
                parent: RecyclerView,
                state: RecyclerView.State
            ) {
                outRect.set(spacing, spacing, spacing, spacing)
            }
        })
    }
}
