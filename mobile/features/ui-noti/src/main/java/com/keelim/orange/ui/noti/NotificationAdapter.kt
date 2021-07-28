package com.keelim.orange.ui.noti

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.keelim.orange.data.model.Notification
import com.keelim.orange.ui.noti.databinding.ItemNotificationBinding

class NotificationAdapter(
  val clickListener: () -> Unit,
) : ListAdapter<Notification, NotificationAdapter.ViewHolder>(diffUtil) {

  inner class ViewHolder(val binding: ItemNotificationBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Notification) = with(binding) {
      title.text = item.title
      description.text = item.description

      root.setOnClickListener {
        clickListener.invoke()
      }
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    return ViewHolder(
      ItemNotificationBinding.inflate(
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
    val diffUtil = object : DiffUtil.ItemCallback<Notification>() {
      override fun areItemsTheSame(oldItem: Notification, newItem: Notification): Boolean {
        return oldItem == newItem
      }

      override fun areContentsTheSame(oldItem: Notification, newItem: Notification): Boolean {
        return oldItem == newItem
      }
    }
  }
}
