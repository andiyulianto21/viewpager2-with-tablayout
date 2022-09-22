package com.daylantern.viewpager2andtablayout

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.daylantern.viewpager2andtablayout.databinding.ItemViewPagerBinding

class ViewPagerAdapter(
    private val imageUrlList: List<String>
): RecyclerView.Adapter<ViewPagerAdapter.ViewPageViewHolder>() {
    inner class ViewPageViewHolder(
        private val binding: ItemViewPagerBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(imageUrl: String){
            Glide.with(binding.root)
                .load(imageUrl)
                .transition(DrawableTransitionOptions.withCrossFade())
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(binding.imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPageViewHolder {
        val binding = ItemViewPagerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewPageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewPageViewHolder, position: Int) {
        holder.bind(imageUrlList[position])
    }

    override fun getItemCount(): Int = imageUrlList.size
}