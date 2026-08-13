package com.example.jadwalbis20.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.jadwalbis20.databinding.ItemBusBinding
import com.example.jadwalbis20.databinding.ItemHeaderBinding
import com.example.jadwalbis20.model.BusItem

class BusListAdapter : ListAdapter<BusItem, RecyclerView.ViewHolder>(BusDiffCallback()) {

    companion object {
        private const val TYPE_HEADER = 0
        private const val TYPE_BUS = 1
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is BusItem.Header -> TYPE_HEADER
            is BusItem.BusInfo -> TYPE_BUS
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            TYPE_HEADER -> {
                val binding = ItemHeaderBinding.inflate(layoutInflater, parent, false)
                HeaderViewHolder(binding)
            }
            TYPE_BUS -> {
                val binding = ItemBusBinding.inflate(layoutInflater, parent, false)
                BusViewHolder(binding)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position) ?: return
        when (holder) {
            is HeaderViewHolder -> holder.bind(item as BusItem.Header)
            is BusViewHolder -> holder.bind(item as BusItem.BusInfo)
        }
    }

    class HeaderViewHolder(private val binding: ItemHeaderBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(header: BusItem.Header) {
            binding.tvHeaderTitle.text = header.title
        }
    }

    class BusViewHolder(private val binding: ItemBusBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(bus: BusItem.BusInfo) {
            binding.tvBusName.text = bus.name
            binding.tvBusDestination.text = "Tujuan: ${bus.destination}"
            binding.tvBusDeparture.text = "Berangkat: ${bus.departureTime}"
            binding.tvBusArrival.text = "Datang: ${bus.arrivalTime}"
        }
    }

    class BusDiffCallback : DiffUtil.ItemCallback<BusItem>() {
        override fun areItemsTheSame(oldItem: BusItem, newItem: BusItem): Boolean {
            return if (oldItem is BusItem.Header && newItem is BusItem.Header) {
                oldItem.title == newItem.title
            } else if (oldItem is BusItem.BusInfo && newItem is BusItem.BusInfo) {
                oldItem.id == newItem.id
            } else {
                false
            }
        }

        override fun areContentsTheSame(oldItem: BusItem, newItem: BusItem): Boolean {
            return oldItem == newItem
        }
    }
}
