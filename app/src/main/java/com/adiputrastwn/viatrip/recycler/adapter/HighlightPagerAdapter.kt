package com.adiputrastwn.viatrip.recycler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adiputrastwn.viatrip.databinding.ViewPagerHighlightBinding
import com.adiputrastwn.viatrip.models.Highlight

class HighlightPagerAdapter :
    RecyclerView.Adapter<HighlightPagerAdapter.HighlightViewHolder>() {

    inner class HighlightViewHolder(binding: ViewPagerHighlightBinding) :
        RecyclerView.ViewHolder(binding.root)

    private var highlights: MutableList<Highlight> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HighlightViewHolder {
        val binding = ViewPagerHighlightBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return HighlightViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HighlightViewHolder, position: Int) {

    }

    fun setHighlights(highlights: List<Highlight>) {
        this.highlights = highlights.toMutableList()
    }

    override fun getItemCount(): Int = highlights.size
}