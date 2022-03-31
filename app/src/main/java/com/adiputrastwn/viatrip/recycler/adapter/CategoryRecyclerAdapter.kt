package com.adiputrastwn.viatrip.recycler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adiputrastwn.viatrip.databinding.ViewRecyclerCategoryBinding

class CategoryRecyclerAdapter :
    RecyclerView.Adapter<CategoryRecyclerAdapter.CategoryViewHolder>() {


    inner class CategoryViewHolder(binding: ViewRecyclerCategoryBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = ViewRecyclerCategoryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {

    }

    override fun getItemCount(): Int = 12
}