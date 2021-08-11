package com.keelim.orange.ui.profile.badge.all

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.keelim.orange.data.model.Badge
import com.keelim.orange.databinding.ItemBadgeBinding

class BadgeAdapter(
  val clickListener: () -> Unit,
) : ListAdapter<Badge, BadgeAdapter.ViewHolder>(diffUtil) {

  inner class ViewHolder(val binding: ItemBadgeBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Badge) = with(binding) {
      badgeTitle.text = item.title
      badgeDescription.text = item.description
      badgeImg.load("https://images.unsplash.com/photo-1613826488066-5a115a53a1fc?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1336&q=80")

      root.setOnClickListener {
        clickListener.invoke()
      }
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
    val diffUtil = object : DiffUtil.ItemCallback<Badge>() {
      override fun areItemsTheSame(oldItem: Badge, newItem: Badge): Boolean {
        return oldItem.title == newItem.title
      }

      override fun areContentsTheSame(oldItem: Badge, newItem: Badge): Boolean {
        return oldItem.image_path == newItem.image_path
      }
    }
  }
}
