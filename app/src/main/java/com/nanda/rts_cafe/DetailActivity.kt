package com.nanda.rts_cafe

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.nanda.rts_cafe.R

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)

        // Find views
        val imageView: ImageView = findViewById(R.id.detail_image)
        val titleTextView: TextView = findViewById(R.id.detail_title)
        val priceTextView: TextView = findViewById(R.id.detail_price)
        val ratingTextView: TextView = findViewById(R.id.detail_rating)

        // Get data from intent
        val imagePath = intent.getIntExtra("imagePath", 0)
        val title = intent.getStringExtra("title") ?: ""
        val price = intent.getStringExtra("price") ?: ""
        val rating = intent.getStringExtra("rating") ?: ""

        // Set data to views
        imageView.setImageResource(imagePath)
        titleTextView.text = title
        priceTextView.text = "Rp ${price}"
        ratingTextView.text = rating
    }
}