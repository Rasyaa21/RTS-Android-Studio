package com.nanda.rts_cafe

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterCart(
    private val menuItems: List<MenuItem> // List of menu items to display
) : RecyclerView.Adapter<AdapterCart.ViewHolder>() {

    data class MenuItem(
        val imagePath: Int, // Drawable resource ID of the image
        val title: String,  // Name of the item
        val price: String,  // Price of the item
        val stock: Int,     // Stock available for the item
        val quantity: Int   // Quantity to display (static)
    )

    // ViewHolder class
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.cartItemImage)
        val titleTextView: TextView = itemView.findViewById(R.id.cartItemName)
        val priceTextView: TextView = itemView.findViewById(R.id.cartItemPrice)
        val quantityTextView: TextView = itemView.findViewById(R.id.cartItemQuantity)
        val decreaseQuantityButton: ImageView = itemView.findViewById(R.id.btnDecreaseQuantity)
        val increaseQuantityButton: ImageView = itemView.findViewById(R.id.btnIncreaseQuantity)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_cart, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val menuItem = menuItems[position]

        // Bind data to views
        holder.imageView.setImageResource(menuItem.imagePath)
        holder.titleTextView.text = menuItem.title
        holder.priceTextView.text = menuItem.price
        holder.quantityTextView.text = menuItem.quantity.toString()

        // Make the quantity controls static by disabling the buttons
        holder.decreaseQuantityButton.isEnabled = false
        holder.increaseQuantityButton.isEnabled = false
    }

    override fun getItemCount(): Int {
        return menuItems.size
    }
}