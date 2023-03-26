package com.example.lab01.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.lab01.databinding.BigItemBinding
import com.example.lab01.databinding.SmallItemBinding

class ItemAdapter(
    private val listener: ClickItemListener
    ) : ListAdapter<Item, RecyclerView.ViewHolder>(MyDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            0 -> {
                val binding = SmallItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent, false)
                SmallItemViewHolder(binding)
            }
            else -> {
                val binding = BigItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent, false)
                BigItemViewHolder(binding)
            }
        }
    }

    inner class SmallItemViewHolder(private val binding: SmallItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun binding(item: Item.SmallItem, listener: ClickItemListener) = with(binding) {
            itemView.setOnClickListener {
                listener.onClick(item)
            }
            avatar.setImageResource(item.avatar)
            header.text = item.header
            subHeader.text = item.subhead
            smallImg.setImageResource(item.image)
        }

    }

    inner class BigItemViewHolder(private val binding: BigItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun binding(item: Item.BigItem, listener: ClickItemListener) = with(binding) {
            itemView.setOnClickListener {
                listener.onClick(item)
            }
            avatar.setImageResource(item.avatar)
            header.text = item.header
            subHeader.text = item.titleSubhead
            imageView.setImageResource(item.image)
            title.text = item.title
            subhead.text = item.subhead
            description.text = item.description
        }

    }

    class MyDiffCallback : DiffUtil.ItemCallback<Item>() {

        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position).viewType) {
            0 -> 0
            else -> 1
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            0 -> (holder as SmallItemViewHolder).binding(getItem(position) as Item.SmallItem, listener)
            else -> (holder as BigItemViewHolder).binding(getItem(position) as Item.BigItem, listener)
        }
    }

    interface ClickItemListener{
        fun onClick(item: Item)
    }
}