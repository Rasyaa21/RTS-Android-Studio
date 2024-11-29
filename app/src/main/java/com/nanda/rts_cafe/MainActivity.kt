package com.nanda.rts_cafe

import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appname.Adapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val menuItems = listOf(
            Adapter.MenuItem(R.drawable.foto, "Spaghetti Bolognese", "32.000 IDR", "5.2"),
            Adapter.MenuItem(R.drawable.foto, "Lasagna", "45.000 IDR", "4.8"),
            Adapter.MenuItem(R.drawable.foto, "Pizza", "60.000 IDR", "4.9"),
        )

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = Adapter(menuItems)
        recyclerView.layoutManager = GridLayoutManager(this, 2) // 2 items per row

        // Add spacing between items
        val spacing = 16 // 16dp spacing
        recyclerView.addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
                outRect.set(spacing, spacing, spacing, spacing)
            }
        })
    }
}
