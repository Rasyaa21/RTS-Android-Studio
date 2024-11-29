package com.example.appname

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nanda.rts_cafe.DetailActivity
import com.nanda.rts_cafe.R

class Adapter(private val menuItems: List<MenuItem>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    // Data class for menu item
    data class MenuItem(
        val imagePath: Int, // Drawable resource ID of the image
        val title: String,
        val price: String,
        val rating: String
    )

    // ViewHolder class
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.image)
        val titleTextView: TextView = itemView.findViewById(R.id.nama)
        val priceTextView: TextView = itemView.findViewById(R.id.harga)
        val ratingTextView: TextView = itemView.findViewById(R.id.rating)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view, parent, false) // Replace with your layout file name
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val menuItem = menuItems[position]

        // Bind data to views
        holder.imageView.setImageResource(menuItem.imagePath)
        holder.titleTextView.text = menuItem.title
        holder.priceTextView.text = menuItem.price
        holder.ratingTextView.text = menuItem.rating

        // Set onClickListener to navigate to DetailActivity
        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, DetailActivity::class.java).apply {
                putExtra("imagePath", menuItem.imagePath)
                putExtra("title", menuItem.title)
                putExtra("price", menuItem.price)
                putExtra("rating", menuItem.rating)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return menuItems.size
    }
}