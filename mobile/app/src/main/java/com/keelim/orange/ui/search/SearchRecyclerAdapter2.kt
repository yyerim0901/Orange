package com.keelim.orange.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.keelim.orange.R
import com.keelim.orange.data.model.Search
import com.keelim.orange.data.model.Search2
import com.keelim.orange.databinding.ItemSearch2Binding
import com.keelim.orange.ui.feed.SearchRecyclerAdapter

class SearchRecyclerAdapter2(
    val clickListener:(Search2) -> Unit,
): ListAdapter<Search2, SearchRecyclerAdapter2.ViewHolder>(diffUtil) {

    inner class ViewHolder(val binding:ItemSearch2Binding): RecyclerView.ViewHolder(binding.root){
        fun bind(item:Search2) = with(binding){
            imgChallenge.load("https://images.unsplash.com/photo-1520853504280-249b72dc947c?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1234&q=80")
            title.text = item.challengeTitle
            describe.text = item.challengeDescribe
            managerId.text = "관리자 id: ${item.managerId}"
            member.text = "${item.minMembers} ~ ${item.maxMembers} 현재: ${item.currentMembers}"
            startDate.text = "시작 날짜: ${item.startDate}"
            point.text = "종합 포인: ${item.totalPoint}"

            container.setOnClickListener {
                clickListener.invoke(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemSearch2Binding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return holder.bind(currentList[position])
    }

    companion object{
        val diffUtil = object:DiffUtil.ItemCallback<Search2>(){
            override fun areItemsTheSame(oldItem: Search2, newItem: Search2): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Search2, newItem: Search2): Boolean {
                return oldItem == newItem
            }
        }
    }
}