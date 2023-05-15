package com.example.catsbreeds.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.catsbreeds.R
import com.example.catsbreeds.databinding.CatItemBinding
import com.example.catsbreeds.domain.model.Cat

open class CatAdapter(
    private val mCatModels: List<Cat>
) : RecyclerView.Adapter<CatAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.cat_item, parent, false))
    }

    override fun getItemCount(): Int {
        return mCatModels.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mCatModels[position]
        holder.bind(item)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = CatItemBinding.bind(itemView)
        fun bind(cat: Cat) {
            binding.catbreed.text = cat.breedName
            binding.origin.text = cat.origin
            binding.intelligence.text = cat.intelligence.toString()

            if (cat.reference_image_id.isNullOrEmpty()) {
                Glide.with(itemView).load(R.drawable.cat).into(binding.image)
            } else {
                //https://cdn2.thecatapi.com/images/0XYvRd7oD.jpg
                Glide.with(itemView).load("https://cdn2.thecatapi.com/images/${cat.reference_image_id}.jpg")
                    .fitCenter()
                    .into(binding.image)
            }
        }
    }
}