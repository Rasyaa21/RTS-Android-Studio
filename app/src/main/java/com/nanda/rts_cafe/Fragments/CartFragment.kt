package com.nanda.rts_cafe.Fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nanda.rts_cafe.AdapterCart
import com.nanda.rts_cafe.R
import com.nanda.rts_cafe.SuccessActivity

class CartFragment : Fragment() {

    // Sample list of menu items for the cart (replace with actual data)
    private val menuItems = listOf(
        AdapterCart.MenuItem(
            imagePath = R.drawable.foto, // Replace with actual drawable resource
            title = "Spaghetti Bolognese",
            price = "32.000 IDR",
            stock = 10,
            quantity = 1
        ),
        AdapterCart.MenuItem(
            imagePath = R.drawable.foto, // Replace with actual drawable resource
            title = "Pizza Margherita",
            price = "45.000 IDR",
            stock = 8,
            quantity = 1
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("CartFragment", "Cart opened")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_cart, container, false)

        // Set up RecyclerView
        val recyclerView: RecyclerView = view.findViewById(R.id.cartRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Set Adapter for RecyclerView
        val adapter = AdapterCart(menuItems)
        recyclerView.adapter = adapter

        val checkoutButton: Button = view.findViewById(R.id.checkoutButton)
        checkoutButton.setOnClickListener {
            // Navigate to SuccessActivity when the button is clicked
            val intent = Intent(requireContext(), SuccessActivity::class.java)
            startActivity(intent)
        }

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CartFragment().apply {
                arguments = Bundle().apply {
                    putString("param1", param1)
                    putString("param2", param2)
                }
            }
    }
}