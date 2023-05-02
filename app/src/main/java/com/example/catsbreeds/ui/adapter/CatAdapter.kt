package com.example.catsbreeds.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.RecyclerView
import com.example.catsbreeds.R
import com.example.catsbreeds.data.model.CatModel
import com.example.catsbreeds.databinding.CatItemBinding
import com.example.catsbreeds.domain.model.Cat

open class CatAdapter(
    private val mCatModels: List<Cat>,
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
        fun bind(cat: Cat){
            binding.catbreed.text = cat.breedName
            binding.origin.text = cat.origin
            binding.intelligence.text = cat.intelligence.toString()
            binding.image.setImageResource(R.drawable.cat)

        }
    }
}