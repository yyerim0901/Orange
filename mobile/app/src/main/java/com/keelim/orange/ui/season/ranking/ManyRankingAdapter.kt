package com.keelim.orange.ui.season.ranking

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.keelim.orange.data.model.Ranking
import com.keelim.orange.databinding.ItemBadgeBinding

class ManyRankingAdapter(
) : ListAdapter<Ranking, ManyRankingAdapter.ViewHolder>(diffUtil) {

  inner class ViewHolder(val binding: ItemBadgeBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Ranking) = with(binding) {
      badgeTitle.text = item.ranking_title
      badgeDescription.text = item.ranking_description
      badgeImg.load("https://images.unsplash.com/photo-1613826488066-5a115a53a1fc?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1336&q=80")

    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    return ViewHolder(
      ItemBadgeBinding.inflate(
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
    val diffUtil = object : DiffUtil.ItemCallback<Ranking>() {
      override fun areItemsTheSame(oldItem: Ranking, newItem: Ranking): Boolean {
        return oldItem.image_address == newItem.image_address
      }

      override fun areContentsTheSame(oldItem: Ranking, newItem: Ranking): Boolean {
        return oldItem.image_address == newItem.image_address
      }
    }
  }
}
