package com.example.apilearn.ViewModel

import androidx.lifecycle.ViewModel

class ProductItemViewModel : ViewModel() {
    val values: MutableList<String> = mutableListOf<String>()

    fun addValue(newValue: String) {
        values.add(newValue)
    }
}