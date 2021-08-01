package com.keelim.orange.ui.profile.favorite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.keelim.orange.data.model.Favorite
import com.keelim.orange.ui.auth.databinding.ItemFavoriteBinding

class FavoriteAdapter(
    val clickListener: () -> Unit,
) : ListAdapter<Favorite, FavoriteAdapter.ViewHolder>(diffUtil) {

    inner class ViewHolder(val binding: ItemFavoriteBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Favorite) = with(binding) {
            favoriteTitle.text = item.title
            favoriteCount.text = item.number
            favoriteImg.load(item.imageLink)
            favoriteRating.text = item.rating.toString()
            favoriteLevel.text = item.level

            root.setOnClickListener {
                clickListener.invoke()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemFavoriteBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Favorite>(){
            override fun areItemsTheSame(oldItem: Favorite, newItem: Favorite): Boolean {
                return oldItem.title == newItem.title
            }

            override fun areContentsTheSame(oldItem: Favorite, newItem: Favorite): Boolean {
                return oldItem.imageLink == newItem.imageLink
            }
        }
    }
}
