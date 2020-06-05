package com.ugurkuyu.otelapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ugurkuyu.otelapp.databinding.ItemLayoutBinding
import com.ugurkuyu.otelapp.model.Hotels

class OtelAdapter : ListAdapter<Hotels, OtelAdapter.ViewHolder>(DIFF_CALLBACK) {

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Hotels>() {
            override fun areItemsTheSame(oldItem: Hotels, newItem: Hotels): Boolean =
                oldItem.id == newItem.id


            override fun areContentsTheSame(oldItem: Hotels, newItem: Hotels): Boolean =
                oldItem.details.name == newItem.details.name
        }
    }

    class ViewHolder(private val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun create(inflater: LayoutInflater, parent: ViewGroup): ViewHolder {
                val itemLayoutBinding = ItemLayoutBinding.inflate(inflater, parent, false)
                return ViewHolder(itemLayoutBinding)
            }
        }

        fun bind(otels: Hotels) {
            binding.otel = otels
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder.create(
            LayoutInflater.from(parent.context), parent
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(getItem(position))
}