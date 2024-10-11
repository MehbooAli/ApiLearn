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
import androidx.navigation.fragment.findNavController
import com.example.apilearn.R
import com.example.apilearn.ViewModel.ProductItemViewModel
import com.example.apilearn.databinding.AppointmentScreenBinding

class AppointmentFragment : Fragment() {
    private lateinit var appointmentScreenBinding: AppointmentScreenBinding
    val productItemViewModel: ProductItemViewModel by viewModels()
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        appointmentScreenBinding = AppointmentScreenBinding.inflate(inflater, container, false)

        sharedPreferences =
            requireActivity().getSharedPreferences("file_name", Context.MODE_PRIVATE)

//        loadSavedList()
        goProductItemPage()
        addButton()
        return appointmentScreenBinding.root
    }

    private fun addButton() {
        appointmentScreenBinding.btnAdd.setOnClickListener {
            val editText = appointmentScreenBinding.editText.text.toString().trim()
                .replace("\\s".toRegex(), "")

            if (editText.isNotEmpty()) {
                productItemViewModel.addValue(editText)

                // Store value in sharedPreferences
                sharedPreferences.edit().putString("key", editText).apply()
                saveListToSharedPreferences(productItemViewModel.values)

                // Clear the EditText after adding
                appointmentScreenBinding.editText.setText("")
                appointmentScreenBinding.editText.clearFocus()

                Log.d(
                    "appointmentFragment",
                    "Add Button: $editText and ${productItemViewModel.values}"
                )
            }
        }
    }

    private fun goProductItemPage() {
        appointmentScreenBinding.btnNextPage.setOnClickListener {
            findNavController().navigate(R.id.action_appointmentFragment_to_productItemsFragment)

            // Fetch data from sharedPreferences
//            val storedData = sharedPreferences.getString("key", "")
//            Log.d("appointmentFragment", "get Data: $storedData")
        }
    }

    // Save list to SharedPreferences
    private fun saveListToSharedPreferences(list: List<String>) {
        val editor = sharedPreferences.edit()
        val listString = list.joinToString(",")
        editor.putString("key", listString)
        editor.apply()
    }

    // Function to load saved list from SharedPreferences
//    private fun loadSavedList() {
//        val savedListString = sharedPreferences.getString("key", "")
//        if (!savedListString.isNullOrEmpty()) {
//            val savedList = savedListString.split(",").toList()  // Convert string back to list
//            productItemViewModel.values.addAll(savedList)
//            Log.d("appointmentFragment", "Loaded List: $savedList")
//        }
//    }
}
