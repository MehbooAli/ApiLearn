package com.example.apilearn.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.apilearn.R

class ProductItemAdopter(val value: List<String>) :
    RecyclerView.Adapter<ProductItemAdopter.ProductItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.listview_design, parent, false)
        return ProductItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return value.size
    }

    override fun onBindViewHolder(holder: ProductItemViewHolder, position: Int) {
        holder.titleText.text = value[position]
    }

    class ProductItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var titleText = itemView.findViewById<TextView>(R.id.tv)
    }
}

