package com.example.apilearn.Fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apilearn.Adapter.ProductItemAdopter
import com.example.apilearn.ViewModel.ProductItemViewModel
import com.example.apilearn.databinding.ProductItemsBinding


class ProductItemsFragment : Fragment() {
    private lateinit var productItemsBinding: ProductItemsBinding
    private val productItemViewModel: ProductItemViewModel by viewModels()
    private lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        productItemsBinding = ProductItemsBinding.inflate(inflater, container, false)

        sharedPreferences =
            requireActivity().getSharedPreferences("file_name", Context.MODE_PRIVATE)

        loadSavedList()
        productItemsBinding.rvProductItem.adapter = ProductItemAdopter(productItemViewModel.values)
        productItemsBinding.rvProductItem.layoutManager = LinearLayoutManager(context)

        return productItemsBinding.root
    }

    // Function to load saved list from SharedPreferences
    private fun loadSavedList() {
        val savedListString = sharedPreferences.getString("key", "")
        if (!savedListString.isNullOrEmpty()) {
            val savedList = savedListString.split(",").toList()  // Convert string back to list
            productItemViewModel.values.addAll(savedList)
            Log.d("appointmentFragment", "Loaded List: $savedList")
        }
    }

}