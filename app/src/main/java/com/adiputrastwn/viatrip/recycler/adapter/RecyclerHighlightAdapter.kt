package com.adiputrastwn.viatrip.recycler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adiputrastwn.viatrip.databinding.RecyclerViewItemHighlightBinding

class RecyclerHighlightAdapter :
    RecyclerView.Adapter<RecyclerHighlightAdapter.HighlightViewHolder>() {


    inner class HighlightViewHolder(binding: RecyclerViewItemHighlightBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HighlightViewHolder {
        val binding = RecyclerViewItemHighlightBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return HighlightViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HighlightViewHolder, position: Int) {

    }

    override fun getItemCount(): Int = 12
}