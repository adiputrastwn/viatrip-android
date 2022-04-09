package com.adiputrastwn.viatrip.recycler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adiputrastwn.viatrip.databinding.ViewPagerHighlightBinding
import com.adiputrastwn.viatrip.models.Highlight
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory

class HighlightPagerAdapter :
    RecyclerView.Adapter<HighlightPagerAdapter.HighlightViewHolder>() {

    val factory: DrawableCrossFadeFactory =
        DrawableCrossFadeFactory.Builder().setCrossFadeEnabled(true).build()

    inner class HighlightViewHolder(private val binding: ViewPagerHighlightBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.imageBackground.apply {
                Glide
                    .with(itemView.context)
                    .load("https://www.travelercantik.com/wp-content/uploads/2019/04/pantai-hotel-Kila-Senggigi.jpg")
                    .transition(withCrossFade(factory))
                    .centerCrop()
                    .into(this)
            }
        }
    }

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
        holder.bind()
    }

    fun setHighlights(highlights: List<Highlight>) {
        this.highlights = highlights.toMutableList()
    }

    override fun getItemCount(): Int = highlights.size
}